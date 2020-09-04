package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginFrame extends JFrame implements ActionListener {

    private Container container = getContentPane();
    private JLabel headerLabel = new JLabel("Welcome to Gu Banking");
    private JLabel userLabel = new JLabel("Username:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");

    LoginFrame() {
        setLayoutManager();
        setComponentLocation();
        addComponents();
        this.setResizable(false);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
    public void setComponentLocation() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 200, 100, 30);
        headerLabel.setBounds(125, 5, 300, 30);
        userTextField.setBounds(125, 150, 210, 30);
        passwordField.setBounds(125, 200, 210, 30);
        loginButton.setBounds(125, 260, 200, 40);
    }
    public void addComponents() {
        container.add(userLabel);
        container.add(headerLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
}