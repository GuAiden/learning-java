package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.FileManagement.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
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
        addActionEvent();
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

    public void addActionEvent() {
        loginButton.addActionListener(this);

    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == loginButton) {
            String userText;
            char passwordText[];
            userText = userTextField.getText();
            passwordText = passwordField.getPassword();
            int id = Integer.parseInt(userText.trim());
            String filePath = FileHandle.createFile();
            String file = FileRead.readFile(filePath);
            Account account = FileRead.findAccountById(file, id);
            if (AccountActions.confirmLogin(account, id, passwordText)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User/Pass");
            }

        }
    }


    
}