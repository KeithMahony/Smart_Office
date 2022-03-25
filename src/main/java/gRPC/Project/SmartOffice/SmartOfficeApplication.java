package gRPC.Project.SmartOffice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceBlockingStub;
import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceStub;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//import ds.examples.maths.CalculateRequest.Operation;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class SmartOfficeApplication  {

	private static BugReportingServiceBlockingStub blockingStub;
	private static BugReportingServiceStub asyncStub;

	private ServiceInfo bugServiceInfo;
	
	
	private JFrame frame;
	private JTextField name;
	private JTextField password;
	private JTextField p;
	private JTextArea textResponse ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartOfficeApplication window = new SmartOfficeApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmartOfficeApplication() {
		
		String bug_service_type = "_bugs._tcp.local.";
		discoverBugService(bug_service_type);
		
		String host = bugServiceInfo.getHostAddresses()[0];
		int port = bugServiceInfo.getPort();
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();

		//stubs -- generate from proto
		blockingStub = BugReportingServiceGrpc.newBlockingStub(channel);

		asyncStub = BugReportingServiceGrpc.newStub(channel);

		
		initialize();
	}

	
	
	private void discoverBugService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Bug Reporting Service resolved: " + event.getInfo());

					bugServiceInfo = event.getInfo();

					int port = bugServiceInfo.getPort();
					
					System.out.println("Resolving " + service_type + " with properties ...");
					System.out.println("Port: " + port);
					System.out.println("Type:"+ event.getType());
					System.out.println("Name: " + event.getName());
					System.out.println("Description/properties: " + bugServiceInfo.getNiceTextString());
					System.out.println("Host: " + bugServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Bug Reporting Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Bug Reporting Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Smart Office Application");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name:");
		panel_service_1.add(lblNewLabel_1);
		
		name = new JTextField();
		panel_service_1.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter password:");
		panel_service_1.add(lblNewLabel_2);
		
		password = new JTextField();
		panel_service_1.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter p:");
		panel_service_1.add(lblNewLabel_3);
		
		p = new JTextField();
		panel_service_1.add(p);
		p.setColumns(10);
		
		
//		JComboBox comboOperation = new JComboBox();
//		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
//		panel_service_1.add(comboOperation);
//	
		
		JButton btnCalculate = new JButton("Sign In");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				int num1 = Integer.parseInt(textNumber1.getText());
//				int num2 = Integer.parseInt(textNumber2.getText());
				
				String nameEntry = name.getText();
				String passwordEntry = password.getText();

//				int index = comboOperation.getSelectedIndex();
//				Operation operation = Operation.forNumber(index);
				
				LogRequest req = LogRequest.newBuilder()
						.setName(nameEntry)
						.setPassword(passwordEntry)
						.build();

				LogResponse response = blockingStub.logIn(req);

//				textResponse.append("Success?: "+ response.getSuccess() + " Message: "+ response.getMessage() + "\n");
				textResponse.append("Message: "+ response.getMessage());
				
				System.out.println("Success?: "+ response.getSuccess() + " Message: "+ response.getMessage() + "\n");

			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponse = new JTextArea(10, 25);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		
		
		
	}

}
