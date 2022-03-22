package gRPC.Project.SmartOffice;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {

	public static void main(String[] args) {
		
		try {
			
			// create instance of JmDNS
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			System.out.println(InetAddress.getLocalHost());
			
			// register service
			String service_type = "_http._tcp.local.";
			String service_name = "TestName";
			int service_port = 1234;
			String service_desc = "Example service description.";
			
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
			jmdns.registerService(serviceInfo);
			
			System.out.println("Resistering service... \n Type: " + service_type + ", \n Name: " + service_name);
			
			// wait a while
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jmdns.unregisterAllServices();
			
			}
		catch (IOException e) {
			e.printStackTrace();	
		}

	}

}
