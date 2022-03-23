package gRPC.Project.SmartOffice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BugServer extends BugReportingServiceImplBase{

	public static void main(String[] args) throws SocketException {
		
		System.out.println("Starting up Bug Reporting Service...");
		
		BugServer bugServer = new BugServer();
		
		Properties prop = bugServer.getProperties();
		
		bugServer.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));

		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(bugServer)
					.build()
					.start();
			System.out.println("Bug Reporting Server listening on port " + port + "...");
			server.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private void registerService(Properties prop) {
		
		
			try {
				
				JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
				
				String service_type = prop.getProperty("service_type");
				String service_name = prop.getProperty("service_name");
//				String service_description = prop.getProperty("service_description");
				int service_port = Integer.valueOf(prop.getProperty("service_port"));
				String service_description_properties = prop.getProperty("service_description");
				
				// register service
				ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
				jmdns.registerService(serviceInfo);
				
				System.out.println("Registering Bug Service...");
				System.out.println("Type: " + service_type);
				System.out.println("Name: " + service_name);
				
				Thread.sleep(500);;
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	private Properties getProperties() {
		
		Properties prop = null;
		
		try(InputStream input = new FileInputStream("src/main/resources/bugs.properties")){
			
			prop = new Properties();
			
			prop.load(input);
			
			System.out.println("-----------Bug Service Properties------------");
			System.out.println("Service Type: " + prop.getProperty("service_type"));
			System.out.println("Service Name: " + prop.getProperty("service_name"));
			System.out.println("Service Description: " + prop.getProperty("service_description"));
			System.out.println("Service Port: " + prop.getProperty("service_port"));
			System.out.println("----------------------------------------------");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

	// Unary RPC
	@Override
	public void logIn(LogRequest request, StreamObserver<LogResponse> responseObserver) {

		String name = request.getName();
		String password = request.getPassword();
		String message = "ERROR";
		boolean success = false;

		System.out.println(name + ", " + password);

		if ((name.equals("Adam Jensen")) && (password.equals("0451"))) {
			success = true;
			message = "You have successfully logged in, " + name;
			System.out.println("Successfully logged in " + name);
		} else {
			success = false;
			message = "This username and/or password does not exist.";
			System.out.println("Failed to log in " + name);
		}

		LogResponse reply = LogResponse.newBuilder().setSuccess(success).setMessage(message).build();

		// return message with response
		responseObserver.onNext(reply);

		// notify complete
		responseObserver.onCompleted();
	}

	// Client Streaming
	@Override
	public void getBugList(ListRequest request, StreamObserver<ListResponse> responseObserver) {

		String[] bugTitles;
		bugTitles = new String[] { "Balancing", "Design", "Physics", "Design" };

		String[] bugDetails;
		bugDetails = new String[] { "XP gain not high enough...", "Area not clear enough for player...",
				"Falling through the ground at this location...", "Level is too complicated..." };

		String[] bugReporters;
		bugReporters = new String[] { "John Jones", "Bill Bones", "Allan Stones", "Bill Bones" };

		int[] bugSeverities;
		bugSeverities = new int[] { 1, 2, 5, 3 };
		
		int numberRequested = request.getQuantity();

		// error handling - catch out of bounds error (user requesting more bugs than we have)		
		if(numberRequested > bugTitles.length) {
			numberRequested = bugTitles.length;
		}

		if (numberRequested > 0) {
			for (int i = 0; i < numberRequested; i++) {

				ListResponse reply = ListResponse.newBuilder()
						.setTitle(bugTitles[i])
						.setDetails(bugDetails[i])
						.setSeverity(bugSeverities[i])
						.setReportedBy(bugReporters[i])
						.build();

				responseObserver.onNext(reply);

//				 2 second delay
				try {
					Thread.currentThread();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Error: Invalid amount requested.");
		}

		responseObserver.onCompleted();

	}

	// Bi-directional Streaming
	@Override
	public StreamObserver<NewBugs> postBugs(StreamObserver<ListResponse> responseObserver) {

		// ADD FUNCTIONALITY - get employee name dynamically
		// Test comment
		String name = "Adam Jensen";

		// hypothetical database
		ArrayList<String> bugTitles = new ArrayList<>();
		ArrayList<String> bugDetails = new ArrayList<>();
		ArrayList<Integer> bugSeverities = new ArrayList<>();
		ArrayList<String> bugReporters = new ArrayList<>();

		return new StreamObserver<NewBugs>() {

			@Override
			public void onNext(NewBugs request) {

				// store data in a hypothetical database
				bugTitles.add(request.getTitle());
				bugDetails.add(request.getDetails());
				bugSeverities.add(request.getSeverity());
				bugReporters.add(name);

				// retrieve data for response
				String title = bugTitles.get(bugTitles.size() - 1);
				String details = bugDetails.get(bugDetails.size() - 1);
				int severity = bugSeverities.get(bugSeverities.size() - 1);
				String reporter = bugReporters.get(bugReporters.size() - 1);

				System.out.println("Adding new bug...");
				System.out.println("Title: " + title);
				System.out.println("Details: " + details);
				System.out.println("Severity: " + severity);
				System.out.println("Reported By: " + reporter);

				if (severity > 2) {
					System.out.println("A severe bug (level " + severity + ") has been reported by " + reporter);
					System.out.println("This bug is beig pushed to an available employee ...");
					// push bug to existing employee profile
				}

				// creating and sending response
				ListResponse reply = ListResponse.newBuilder().setTitle(title).setDetails(details).setSeverity(severity)
						.setReportedBy(reporter).build();

				responseObserver.onNext(reply);

			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();

			}

			@Override
			public void onCompleted() {

				System.out.println("Bugs upload completed.");

				responseObserver.onCompleted();

			}

		};
	}

// Server Streaming example

//	@Override
//	public StreamObserver<NewBugs> postBugs(StreamObserver<LogResponse> responseObserver) {
//		
//		// ADD FUNCTIONALITY - get employee name dynamically
//		// Test comment
//		String name = "Keith";
//		
//		ArrayList<String> bugTitles = new ArrayList<>();
//		ArrayList<String> bugDetails = new ArrayList<>();
//		ArrayList<Integer> bugSeverities = new ArrayList<>();
//		ArrayList<String> bugReporters = new ArrayList<>();
//		
//		
//		return new StreamObserver<NewBugs>(){
//
//			@Override
//			public void onNext(NewBugs request) {
//				
//				
//				bugTitles.add(request.getTitle());
//				bugDetails.add(request.getDetails());
//				bugSeverities.add(request.getSeverity());
//				bugReporters.add(name);
//				
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onCompleted() {
//				
//				String message = "Bugs added successfully.";
//				
//				LogResponse reply = LogResponse.newBuilder()
//						.setSuccess(true)
//						.setMessage(message)
//						.build();
//				
//				responseObserver.onNext(reply);
//				
//				responseObserver.onCompleted();
//				
//			}
//			
//		};
//	}

}
