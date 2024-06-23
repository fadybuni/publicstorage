import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Display_MainPage extends Frame implements ActionListener
{
    // GUI Controls ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Exit
    JButton exitButton = new JButton("Exit");
    // Get Available Rooms
    JButton viewAvailableRoomButton = new JButton("View Available Rooms");

    // Add User
    JButton addUserButton = new JButton("Add Customer");
	JButton addItemButton = new JButton("Add Item");
	JButton checkRoomButton = new JButton("Check Room");
	
	JButton addClientButton = new JButton("Add Client");
	
	JTextField itemField = new JTextField();
	JButton assignRoomButton = new JButton("Assign Room");
   
	JLabel roomLabel = new JLabel("Room:");
	JLabel itemLabel = new JLabel("Item:");
  	JButton customerIDButton = new JButton("Get Customer Info");
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    // Database Object
    database db = new database();

    Display_MainPage()
    {
        this.setLayout(null);

        ////////////// Buttons ////////////////////////////////////
        // Exit Button
        exitButton.setBounds(500, 200, 200, 25);
        exitButton.addActionListener(this);
        // Customer ID Button
        customerIDButton.setBounds(200,50,150,25);
		customerIDButton.addActionListener(this);
        // Add Client Button
        addClientButton.setBounds(150, 300, 100, 25);
        addClientButton.addActionListener(this);
        // User Button
        addUserButton.setBounds(340,50,100,25);
        addUserButton.addActionListener(this);
        // Assign Button
        assignRoomButton.setBounds(150, 150, 150, 25);
        assignRoomButton.addActionListener(this);
        // View Room Button
        viewAvailableRoomButton.setBounds(50, 400, 200, 25);
        viewAvailableRoomButton.addActionListener(this);
        // Add Item Button
        addItemButton.setBounds(150, 250, 150, 25);
        /////////////////////////////////////////////////////////////////////

        ////////////// Fields ////////////////////////////////////
        itemField.setBounds(150, 100, 200, 25);

        roomLabel.setBounds(50, 50, 100, 25);
        itemLabel.setBounds(50, 100, 100, 25);

        // Add GUI items to Frame
        this.add(exitButton);
        this.add(customerIDButton);
        this.add(addClientButton);
        this.add(assignRoomButton);
        
        this.add(viewAvailableRoomButton);
        this.setLayout(null);
        this.setVisible(true); 
    }

    public void actionPerformed(ActionEvent e)
    {
        // Button for inputting and displaying customer data
		if(e.getSource() == customerIDButton) 
		{
            Display_GetCustomerInformation getCustomerInformation = new Display_GetCustomerInformation();
            getCustomerInformation.setTitle("Get Customer Information");
            getCustomerInformation.setSize(800, 600);
            getCustomerInformation.setVisible(true);
			this.dispose();
		}

        // View Available Rooms
        if (e.getSource() == viewAvailableRoomButton)
        {
            Display_CheckAvailableRooms checkRoomsDisplay = new Display_CheckAvailableRooms();
            checkRoomsDisplay.setTitle("Available Rooms");
            checkRoomsDisplay.setSize(800, 600);
            checkRoomsDisplay.setVisible(true);
			this.dispose();
        }

        // Add Customer Button
		if (e.getSource() == addClientButton) 
		{
            Display_AddCustomer addCustomer = new Display_AddCustomer();
            addCustomer.setTitle("Add Customer");
            addCustomer.setSize(800, 600);
            addCustomer.setVisible(true);
			this.dispose();		
		}

        // Assign A Room Button
		if (e.getSource() == assignRoomButton) 
		{
            Display_AssignRoom assignRoom = new Display_AssignRoom();
            assignRoom.setTitle("Assign Customer");
            assignRoom.setSize(800, 600);
            assignRoom.setVisible(true);
			this.dispose();
		}

        // Exit Button (go back to login screen)
        if (e.getSource() == exitButton) 
		{
            IDandPasswords idandpasswords = new IDandPasswords();
		    new Display_LoginPage(idandpasswords.getLoginInfo());
            this.dispose();
		}

    }
    
}
