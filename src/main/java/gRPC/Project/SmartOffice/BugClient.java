package gRPC.Project.SmartOffice;

import java.util.Iterator;

import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceBlockingStub;
import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceStub;
import gRPC.Project.SmartOffice.ProfilingServiceGrpc.ProfilingServiceBlockingStub;
import gRPC.Project.SmartOffice.ProfilingServiceGrpc.ProfilingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;

public class BugClient {

	private static BugReportingServiceBlockingStub bugBlockingStub;
	private static BugReportingServiceStub bugASyncStub;
	
	private static ProfilingServiceBlockingStub profileBlockingStub;
	private static ProfilingServiceStub profileASyncStub;

	public static void main(String[] args) throws InterruptedException {

		// set up bug channel
		ManagedChannel BugChannel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		// set up profile channel
				ManagedChannel profileChannel = ManagedChannelBuilder
						.forAddress("localhost", 50051)
						.usePlaintext()
						.build();

		// create bug stubs
		bugBlockingStub = BugReportingServiceGrpc.newBlockingStub(BugChannel);
		bugASyncStub = BugReportingServiceGrpc.newStub(BugChannel);
		
		// create bug stubs
		profileBlockingStub = ProfilingServiceGrpc.newBlockingStub(profileChannel);
		profileASyncStub = ProfilingServiceGrpc.newStub(profileChannel);
		
		

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
				count += 1;
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Upload complete. "+ count+ " new bugs have been posted.");
			}
		};

	}

	// Unary RPC
	public static void logInBlocking() {

		System.out.println("Logging in...");

		String name = "Adam Jensen";
		String password = "0451";

		LogRequest req = LogRequest.newBuilder().setName(name).setPassword(password).build();

		LogResponse response = profileBlockingStub.logIn(req);
		System.out.println("Response: " + response);

	}

	// Server Streaming RPC
	private static void getBugList() {
		
		int amountRequested = 0;

		ListRequest request = ListRequest.newBuilder()
				.setQuantity(amountRequested)
				.build();

		Iterator<ListResponse> responses = bugBlockingStub.getBugList(request);

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
