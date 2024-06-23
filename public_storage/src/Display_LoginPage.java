import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_LoginPage implements ActionListener 
{
	JFrame frame = new JFrame();
	JFrame signupPage;
	JButton loginButton = new JButton("Login");
	JButton signupButton = new JButton("Sign Up");
	JTextField userIDField = new JTextField();
	JTextField userPasswordField = new JTextField();
	JLabel userIDLabel = new JLabel("ID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("This is a test");

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	Display_LoginPage(HashMap<String,String> loginInfoOriginal)
	{
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
		
		
	public void actionPerformed(ActionEvent e)
	{
		// Login Button	
		if(e.getSource()==loginButton) 
		{
			database db = new database(); // create database object
			int userTyped_ID = Integer.parseInt(userIDField.getText()); // get user ID
			String userTyped_Password = userPasswordField.getText(); // get user Password
			employee employeeLoggingIn = db.getEmployeeInfo(userTyped_ID); // get Password stored on database

			// Check if employee typed in the correct password
			if (employeeLoggingIn.password.equals(userTyped_Password))
			{
				Display_MainPage mainPage = new Display_MainPage();
				mainPage.setTitle("Main Page");
				mainPage.setSize(800, 600);
				mainPage.setVisible(true);
				this.frame.dispose();
			}
			else
			{
				String msg = "Password does not match! Please try again.";
				JOptionPane.showMessageDialog(frame, msg);
			}
      	}
	}
}
		
		
	



