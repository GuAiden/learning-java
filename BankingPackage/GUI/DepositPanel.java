package BankingPackage.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
import BankingPackage.FileManagement.*;

public class DepositPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Account account;
    private JButton deposit = new JButton("Deposit");
    private JLabel amount = new JLabel("Amount: ");
    private JTextField textAmount = new JTextField(); 

    public DepositPanel() {}

    public DepositPanel(Account account) {
        this.account = account;
        setLayout();
        setColor();
        colorLabels();
        //setTextField();
        addComponents();
        addActionEvent();
    }

    public void setLayout() {
        this.setLayout(new GridBagLayout());
    }
    public void setColor() {
        this.setBackground(new Color(43, 45, 47));
    }

    public void setTextField() {
        textAmount.setPreferredSize(new Dimension(400, 50));
    }

    public void addComponents() {

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(amount, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.6;
        c.anchor = GridBagConstraints.LINE_END;
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        this.add(textAmount, c);

        c.gridx = 0; 
        c.gridy = 1;
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.NONE;
        this.add(deposit, c);

    }

    public void colorLabels() {
        amount.setForeground(Color.WHITE);
        textAmount.setForeground(Color.BLACK);
    }
    public void addActionEvent() {
        deposit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String numDeposit = textAmount.getText().trim();

            if (StringManage.isInteger(numDeposit)) {
                
                String filePath = FileHandle.createFile();
                Account successor = AccountActions.createAccount(this.account.toString());
                AccountActions.deposit(successor, Integer.parseInt(numDeposit));

                if (FileWrite.overWriteAcc(filePath, this.account, successor) == false) {
                    JOptionPane.showMessageDialog(this, "Something wrong has occurred");                
                } else {
                    JOptionPane.showMessageDialog(this, "Successfully deposited: " + numDeposit);
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid number");
            }
        }

    }



}