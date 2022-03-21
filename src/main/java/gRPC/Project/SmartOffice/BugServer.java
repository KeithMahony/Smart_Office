package gRPC.Project.SmartOffice;

import java.io.IOException;
import java.util.ArrayList;

import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BugServer extends BugReportingServiceImplBase {

	public static void main(String[] args) {

		BugServer bugServer = new BugServer();

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port).addService(bugServer).build().start();

			System.out.println("Server listening on port " + port + "...");

			server.awaitTermination();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void logIn(LogRequest request, StreamObserver<LogResponse> responseObserver) {

		String name = request.getName();
		String password = request.getPassword();
		String message = "ERROR";
		boolean success = false;

		System.out.println(name + ", " + password);

		if ((name.equals("Keith")) && (password.equals("password"))) {
			success = true;
			message = "You have successfully logged in, " + name;
		} else {
			success = false;
			message = "This username and/or password does not exist.";
		}

		LogResponse reply = LogResponse.newBuilder().setSuccess(success).setMessage(message).build();

		// return message with response
		responseObserver.onNext(reply);

		// notify complete
		responseObserver.onCompleted();
	}

	@Override
	public void getBugList(ListRequest request, StreamObserver<ListResponse> responseObserver) {

		String[] bugTitles;
		bugTitles = new String[] { "Balancing", "Design", "Physics" };

		String[] bugDetails;
		bugDetails = new String[] { "XP gain not high enough...", "Area not clear enough for player...",
				"Falling through the ground at this location..." };

		String[] bugReporters;
		bugReporters = new String[] { "john", "bill", "allan" };

		int[] bugSeverities;
		bugSeverities = new int[] { 1, 2, 5 };

		// catch out of bounds error (user requesting more bugs than we have)
		try {
			for (int i = 0; i < request.getQuantity(); i++) {

				ListResponse reply = ListResponse.newBuilder().setTitle(bugTitles[i]).setDetails(bugDetails[i])
						.setSeverity(bugSeverities[i]).setReportedBy(bugReporters[i]).build();

				responseObserver.onNext(reply);

				// 2 second delay
				try {
					Thread.currentThread();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		responseObserver.onCompleted();

	}

	@Override
	public StreamObserver<NewBugs> postBugs(StreamObserver<LogResponse> responseObserver) {
		
		// ADD FUNCTIONALITY - get employee name dynamically
		// Test comment
		String name = "Keith";
		
		ArrayList<String> bugTitles = new ArrayList<>();
		ArrayList<String> bugDetails = new ArrayList<>();
		ArrayList<Integer> bugSeverities = new ArrayList<>();
		ArrayList<String> bugReporters = new ArrayList<>();
		
		
		return new StreamObserver<NewBugs>(){

			@Override
			public void onNext(NewBugs request) {
				
				
				bugTitles.add(request.getTitle());
				bugDetails.add(request.getDetails());
				bugSeverities.add(request.getSeverity());
				bugReporters.add(name);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				
				String message = "Bugs added successfully.";
				
				LogResponse reply = LogResponse.newBuilder()
						.setSuccess(true)
						.setMessage(message)
						.build();
				
				responseObserver.onNext(reply);
				
				responseObserver.onCompleted();
				
			}
			
		};
	}

}
