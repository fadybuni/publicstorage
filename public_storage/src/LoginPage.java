import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.EventObject;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginPage implements ActionListener {
	
	JFrame frame = new JFrame();

	JFrame signupPage;
	JButton loginButton = new JButton("Login");
	JButton signupButton = new JButton("Sign Up");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("ID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("This is a test");
  JTextField customerIDField = new JTextField();
  JLabel customerIDLabel = new JLabel("Enter Customer ID: ");
  JButton customerIDButton = new JButton("Get Customer Info");
	JButton addUserButton = new JButton("Add Client");
	JButton addItemButton = new JButton("Add Item");
	JButton checkRoomButton = new JButton("Check Room");
	JTextField firstNameField = new JTextField("");
	JTextField lastNameField = new JTextField("");
	JTextField emailField = new JTextField("");	
	JTextField phoneField = new JTextField("");
	JButton addClientButton = new JButton("Add Client");
	JTextField roomField = new JTextField();
	JTextField itemField = new JTextField();
	JButton assignRoomButton = new JButton("Assign Room");
	JButton viewRoomButton = new JButton("View Room");


	JLabel roomLabel = new JLabel("Room:");
	JLabel itemLabel = new JLabel("Item:");

	JLabel firstNameLabel = new JLabel("First Name:");
	JLabel lastNameLabel = new JLabel("Last Name:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel phoneLabel = new JLabel("Phone:");


	
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){

		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		
		signupButton.setBounds(225,200,100,25);
		signupButton.addActionListener(this);
		signupButton.setFocusable(false);
		
    customerIDField.setBounds(160, 25, 45, 25);
    customerIDLabel.setBounds(25,25,150,25);

    customerIDButton.setBounds(200,25,150,25);
    customerIDButton.addActionListener(this);

		addUserButton.setBounds(200,25,150,25);
		addUserButton.addActionListener(this);
		
		firstNameLabel.setBounds(50, 50, 100, 25);
		lastNameLabel.setBounds(50, 100, 100, 25);
		emailLabel.setBounds(50, 150, 100, 25);
		phoneLabel.setBounds(50, 200, 100, 25);

		firstNameField.setBounds(150, 50, 200, 25);
		lastNameField.setBounds(150, 100, 200, 25);
		emailField.setBounds(150, 150, 200, 25);
		phoneField.setBounds(150, 200, 200, 25);
		addClientButton.setBounds(150, 250, 100, 25);

		roomLabel.setBounds(50, 50, 100, 25);
		itemLabel.setBounds(50, 100, 100, 25);

		roomField.setBounds(150, 50, 200, 25);
		itemField.setBounds(150, 100, 200, 25);

		assignRoomButton.setBounds(150, 150, 150, 25);
		viewRoomButton.setBounds(150, 200, 150, 25);
		addItemButton.setBounds(150, 250, 150, 25);
	

		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(signupButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		

		
	}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==loginButton) {

        JFrame mainPage = new JFrame("Main");
        mainPage.setSize(600, 400);
        mainPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPage.setLocationRelativeTo(null);

          customerIDField.setBounds(160, 25, 45, 25);

          customerIDLabel.setBounds(25,25,150,25);

          customerIDButton.setBounds(200,25,150,25);

					addUserButton.setBounds(340,25,100,25);

            mainPage.add(customerIDField);
            mainPage.add(customerIDLabel);
            mainPage.add(customerIDButton);
						mainPage.add(addUserButton);

            mainPage.setLayout(null);
            mainPage.setVisible(true);

					
      }

			if (e.getSource() == addUserButton) {
				JFrame addUserPage = new JFrame("Add Client");
				addUserPage.setSize(600, 400);
				addUserPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addUserPage.setLocationRelativeTo(null);
				
				
				addClientButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								String firstName = firstNameField.getText();
								String lastName = lastNameField.getText();
								String email = emailField.getText();
								String phone = phoneField.getText();

	

								JOptionPane.showMessageDialog(addUserPage, "Client added successfully!");
								// Add code here to save the client data to the database
								// For example:
								// database.addClient(firstName, lastName, email, phone);


						}
				});
				addUserPage.add(firstNameLabel);
				addUserPage.add(lastNameLabel);
				addUserPage.add(emailLabel);
				addUserPage.add(phoneLabel);
				addUserPage.add(firstNameField);
				addUserPage.add(lastNameField);
				addUserPage.add(emailField);
				addUserPage.add(addClientButton);
				addUserPage.add(phoneField);
				addUserPage.setLayout(null);
				addUserPage.setVisible(true);

      // Button for inputting and displaying customer data

      if(e.getSource() == customerIDButton) {


        // Changing this part of the code change what displays on the customer info box
        String customerInfo = customerIDField.getText();
        int customerID = Integer.parseInt(customerInfo);
        /* database customerData = new database();
        JOptionPane.showMessageDialog(frame, "Customer First Name: " + customersName[0] + "\nCustomer Last Name: " + customersName[1] + "\nCustomer Phone Number: " + customersName[2] + "\nCustomer Email: " + customersName[3] + "\n");  */

			}
			if (e.getSource() == customerIDButton) {
				JFrame clientInfoPage = new JFrame("Client Info");
				clientInfoPage.setSize(600, 400);
				clientInfoPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				clientInfoPage.setLocationRelativeTo(null);

				JTextField roomField = new JTextField();
				JTextField itemField = new JTextField();
				JButton assignRoomButton = new JButton("Assign Room");
				JButton viewRoomButton = new JButton("View Room");
				JButton addItemButton = new JButton("Add Item");

				JLabel roomLabel = new JLabel("Room:");
				JLabel itemLabel = new JLabel("Item:");

				roomLabel.setBounds(50, 50, 100, 25);
				itemLabel.setBounds(50, 100, 100, 25);

				roomField.setBounds(150, 50, 200, 25);
				itemField.setBounds(150, 100, 200, 25);

				assignRoomButton.setBounds(150, 150, 150, 25);
				viewRoomButton.setBounds(150, 200, 150, 25);
				addItemButton.setBounds(150, 250, 150, 25);

				assignRoomButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								String room = roomField.getText();
								String customerID = customerIDField.getText();
								
								// Add code here to assign room to the client in the database
								// For example:
								// database.assignRoom(customerID, room);
								
								JOptionPane.showMessageDialog(clientInfoPage, "Room assigned successfully!");
						}
				});

				viewRoomButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								String customerID = customerIDField.getText();
								
								// Add code here to get the client's room details from the database
								// For example:
								// String roomDetails = database.getRoomDetails(customerID);
								String roomDetails = "Room details go here"; // Placeholder
								
								JOptionPane.showMessageDialog(clientInfoPage, roomDetails);
						}
				});

				addItemButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
								String item = itemField.getText();
								String customerID = customerIDField.getText();
								
								// Add code here to add item to the client's room in the database
								// For example:
								// database.addItemToRoom(customerID, item);
								
								JOptionPane.showMessageDialog(clientInfoPage, "Item added to room successfully!");
						}
				});

				clientInfoPage.add(roomLabel);
				clientInfoPage.add(itemLabel);
				clientInfoPage.add(roomField);
				clientInfoPage.add(itemField);
				clientInfoPage.add(assignRoomButton);
				clientInfoPage.add(viewRoomButton);
				clientInfoPage.add(addItemButton);

				clientInfoPage.setLayout(null);
				clientInfoPage.setVisible(true);
		}
}
			
		}
      }
		
		
	



