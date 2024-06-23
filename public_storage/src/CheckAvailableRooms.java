import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckAvailableRooms extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton viewAvailableRoomButton = new JButton("View Available Rooms");
    JTextField viewAvailableRmSizeField = new JTextField();
    JLabel viewAvailableRmLabel= new JLabel();
    
    database db = new database();

    CheckAvailableRooms()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(500, 200, 200, 25);
        exitButton.addActionListener(this);

        // View Room Button
        viewAvailableRoomButton.setBounds(50, 400, 200, 25);
        viewAvailableRoomButton.addActionListener(this);

        //View Rooms Field
        viewAvailableRmSizeField.setBounds(300, 400, 25, 25);

        // View Rooms Label
        viewAvailableRmLabel.setBounds(50, 450, 200, 125);

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
            MainPage mainPage = new MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 600);
			mainPage.setVisible(true);
			this.dispose();
		}
    }
    
}
