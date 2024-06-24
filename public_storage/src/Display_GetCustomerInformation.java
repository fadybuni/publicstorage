import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_GetCustomerInformation extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton getCustomerInformationButton = new JButton("Get Customer Information");
    JTextField customerIDField = new JTextField();
    JLabel enterCustomerID = new JLabel("Customer ID: ");
    
    database db = new database();

    Display_GetCustomerInformation()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(300, 125, 200, 25);
        exitButton.addActionListener(this);

        // Get Customer Info Button
        getCustomerInformationButton.setBounds(300, 50, 200, 25);
        getCustomerInformationButton.addActionListener(this);

        enterCustomerID.setBounds(50, 50, 100, 25);
        customerIDField.setBounds(140, 50, 50, 25);

        // Add GUI items to Frame
        this.add(getCustomerInformationButton);
        this.add(exitButton);
        this.add(customerIDField);
        this.add(enterCustomerID);

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
        /* if(e.getsource() == viewItemsButton) {
        item[] c = db.getRoomItems();
        String itemName = c[0].name;
        } */
        // Exit Button (go back to login screen)
        if (e.getSource() == exitButton) 
		{
            Display_MainPage mainPage = new Display_MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 300);
            mainPage.setLocationRelativeTo(null);
			mainPage.setVisible(true);
			this.dispose();
		}
    }
    
}
