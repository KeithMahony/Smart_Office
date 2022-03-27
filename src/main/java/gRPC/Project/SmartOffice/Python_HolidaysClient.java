package gRPC.Project.SmartOffice;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import gRPC.Project.SmartOffice.TimeOffServiceGrpc.TimeOffServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Python_HolidaysClient {
	
	private static final Logger logger = Logger.getLogger(Python_HolidaysClient.class.getName());

	public static void main(String[] args) {

		String host = "localhost";
		int port = 50053;
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		TimeOffServiceBlockingStub  blockingStub = TimeOffServiceGrpc.newBlockingStub(channel);
		
	    Python_HolidaysClient client = new Python_HolidaysClient();
		
		try {
	    	 int id = 1;
	    	 IdRequest request = IdRequest.newBuilder().setId(id).build();
	    	 
	    	 BalanceReply response = blockingStub.getBalance(request);
	    	 
	    	 logger.info("Greeting: " + response.getBalance());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	}

}
