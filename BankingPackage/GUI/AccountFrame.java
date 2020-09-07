package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.Account;
import BankingPackage.FileManagement.*;

public class AccountFrame extends JFrame implements ActionListener  {

    private Container container;
    private JPanel jLeft = new JPanel();
    private JPanel jRight = new JPanel();
    private JPanel jCenter = new JPanel();
    private JPanel jTop = new JPanel();
    private JPanel subJTop = new JPanel();
    private JPanel jBottom = new JPanel();
    private JLabel headerLabel;
    private JLabel balance; 
    private JButton deposit = new JButton("Deposit");
    private JButton withdraw = new JButton("Withdraw");

    private static final long serialVersionUID = 1L;

    AccountFrame(Account account) {
        setFrame(account);
        setLayoutManager();
        colorPanels();
        setComponenetPreferredSizes();
        addComponents();
    }

    public void setFrame(Account account) {
        this.container = getContentPane();
        this.headerLabel = new JLabel(account.getName() + " " + "Account");
        this.balance = new JLabel(Integer.toString(account.getBalance())); 
        this.setTitle("Account Manager");
        this.setBounds(10, 10, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public void setLayoutManager() {
        BorderLayout layout = new BorderLayout(0, 0);
        // jTop.setLayout(layout);
        this.setLayout(layout);
    }

    public void setComponenetPreferredSizes() {
        jTop.setPreferredSize(new Dimension(600, 100));
        jCenter.setPreferredSize(new Dimension(500, 600));
        jLeft.setPreferredSize(new Dimension(100, 800)); 
        jRight.setPreferredSize(new Dimension(150, 600));
        jBottom.setPreferredSize(new Dimension(600, 100));
        subJTop.setPreferredSize(new Dimension(100, 100));
        headerLabel.setPreferredSize(new Dimension(100, 100));
        balance.setPreferredSize(new Dimension(50, 50));
    }
    public void colorPanels() {
        Color modernBlue = new Color(81, 98, 247);
        Color modernGrey = new Color(107, 109, 127);
        jTop.setBackground(modernBlue);
        subJTop.setBackground(modernGrey);
        jLeft.setBackground(modernGrey);
        jRight.setBackground(modernBlue);
        jCenter.setBackground(modernBlue);
        jBottom.setBackground(modernBlue);
    }
    public void addComponents() {
        container.add(jTop, BorderLayout.NORTH);
        container.add(jBottom, BorderLayout.SOUTH);
        container.add(jCenter, BorderLayout.CENTER);
        container.add(jLeft, BorderLayout.WEST);
        container.add(jRight, BorderLayout.EAST);

        jTop.add(subJTop, BorderLayout.WEST);
        // jTop.add(headerLabel);
        jCenter.add(balance, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String args[]) {
        String filePath = FileHandle.createFile();
        String file = FileRead.readFile(filePath);
        Account acc = FileRead.findAccountById(file, 2124);
        AccountFrame frame = new AccountFrame(acc);
    }
}