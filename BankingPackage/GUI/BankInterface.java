package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BankInterface {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel loginPanel;

    public BankInterface() {
        prepareLogin();
    }

    private void prepareLogin() {
        mainFrame = new JFrame("Gu Banking");
        mainFrame.setSize(1000, 1000);
        GridLayout layout = new GridLayout(2, 1);
        mainFrame.setLayout(layout);

        headerLabel = new JLabel("Welcome to Gu Bank", JLabel.CENTER);
        prepareLoginPanel();

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.add(headerLabel);
        mainFrame.add(loginPanel);
        mainFrame.setVisible(true);
    }

    public void prepareLoginPanel() {
        loginPanel = new JPanel();
        GridLayout layout = new GridLayout(2,2);
        loginPanel.setLayout(layout);

        JLabel id = new JLabel("Id: ", JLabel.CENTER);
        JLabel pass = new JLabel("Password: ", JLabel.CENTER);
        JTextField inputId = new JTextField("Enter Id");
        JPasswordField inputPass = new JPasswordField("Enter Pass");
        loginPanel.add(id);
        loginPanel.add(pass);
        loginPanel.add(inputId);
        loginPanel.add(inputPass);
    }
    public static void main(String args[]) {
        BankInterface graphic = new BankInterface();
    }
}