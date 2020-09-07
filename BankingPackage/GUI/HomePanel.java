package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.Account;
import BankingPackage.FileManagement.*;

public class HomePanel extends JPanel {

    private JLabel welcomeLabel = new JLabel();
    
    public HomePanel() {}
    public HomePanel(Account acc) {
        setLayout();
        setColor();
        setLabels(acc);
        colorLabels();
        addComponents();
    }

    public void setLayout() {
        this.setLayout(new BorderLayout());
    }
    public void setColor() {
        this.setBackground(new Color(43, 45, 47));
    }

    public void setLabels(Account acc) {
        welcomeLabel.setText("Welcome " + acc.getName() + " to your bank account!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);
    }

    public void addComponents() {
        this.add(welcomeLabel, BorderLayout.NORTH);
    }

    public void colorLabels() {
        welcomeLabel.setForeground(Color.WHITE);
    }
    
}