package gRPC.Project.SmartOffice;

import java.util.Iterator;

import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceBlockingStub;
import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;

public class BugClient {

	private static BugReportingServiceBlockingStub blockingStub;
	private static BugReportingServiceStub aSyncStub;

	public static void main(String[] args) throws InterruptedException {

		// set up channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();

		// create stubs
		blockingStub = BugReportingServiceGrpc.newBlockingStub(channel);
		aSyncStub = BugReportingServiceGrpc.newStub(channel);

		// connect to and use server
		
//		logInBlocking();

//		postBugs();

		getBugList();

	}

	// Bi-directional Streaming RPC
	private static void postBugs() {
		
		StreamObserver<NewBugs> responseObserver = new StreamObserver<NewBugs>() {
			
			int count = 0;

			@Override
			public void onNext(NewBugs value) {
				
				System.out.println("Recieving bug ");
				value.getTitle();
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		};

	}

	// Unary RPC
	public static void logInBlocking() {

		System.out.println("Logging in...");

		String name = "Adam Jensen";
		String password = "0451";

		LogRequest req = LogRequest.newBuilder().setName(name).setPassword(password).build();

		LogResponse response = blockingStub.logIn(req);
		System.out.println("Response: " + response);

	}

	// Server Streaming RPC
	private static void getBugList() {
		
		int amountRequested = 0;

		ListRequest request = ListRequest.newBuilder()
				.setQuantity(amountRequested)
				.build();

		Iterator<ListResponse> responses = blockingStub.getBugList(request);

		while (responses.hasNext()) {
			ListResponse temp = responses.next();
			System.out.println("-----------Bug-----------");
			System.out.println("Title: " + temp.getTitle());
			System.out.println("Details: " + temp.getDetails());
			System.out.println("Severity: " + temp.getSeverity());
			System.out.println("Reported By: " + temp.getReportedBy());
		}
	}

}
