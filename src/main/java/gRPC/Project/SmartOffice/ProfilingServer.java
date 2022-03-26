package gRPC.Project.SmartOffice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import gRPC.Project.SmartOffice.ProfilingServiceGrpc.ProfilingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ProfilingServer extends ProfilingServiceImplBase {

	public static void main(String[] args) {

		System.out.println("Starting up Employee Profilng Service...");

		ProfilingServer profilingServer = new ProfilingServer();

		Properties prop = profilingServer.getProperties();

		profilingServer.registerService(prop);

		int port = Integer.valueOf(prop.getProperty("service_port"));

		try {

			Server server = ServerBuilder.forPort(port).addService(profilingServer).build().start();
			System.out.println("Employee Profiling Server listening on port " + port + "...");
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
			int service_port = Integer.valueOf(prop.getProperty("service_port"));
			String service_description_properties = prop.getProperty("service_description");

			// register service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);

			System.out.println("Registered Profiling Service.");
			System.out.println("Type: " + service_type);
			System.out.println("Name: " + service_name);

			Thread.sleep(200);
			;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	private Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/profiling.properties")) {

			prop = new Properties();

			prop.load(input);

			System.out.println("--------Employee Profiling Service Properties--------");
			System.out.println("Service Type: " + prop.getProperty("service_type"));
			System.out.println("Service Name: " + prop.getProperty("service_name"));
			System.out.println("Service Description: " + prop.getProperty("service_description"));
			System.out.println("Service Port: " + prop.getProperty("service_port"));
			System.out.println("----------------------------------------------");
			System.out.println("Registering Employee Profiling Service...");
		} catch (IOException e) {
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

		System.out.println("User log in attempt with properties...");
		System.out.println("Name: " + name);
		System.out.println("Password: " + password);

		if ((name.equals("Adam Jensen")) && (password.equals("0451"))) {
			success = true;
			message = name + "has been logged in.";
			System.out.println("Successfully logged in " + name);
		} else {
			success = false;
			message = "Failed log in attempt recorded.";
			System.out.println("Failed to log in " + name);
		}

		LogResponse reply = LogResponse.newBuilder().setSuccess(success).setMessage(message).build();

		// return message with response
		responseObserver.onNext(reply);

		// notify complete
		responseObserver.onCompleted();
	}

	@Override
	public void getEmployeeList(eListRequest request, StreamObserver<eListResponse> responseObserver) {

		String[] eNames;
		eNames = new String[] { "Adam Jensen", "Eric Garcia", "Frenkie De Jong", "Gerard Pique", "Lionel Messi" };

		String[] jobs;
		jobs = new String[] { "Manager", "Level Design", "Creative Director", "Art", "Animation" };

		Boolean[] busy;
		busy = new Boolean[] { false, true, false, false, false };

		int[] tasksAssigned; // Bug ID
		tasksAssigned = new int[] { 0, 2, 0, 0, 0 };

		int id = request.getId();

		if ((id > 0) && (id < 5)) {

			eListResponse reply = eListResponse.newBuilder().setName(eNames[id]).setJob(jobs[id]).setBusy(busy[id])
					.setTask(tasksAssigned[id]).build();
			responseObserver.onNext(reply);

//					 2 second delay
			try {
				Thread.currentThread();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Error: Invalid ID requested.");
		}

		responseObserver.onCompleted();

	}

	@Override
	public void getAllEmployeeList(eListRequest request, StreamObserver<eListResponse> responseObserver) {

		String[] eNames;
		eNames = new String[] { "Adam Jensen", "Eric Garcia", "Frenkie De Jong", "Gerard Pique", "Lionel Messi" };

		String[] jobs;
		jobs = new String[] { "Manager", "Level Design", "Creative Director", "Art", "Animation" };

		Boolean[] busy;
		busy = new Boolean[] { false, true, false, false, false };

		int[] tasksAssigned;
		tasksAssigned = new int[] { 0, 2, 0, 0, 0 };

		for (int i = 1; i < eNames.length; i++) {
			eListResponse reply = eListResponse.newBuilder().setName(eNames[i]).setJob(jobs[i]).setBusy(busy[i])
					.setTask(tasksAssigned[i]).build();
			responseObserver.onNext(reply);
		}

//						 2 second delay
		try {
			Thread.currentThread();
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		responseObserver.onCompleted();

	}

}
