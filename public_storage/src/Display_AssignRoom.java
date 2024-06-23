import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_AssignRoom extends Frame implements ActionListener 
{
    JButton exitButton = new JButton("Exit");
    JButton assignRoomButton = new JButton("Assign Room");
    JLabel customerIDLabel = new JLabel("Customer ID: ");
    JLabel roomNumberLabel = new JLabel("Room Number: ");
    JTextField customerIDField = new JTextField();
    JTextField roomNumberField = new JTextField();

    database db = new database();

    Display_AssignRoom()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(500, 200, 200, 25);
        exitButton.addActionListener(this);

         // Assign Button
         assignRoomButton.setBounds(150, 150, 150, 25);
         assignRoomButton.addActionListener(this);

         customerIDLabel.setBounds(200, 400, 50, 25);
         roomNumberLabel.setBounds(200, 450, 50, 25);
         customerIDField.setBounds(250, 400, 50, 25);
         roomNumberField.setBounds(250, 450, 50, 25);


         // Add GUI items to Frame
        this.add(assignRoomButton);
        this.add(exitButton);
        this.add(customerIDLabel);
        this.add(roomNumberLabel);
        this.add(customerIDField);
        this.add(roomNumberField);

    }


    
    public void actionPerformed(ActionEvent e) 
    {
        // View Available Rooms
        // Button for inputting and displaying customer data
		if(e.getSource() == assignRoomButton) 
		{
            int customerID = Integer.parseInt(customerIDField.getText());
            int roomNumber = Integer.parseInt(roomNumberField.getText());
			// Assign a Room
            boolean customerAssignedToRoom = db.assignCustomerToRoom(roomNumber, customerID);
			String msg = "";
            if (customerAssignedToRoom)
            {
                msg = "Customer has been assigned to room number: " + roomNumber;
            }
            else
            {
                msg = "Room assignment has failed!";
            }
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
