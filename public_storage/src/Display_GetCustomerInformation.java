import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_GetCustomerInformation extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton getCustomerInformationButton = new JButton("Get Customer Information");
    JTextField customerIDField = new JTextField();
    
    database db = new database();

    Display_GetCustomerInformation()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(500, 200, 200, 25);
        exitButton.addActionListener(this);

        // Get Customer Info Button
        getCustomerInformationButton.setBounds(50, 400, 200, 25);
        getCustomerInformationButton.addActionListener(this);

        customerIDField.setBounds(250, 400, 50, 25);

        // Add GUI items to Frame
        this.add(getCustomerInformationButton);
        this.add(exitButton);
        this.add(customerIDField);
    }

    public void actionPerformed(ActionEvent e) 
    {
        // View Available Rooms
        // Button for inputting and displaying customer data
		if(e.getSource() == getCustomerInformationButton) 
		{
			// Changing this part of the code change what displays on the customer info box
			String customerInfo = customerIDField.getText();
			int customerID = Integer.parseInt(customerInfo);
            customer theCustomer = db.getCustomerInformation(customerID);
			JOptionPane.showMessageDialog(this, "Customer First Name: " + theCustomer.firstName + "\nCustomer Last Name: " + theCustomer.lastName + "\nCustomer Phone Number: " + theCustomer.phoneNumber + "\nCustomer Email: " + theCustomer.email + "\n");
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
