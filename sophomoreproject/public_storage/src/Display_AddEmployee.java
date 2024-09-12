import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display_AddEmployee extends Frame implements ActionListener
{
    JButton exitButton = new JButton("Exit");
    JButton addEmployeeButton = new JButton("Add Employee");

    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");

    JTextField usernameField = new JTextField("");
    JTextField passwordField = new JTextField("");

    database db = new database();

    Display_AddEmployee()
    {
        this.setLayout(null);

        // Exit Button
        exitButton.setBounds(285, 125, 200, 25);
        exitButton.addActionListener(this);

        // Add Employee Button
        addEmployeeButton.setBounds(150, 230, 150, 25);
        addEmployeeButton.addActionListener(this);

        usernameLabel.setBounds(50, 100, 100, 25);
        passwordLabel.setBounds(50, 150, 100, 25);


        usernameField.setBounds(150, 100, 100, 25);
        passwordField.setBounds(150, 150, 100, 25);

        this.add(exitButton);
        this.add(addEmployeeButton);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameField);
        this.add(passwordField);
    }

    public void actionPerformed(ActionEvent e)
    {
        // Add Client Button
    if (e.getSource() == addEmployeeButton) 
{
    String username = usernameField.getText();
    String password = passwordField.getText();
            
    int newEmployeeID = db.addEmployeeToDatabase(username, password);
    String msg = username + " has been added and has been assigned Customer ID: " + newEmployeeID;
    JOptionPane.showMessageDialog(this, msg);
}

        // Exit Button (go back to login screen)
    if (e.getSource() == exitButton) 
{
    Display_MainPage mainPage = new Display_MainPage();
    mainPage.setTitle("Main Page");
    mainPage.setSize(800, 350);
    mainPage.setVisible(true);
    this.dispose();
}
    }
    
}
