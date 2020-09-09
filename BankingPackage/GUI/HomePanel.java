package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;

import BankingPackage.Account;


public class HomePanel extends JPanel {

    private JLabel welcomeLabel = new JLabel();
    private JLabel balanceLabel = new JLabel();

    public HomePanel() {}
    public HomePanel(Account acc) {
        setLayout();
        setColor();
        setLabels(acc);
        colorLabels();
        addComponents();
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }

    public void setColor() {
        this.setBackground(new Color(43, 45, 47));
    }

    public void setLabels(Account acc) {

        welcomeLabel.setText("Welcome " + acc.getName() + " to your bank account!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setVerticalAlignment(JLabel.CENTER);

        balanceLabel.setText("Balance: " + acc.getBalance());
        balanceLabel.setHorizontalAlignment(JLabel.CENTER);
        balanceLabel.setVerticalAlignment(JLabel.CENTER);
        
    }

    public void addComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0; 
        c.weightx = 0.2;
        c.weighty = 0.2;
        this.add(welcomeLabel, c);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        this.add(balanceLabel, c);
    }

    public void colorLabels() {
        welcomeLabel.setForeground(Color.WHITE);
        balanceLabel.setForeground(Color.WHITE);
    }
    
}