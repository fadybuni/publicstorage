import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_AddItemToRoom extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton addItemButton = new JButton("Add Item");

    JLabel roomNumberLabel = new JLabel("Room Number:");
	JLabel itemNameLabel = new JLabel("Item Name:");
	JLabel itemWidthLabel = new JLabel("Item Width:");
	JLabel itemDepthLabel = new JLabel("Item Depth:");
    JLabel itemHeightLabel = new JLabel("Item Height:");

    JTextField roomNumberField = new JTextField("");
	JTextField itemNameField = new JTextField("");
	JTextField itemWidthField = new JTextField("");
	JTextField itemDepthField = new JTextField("");
    JTextField itemHeightField = new JTextField("");

    database db = new database();

    Display_AddItemToRoom ()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(275, 150, 200, 25);
        exitButton.addActionListener(this);

        // Add Client Button
        addItemButton.setBounds(150, 350, 100, 25);
        addItemButton.addActionListener(this);

        roomNumberLabel.setBounds(50, 100, 100, 25);
        itemNameLabel.setBounds(50, 150, 100, 25);
        itemWidthLabel.setBounds(50, 200, 100, 25);
        itemDepthLabel.setBounds(50, 250, 100, 25);
        itemHeightLabel.setBounds(50, 300, 100, 25);

        roomNumberField.setBounds(150, 100, 100, 25);
        itemNameField.setBounds(150, 150, 100, 25);
        itemWidthField.setBounds(150, 200, 100, 25);
        itemDepthField.setBounds(150, 250, 100, 25);
        itemHeightField.setBounds(150, 300, 100, 25);

        this.add(exitButton);
        this.add(addItemButton);
        this.add(roomNumberLabel);
        this.add(itemNameLabel);
        this.add(itemWidthLabel);
        this.add(itemDepthLabel);
        this.add(itemHeightLabel);
        this.add(roomNumberField);
        this.add(itemNameField);
        this.add(itemWidthField);
        this.add(itemDepthField);
        this.add(itemHeightField);
    }

    public void actionPerformed(ActionEvent e) 
    {
        // Add Client Button
		if (e.getSource() == addItemButton) 
		{
            // Create item to add object
            item addItem = new item();
            addItem.width = Integer.parseInt(itemWidthField.getText());
            addItem.depth = Integer.parseInt(itemDepthField.getText());;
            addItem.height = Integer.parseInt(itemHeightField.getText());;
            addItem.name = itemNameField.getText();
            addItem.roomID = Integer.parseInt(roomNumberField.getText());

            // Check to see if there is enough space to add the item
            //

            // Get empty room Volume
            int roomSize = db.getRoomSize(addItem.roomID);
            roomDimensions emptyRoomDimensions = db.getRoomDimensions(roomSize);
            int emptyRoomVolume = (emptyRoomDimensions.depth * emptyRoomDimensions.height * emptyRoomDimensions.width);

            // Sum up total volume of items that are currently in the room
            item[] currentItemsInRoom = db.getRoomItems(addItem.roomID);
            int totalItemsVolume = 0;
            for (int i = 0; i < currentItemsInRoom.length; i++)
            {
                totalItemsVolume = totalItemsVolume + (currentItemsInRoom[i].depth * currentItemsInRoom[i].width * currentItemsInRoom[i].height);
            }
            // Get the new items volume
            int newItemVolume = addItem.depth * addItem.height * addItem.width;

            String msg = "";
            // There is enough space to add the item
            //if (newItemVolume < (emptyRoomVolume - totalItemsVolume))
            if (newItemVolume < (emptyRoomVolume - totalItemsVolume))
            {
                int itemNumber = db.addItemToDatabase(addItem.name, addItem.width, addItem.depth, addItem.height, addItem.roomID);
                msg = "Item has been added to room number " + addItem.roomID + ". Item number: " + itemNumber;
            }
            else // There is not enough space
            {
                msg = "Sorry, but there is not enough space! Total Empty space of this room is " + (emptyRoomVolume - totalItemsVolume);
            }
			JOptionPane.showMessageDialog(this, msg);		
		}

        // Exit Button (go back to login screen)
        if (e.getSource() == exitButton) 
		{
            Display_MainPage mainPage = new Display_MainPage();
			mainPage.setTitle("Main Page");
			mainPage.setSize(800, 350);
            mainPage.setLocationRelativeTo(null);
			mainPage.setVisible(true);
			this.dispose();
		}
    }
}