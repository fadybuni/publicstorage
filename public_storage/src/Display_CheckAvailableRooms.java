import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Display_CheckAvailableRooms extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton viewAvailableRoomButton = new JButton("View Available Rooms");
    JTextField viewAvailableRmSizeField = new JTextField();
    JLabel viewAvailableRmLabel= new JLabel("Enter Room Size: ");
    
    database db = new database();

    Display_CheckAvailableRooms()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(175, 175, 200, 25);
        exitButton.addActionListener(this);

        // View Room Button
        viewAvailableRoomButton.setBounds(250, 75, 200, 25);
        viewAvailableRoomButton.addActionListener(this);

        //View Rooms Field
        viewAvailableRmSizeField.setBounds(215, 75, 25, 25);

        // View Rooms Label
        viewAvailableRmLabel.setBounds(100, 25, 100, 125);

        // Add GUI items to Frame
        this.add(viewAvailableRoomButton);
        this.add(viewAvailableRmLabel);
        this.add(viewAvailableRmSizeField);
        this.add(exitButton);
    }

    public void actionPerformed(ActionEvent e) 
    {
        // View Available Rooms
        if (e.getSource() == viewAvailableRoomButton)
        {
            String roomSizeInput = viewAvailableRmSizeField.getText();
			int roomSize = Integer.parseInt(roomSizeInput);
            List<availableRoom> roomsForRent = db.getAvailableRooms(roomSize);
            String[] theRooms = new String[roomsForRent.size()];
            int i = 0;
            for (availableRoom rms:roomsForRent)
            {
                theRooms[i] = Integer.toString(rms.roomNumber);
                i++;
            }
            String buildAString = "<html>";
            for (i = 0; i < theRooms.length; i++)
            {
                buildAString = buildAString+theRooms[i]+"<br>";
            }
            buildAString = buildAString+"</html>";
            viewAvailableRmLabel.setText(buildAString);
        }

        // Exit Button (go back to login screen)
        if (e.getSource() == exitButton) 
		{
            Display_MainPage mainPage = new Display_MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 300);
			mainPage.setVisible(true);
            mainPage.setLocationRelativeTo(null);
			this.dispose();
		}
    }
    
}
