package gRPC.Project.SmartOffice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

//import ds.examples.maths.ConvertMessage;
import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceBlockingStub;
import gRPC.Project.SmartOffice.BugReportingServiceGrpc.BugReportingServiceStub;
import gRPC.Project.SmartOffice.ProfilingServiceGrpc.ProfilingServiceBlockingStub;
import gRPC.Project.SmartOffice.ProfilingServiceGrpc.ProfilingServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Color;

public class OfficeApplication extends JFrame {

	private static BugReportingServiceBlockingStub bugBlockingStub;
	private static BugReportingServiceStub bugAsyncStub;
	private static ProfilingServiceBlockingStub profileBlockingStub;
	private static ProfilingServiceStub profileASyncStub;

	private ServiceInfo bugServiceInfo;
	private ServiceInfo profileServiceInfo;

	private JFrame frame;
	private JPanel contentPane;
	private JTextField eNameField;
	private JTextField ePasswordField;
	private JTextField bQuantityField;
	private JTextField bTitleField;
	private JTextField bDescField;
	private JTextField bSeverityField;

	private JTextField name;
	private JTextField password;

	private ArrayList<String> bugTitles = new ArrayList<>();
	private ArrayList<String> bugDetails = new ArrayList<>();
	private ArrayList<Integer> bugSeverities = new ArrayList<>();
	private ArrayList<String> bugReporters = new ArrayList<>();
	private JTextField eIdField;
	private JTextField bugIdField;
	private JTextField eIDBugField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficeApplication frame = new OfficeApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OfficeApplication() {

		ArrayList<String> bugTitles = new ArrayList<>();
		ArrayList<String> bugDetails = new ArrayList<>();
		ArrayList<Integer> bugSeverities = new ArrayList<>();
		ArrayList<String> bugReporters = new ArrayList<>();

		// BUG CHANNEL
		String bug_service_type = "_bugs._tcp.local.";
		discoverService(bug_service_type);

		String host = bugServiceInfo.getHostAddresses()[0];
		int port = bugServiceInfo.getPort();

		ManagedChannel bugChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// PROFILE CHANNEL
		String profile_service_type = "_profile._tcp.local.";
		discoverService(profile_service_type);

		host = profileServiceInfo.getHostAddresses()[0];
		port = profileServiceInfo.getPort();

		ManagedChannel profileChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		// create stubs -- bugs
		bugBlockingStub = BugReportingServiceGrpc.newBlockingStub(bugChannel);
		bugAsyncStub = BugReportingServiceGrpc.newStub(bugChannel);

		// create stubs -- profile
		profileBlockingStub = ProfilingServiceGrpc.newBlockingStub(profileChannel);
		profileASyncStub = ProfilingServiceGrpc.newStub(profileChannel);

		setTitle("OfficeApplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel appName = new JLabel("Smart Office Systems");
		appName.setFont(new Font("Segoe UI Variable", Font.BOLD, 22));
		appName.setBounds(232, 11, 277, 27);
		contentPane.add(appName);

		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel.setBounds(246, 90, 84, 14);
		contentPane.add(lblNewLabel);

		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblEnterPassword.setBounds(246, 120, 84, 14);
		contentPane.add(lblEnterPassword);

		eNameField = new JTextField();
		eNameField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		eNameField.setBounds(327, 87, 119, 20);
		contentPane.add(eNameField);
		eNameField.setColumns(10);

		ePasswordField = new JTextField();
		ePasswordField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		ePasswordField.setColumns(10);
		ePasswordField.setBounds(327, 117, 119, 20);
		contentPane.add(ePasswordField);

		JLabel lblEmployeeProfiling = new JLabel("Employee Profiling");
		lblEmployeeProfiling.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		lblEmployeeProfiling.setBounds(276, 49, 240, 27);
		contentPane.add(lblEmployeeProfiling);

		JButton btnLogin = new JButton("Sign In");
		btnLogin.setBackground(Color.CYAN);
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnLogin.setBounds(313, 152, 67, 23);
		contentPane.add(btnLogin);

		JLabel lblBugReporting = new JLabel("Bug Reporting");
		lblBugReporting.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		lblBugReporting.setBounds(48, 49, 240, 27);
		contentPane.add(lblBugReporting);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblQuantity.setBounds(42, 90, 56, 14);
		contentPane.add(lblQuantity);

		bQuantityField = new JTextField();
		bQuantityField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		bQuantityField.setColumns(10);
		bQuantityField.setBounds(108, 87, 44, 20);
		contentPane.add(bQuantityField);

		JButton btnRequestBugList = new JButton("Request Bug List");
		btnRequestBugList.setBackground(Color.CYAN);
		btnRequestBugList.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnRequestBugList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRequestBugList.setBounds(33, 116, 129, 23);
		contentPane.add(btnRequestBugList);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblTitle.setBounds(10, 166, 35, 14);
		contentPane.add(lblTitle);

		bTitleField = new JTextField();
		bTitleField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		bTitleField.setColumns(10);
		bTitleField.setBounds(83, 163, 119, 20);
		contentPane.add(bTitleField);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblDescription.setBounds(10, 198, 77, 14);
		contentPane.add(lblDescription);

		bDescField = new JTextField();
		bDescField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		bDescField.setColumns(15);
		bDescField.setBounds(83, 195, 119, 65);
		contentPane.add(bDescField);

		JLabel lblSeverity = new JLabel("Severity (1-5):");
		lblSeverity.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblSeverity.setBounds(10, 275, 77, 14);
		contentPane.add(lblSeverity);

		bSeverityField = new JTextField();
		bSeverityField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		bSeverityField.setColumns(10);
		bSeverityField.setBounds(83, 272, 119, 20);
		contentPane.add(bSeverityField);

		JButton btnPostNewBug = new JButton("Post Bug(s)");
		btnPostNewBug.setBackground(Color.CYAN);
		btnPostNewBug.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnPostNewBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPostNewBug.setBounds(14, 303, 84, 23);
		contentPane.add(btnPostNewBug);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(145, 418, 405, 73);

		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setSize(440, 167);
		scroll.setLocation(132, 399);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPane.add(scroll);
		contentPane.setVisible(true);

		JButton btnAddBug = new JButton("Add Entry");
		btnAddBug.setBackground(Color.GREEN);
		btnAddBug.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnAddBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddBug.setBounds(108, 303, 84, 23);
		contentPane.add(btnAddBug);

		JButton btnClearText = new JButton("Clear Terminal");
		btnClearText.setBackground(Color.WHITE);
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClearText.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnClearText.setBounds(582, 512, 114, 54);
		contentPane.add(btnClearText);

		JLabel lblBugsStored = new JLabel("5 bug(s) stored and ready to post.");
		lblBugsStored.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblBugsStored.setBounds(33, 337, 168, 14);
		lblBugsStored.setVisible(false);
		contentPane.add(lblBugsStored);

		JButton btnClearBugs = new JButton("Clear Bugs");
		btnClearBugs.setBackground(Color.WHITE);
		btnClearBugs.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnClearBugs.setBounds(61, 362, 84, 23);
		btnClearBugs.setVisible(false);
		contentPane.add(btnClearBugs);

		JButton btnRequestEmployee = new JButton("Request Employee by ID");
		btnRequestEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnRequestEmployee.setBackground(Color.GREEN);
		btnRequestEmployee.setBounds(272, 229, 153, 23);
		contentPane.add(btnRequestEmployee);

		eIdField = new JTextField();
		eIdField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		eIdField.setColumns(10);
		eIdField.setBounds(354, 195, 44, 20);
		contentPane.add(eIdField);

		JLabel lblId = new JLabel("Employee ID:");
		lblId.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblId.setBounds(287, 198, 67, 14);
		contentPane.add(lblId);

		JButton btnRequestAllEmployees = new JButton("Request all Employees");
		btnRequestAllEmployees.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnRequestAllEmployees.setBackground(Color.CYAN);
		btnRequestAllEmployees.setBounds(272, 263, 153, 23);
		contentPane.add(btnRequestAllEmployees);

		JLabel lblBugId = new JLabel("Bug ID:");
		lblBugId.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblBugId.setBounds(309, 337, 35, 14);
		contentPane.add(lblBugId);

		bugIdField = new JTextField();
		bugIdField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		bugIdField.setColumns(10);
		bugIdField.setBounds(354, 334, 44, 20);
		contentPane.add(bugIdField);

		JButton btnAssignBugFix = new JButton("Assign Bug Fix");
		btnAssignBugFix.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnAssignBugFix.setBackground(Color.CYAN);
		btnAssignBugFix.setBounds(276, 362, 149, 23);
		contentPane.add(btnAssignBugFix);

		eIDBugField = new JTextField();
		eIDBugField.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		eIDBugField.setColumns(10);
		eIDBugField.setBounds(354, 306, 44, 20);
		contentPane.add(eIDBugField);

		JLabel lblId_1 = new JLabel("Employee ID:");
		lblId_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblId_1.setBounds(287, 309, 67, 14);
		contentPane.add(lblId_1);

		// Clear Terminal Button
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		// EMPLOYEE PROFILING SERVICE
		// Employee Sign In Button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nameEntry = eNameField.getText();
				String passwordEntry = ePasswordField.getText();

				LogRequest req = LogRequest.newBuilder().setName(nameEntry).setPassword(passwordEntry).build();

				LogResponse response = profileBlockingStub.logIn(req);

				textArea.append("---------Employee Log In----------" + "\n");
				textArea.append(response.getMessage() + "\n");

				System.out.println("Success?: " + response.getSuccess() + " Message: " + response.getMessage() + "\n");

			}
		});

		// Get Employee By ID Button
		btnRequestEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int idEntry = 0;
					int bugIdEntry = 0;

					idEntry = Integer.valueOf(eIdField.getText());
					if ((idEntry > 0) && (idEntry < 5)) {

						// Get Employee by ID
						eListRequest req = eListRequest.newBuilder().setId(idEntry).build();
						Iterator<eListResponse> responses = profileBlockingStub.getEmployeeList(req);

						// Get Employee's current task
						eListResponse employee = responses.next();
						bugIdEntry = employee.getTask();

						System.out.println("Printing employee to screen...");
						textArea.append("---------Request Employee by ID----------" + "\n");
						textArea.append("-----------Employee-----------" + "\n");
						textArea.append("Employee ID: " + idEntry + "\n");
						textArea.append("Name: " + employee.getName() + "\n");
						textArea.append("Job Title: " + employee.getJob() + "\n");
						textArea.append("Occupied: " + employee.getBusy() + "\n");
						
						// Check if a bug is assigned to this employee
						if (bugIdEntry > 0) {
							// Get Bug by ID
							BugIdRequest bugReq = BugIdRequest.newBuilder().setId(bugIdEntry).build();
							ListResponse bug = bugBlockingStub.getBugByID(bugReq);
							
							textArea.append("Current Task: " + bug.getTitle() + "\n");
							textArea.append("Task Details: " + bug.getDetails() + "\n");
						}
						else {
							textArea.append("Current Task: None Assigned" + "\n");
						}

						System.out.println("Employee Request complete.");

					}
					else {
						System.out.println("Invalid ID was entered.");
						textArea.append("Invalid ID was entered. \n");
					}

				} catch (NumberFormatException n) {
					System.out.println("Invalid ID was entered.");
					textArea.append("---------Request Employee by ID----------" + "\n");
					textArea.append("Invalid ID was entered. \n");
				}

			}
		});

		// Assign Bug to Employee Button
		btnAssignBugFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idEntry = 0;
				int bugIdEntry = 0;

				try {
					// Assign user entries after validation (catching NumberFormatExceptions)
					if ((Integer.parseInt(eIDBugField.getText()) > 0)
							&& (Integer.parseInt(eIDBugField.getText()) > 0)) {
						idEntry = Integer.parseInt(eIDBugField.getText());
						bugIdEntry = Integer.parseInt(bugIdField.getText());
					}

					// basic front end validation and feedback
					if ((idEntry > 0) && (idEntry < 5) && (bugIdEntry > 0) && (bugIdEntry < 5)) {

						// Get Employee by ID
						eListRequest req = eListRequest.newBuilder().setId(idEntry).build();
						Iterator<eListResponse> response = profileBlockingStub.getEmployeeList(req);

						// Get Bug by ID
						BugIdRequest bugReq = BugIdRequest.newBuilder().setId(bugIdEntry).build();
						ListResponse bug = bugBlockingStub.getBugByID(bugReq);

						System.out.println("Printing updated employee to screen...");
						textArea.append("---------Assign Bug to Employee by ID----------" + "\n");

						boolean updatedStatus = true;

						eListResponse employee = response.next();

						textArea.append("-----------Employee-----------" + "\n");
						textArea.append("Name: " + employee.getName() + "\n");
						textArea.append("Job Title: " + employee.getJob() + "\n");
						textArea.append("Occupied (before update): " + employee.getBusy() + "\n");
						textArea.append("Occupied: " + updatedStatus + "\n");
						textArea.append("Updated Task: " + bug.getTitle() + "\n");
						textArea.append("Task Details: " + bug.getDetails() + "\n");

						// Automatic update of Bug Reporting Service
						if (employee.getBusy() == true) {
							textArea.append("\n" + "**Previous task assigned to employee has been removed and "
									+ "added back to the unassigned Bug List.**" + "\n");
						}

						System.out.println("Employee Bug Assignment complete.");
					} else {
						textArea.append("Invalid employee or bug ID entered. \n");
					}
				} catch (NumberFormatException n) {
					System.out.println("No ID was entered.");
					textArea.append("---------Assign Bug to Employee by ID----------" + "\n");
					textArea.append("Invalid Employee ID and/or Bug ID was entered. \n");
				}

			}
		});

		// Get All Employees Button
		btnRequestAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int idEntry = 00;

					eListRequest req = eListRequest.newBuilder().setId(idEntry).build();

					Iterator<eListResponse> responses = profileBlockingStub.getAllEmployeeList(req);

					System.out.println("Printing All employees to screen...");
					textArea.append("---------Request All Employees----------" + "\n");

					int count = 1;

					while (responses.hasNext()) {
						eListResponse temp = responses.next();
						
						// Get Employee's current task 
						int bugIdEntry = temp.getTask();

						textArea.append("-----------Employee-----------" + "\n");
						textArea.append("Employee ID: " + count + "\n");
						textArea.append("Name: " + temp.getName() + "\n");
						textArea.append("Job Title: " + temp.getJob() + "\n");
						textArea.append("Occupied: " + temp.getBusy() + "\n");
						
						// Check if a bug is assigned to this employee
						if (bugIdEntry > 0) {
							// Get Bug by ID
							BugIdRequest bugReq = BugIdRequest.newBuilder().setId(bugIdEntry).build();
							ListResponse bug = bugBlockingStub.getBugByID(bugReq);
							
							textArea.append("Current Task: " + bug.getTitle() + "\n");
							textArea.append("Task Details: " + bug.getDetails() + "\n");
						}
						else {
							textArea.append("Current Task: None Assigned" + "\n");
						}

						count++;
					}
					System.out.println("Employee Request complete.");

				} catch (NumberFormatException n) {
//					System.out.println("No ID was entered.");
//					textArea.append("No ID was entered. \n");
				}

			}
		});

		// BUG REPORTING SERVICE
		// Request Bug List Button
		btnRequestBugList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int quantityEntry = Integer.valueOf(bQuantityField.getText());

					ListRequest req = ListRequest.newBuilder().setQuantity(quantityEntry).build();
					Iterator<ListResponse> responses = bugBlockingStub.getBugList(req);

					System.out.println("Printing bugs to screen...");
					textArea.append("---------Request Bug List----------" + "\n");

					while (responses.hasNext()) {
						ListResponse temp = responses.next();
						System.out.println("-----------Bug-----------");
						System.out.println("Title: " + temp.getTitle());
						System.out.println("Details: " + temp.getDetails());
						System.out.println("Severity: " + temp.getSeverity());
						System.out.println("Reported By: " + temp.getReportedBy());

						textArea.append("-----------Bug-----------" + "\n");
						textArea.append("Title: " + temp.getTitle() + "\n");
						textArea.append("Details: " + temp.getDetails() + "\n");
						textArea.append("Severity: " + temp.getSeverity() + "\n");
						textArea.append("Reported By: " + temp.getReportedBy() + "\n");
					}
					System.out.println("Bug Request complete.");

				} catch (NumberFormatException n) {
					System.out.println("Invalid was entered.");
					textArea.append("No number was entered. \n");
				}

			}
		});

		// Add Bug Entry Button
		btnAddBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Get user entries
					String title = bTitleField.getText();
					String desc = bDescField.getText();
					int severity = Integer.valueOf(bSeverityField.getText());

					if ((severity > 0) && (severity < 6)) {
						bugTitles.add(title);
						bugDetails.add(desc);
						bugSeverities.add(severity);

						lblBugsStored.setVisible(true);
						btnClearBugs.setVisible(true);
						String stored = (Integer.toString(bugTitles.size()));
						lblBugsStored.setText(stored + " bugs ready to post.");
					} else {
						System.out.println("Invalid bug severity was entered.");
						textArea.append("Bug Severity must be rated 1-5. \n");
					}

				} catch (NumberFormatException numb) {
					System.out.println("Invalid bug was entered.");
					textArea.append("Bug entry is invalid. \n");
				}

			}

		});

		// Remove Bug Entry Button
		btnClearBugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				bugTitles.clear();
				bugDetails.clear();
				bugSeverities.clear();

				lblBugsStored.setVisible(false);
				btnClearBugs.setVisible(false);
				String stored = (Integer.toString(bugTitles.size()));
				lblBugsStored.setText(stored + " bugs ready to post.");
			}

		});

		// Post Bugs Button
		btnPostNewBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				StreamObserver<ListResponse> responseObserver = new StreamObserver<ListResponse>() {

					int count = 0;

					@Override
					public void onNext(ListResponse value) {

						System.out.println("Recieving bug ");
						String resTitle = value.getTitle();
						String resDesc = value.getDetails();
						int resSeverity = value.getSeverity();
						String reporter = value.getReportedBy();

						textArea.append("-------------New Bug-------------" + "\n");
						textArea.append("Title: " + resTitle + "\n");
						textArea.append("Details: " + resDesc + "\n");
						textArea.append("Severity: " + resSeverity + "\n");
						textArea.append("Reported By: " + reporter + "\n");
						count += 1;

					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						System.out.println("Upload complete. " + count + " new bugs have been posted.");
						textArea.append("Upload complete. " + count + " new bugs have been posted. \n");
					}
				};

				System.out.println("Printing new bugs to screen... \n");
				textArea.append("Posting new bugs..." + "\n");

				StreamObserver<NewBugs> requestObserver = bugAsyncStub.postBugs(responseObserver);

				Object[] titles = bugTitles.toArray();
				Object[] details = bugDetails.toArray();
				Object[] severities = bugSeverities.toArray();

				try {

					for (int i = 0; i <= bugTitles.size() - 1; i++) {

						requestObserver.onNext(NewBugs.newBuilder().setTitle((String) titles[i])
								.setDetails((String) details[i]).setSeverity((int) severities[i]).build());
					}

					// Mark the end of requests
					requestObserver.onCompleted();
					System.out.println("Request Complete");

					// Sleep for a bit before sending the next one.
					Thread.sleep(200);

				} catch (RuntimeException r) {
					r.printStackTrace();
				} catch (InterruptedException i) {
					i.printStackTrace();
				}

				bugTitles.clear();
				bugDetails.clear();
				bugSeverities.clear();

				lblBugsStored.setVisible(false);
				btnClearBugs.setVisible(false);
				String stored = (Integer.toString(bugTitles.size()));
				lblBugsStored.setText(stored + " bugs ready to post.");

				System.out.println("Bug Post complete.");

			}

		});
	}

	private void discoverService(String service_type) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println(event.getName() + " resolved: " + event.getInfo());

					int port = 0;

					if (service_type.contains("bug")) {
						bugServiceInfo = event.getInfo();
						port = bugServiceInfo.getPort();
					}
					if (service_type.contains("profile")) {
						profileServiceInfo = event.getInfo();
						port = profileServiceInfo.getPort();
					}

					System.out.println("Resolving " + service_type + " with properties ...");
					System.out.println("Port: " + port);
					System.out.println("Type:" + event.getType());
					System.out.println("Name: " + event.getName());
					System.out.println("Description/properties: " + bugServiceInfo.getNiceTextString());
					System.out.println("Host: " + bugServiceInfo.getHostAddresses()[0]);

				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println(event.getName() + " removed: " + event.getInfo());

				}

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println(event.getName() + " added: " + event.getInfo());

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
}
