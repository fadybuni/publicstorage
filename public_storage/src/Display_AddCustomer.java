import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_AddCustomer extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton addClientButton = new JButton("Add Client");

    JLabel firstNameLabel = new JLabel("First Name:");
	JLabel lastNameLabel = new JLabel("Last Name:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel phoneLabel = new JLabel("Phone:");

    JTextField firstNameField = new JTextField("");
	JTextField lastNameField = new JTextField("");
	JTextField emailField = new JTextField("");	
	JTextField phoneField = new JTextField("");

    database db = new database();

    Display_AddCustomer ()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(500, 200, 200, 25);
        exitButton.addActionListener(this);

        // Add Client Button
        addClientButton.setBounds(150, 300, 100, 25);
        addClientButton.addActionListener(this);

        firstNameLabel.setBounds(50, 100, 100, 25);
        lastNameLabel.setBounds(50, 150, 100, 25);
        emailLabel.setBounds(50, 200, 100, 25);
        phoneLabel.setBounds(50, 250, 100, 25);

        firstNameField.setBounds(150, 100, 100, 25);
        lastNameField.setBounds(150, 150, 100, 25);
        emailField.setBounds(150, 200, 100, 25);
        phoneField.setBounds(150, 250, 100, 25);

        this.add(exitButton);
        this.add(addClientButton);
        this.add(firstNameLabel);
        this.add(lastNameLabel);
        this.add(phoneLabel);
        this.add(emailLabel);
        this.add(firstNameField);
        this.add(lastNameField);
        this.add(phoneField);
        this.add(emailField);
    }

    public void actionPerformed(ActionEvent e) 
    {
        // Add Client Button
		if (e.getSource() == addClientButton) 
		{
            String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String email = emailField.getText();
			String phone = phoneField.getText();
            int newCustomerID = db.addCustomerToDatabase(firstName, lastName, phone, email);
            String msg = firstName + " " + lastName + " has been added and has been assigned Customer ID: " + newCustomerID;
			JOptionPane.showMessageDialog(this, msg);		
		}

        // Exit Button (go back to login screen)
        if (e.getSource() == exitButton) 
		{
            Display_MainPage mainPage = new Display_MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 600);
			mainPage.setVisible(true);
			this.dispose();
		}
    }
}