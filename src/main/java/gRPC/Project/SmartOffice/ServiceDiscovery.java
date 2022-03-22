package gRPC.Project.SmartOffice;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class ServiceDiscovery {

	public static void main(String[] args) {
		
		String service_type = "_http._tcp.local.";
		
		try {
			
			// create instance of JmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			System.out.println(InetAddress.getLocalHost());
			
			// add service listener
			jmdns.addServiceListener(service_type, new OfficeServiceListener());
			
			// wait
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			jmdns.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static class OfficeServiceListener implements ServiceListener{

		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added: " + event.getInfo());
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed: " + event.getInfo());
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved: " + event.getInfo());
		}
		
	}

}
