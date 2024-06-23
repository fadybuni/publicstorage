import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener 
{
	JFrame frame = new JFrame();
	JFrame signupPage;
	JButton loginButton = new JButton("Login");
	JButton signupButton = new JButton("Sign Up");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("ID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("This is a test");

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal)
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
			MainPage mainPage = new MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 600);
			mainPage.setVisible(true);
			this.frame.dispose();
      	}

	}
}
		
		
	



