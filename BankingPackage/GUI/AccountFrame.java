package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.Account;
import BankingPackage.FileManagement.*;

public class AccountFrame extends JFrame implements ActionListener  {

    private Container container;
    private JPanel jLeft = new JPanel();
    private JPanel home = new JPanel();
    private JPanel deposit = new JPanel();
    private JPanel withdraw = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel headerLabel;
    private JLabel balance; 
    private JLabel accountActions = new JLabel("Account Actions");
    private JButton homeButton = new JButton("Home");
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");

    private static final long serialVersionUID = 1L;

    AccountFrame(Account account) {
        setFrame(account);
        setLayoutManager();
        colorPanels();
        setMenuBar();
        // setComponenetPreferredSizes();
        addButtonsToPanel();
        setAlignment();
        addPanels();
    }

    public void setFrame(Account account) {
        this.container = getContentPane();
        this.headerLabel = new JLabel(account.getName() + " " + "Bank Account");
        this.balance = new JLabel(Integer.toString(account.getBalance())); 
        this.setTitle("Account Manager");
        this.setBounds(0, 0, 900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        // this.pack();
        this.setVisible(true);
    }
    public void setLayoutManager() {
        BorderLayout layout = new BorderLayout();
        jLeft.setLayout(new GridBagLayout());
        home.setLayout(new CardLayout());
        buttonPanel.setLayout(new GridLayout(3, 1));
        this.setLayout(layout);
    }

    public GridBagConstraints setMenuBar() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(50, 10, 50, 10);
        jLeft.add(accountActions, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.insets = new Insets(20, 20, 20, 20);
        jLeft.add(buttonPanel, c);
        return c;
    }
    public void addButtonsToPanel() {
        buttonPanel.add(homeButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
    }
    public void setAlignment() {
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setBorder(BorderFactory.createLineBorder(new Color(65, 79, 209)));
    }
    public void setComponenetPreferredSizes() {
        home.setPreferredSize(new Dimension(600, 600));
        jLeft.setPreferredSize(new Dimension(200, 600)); 
    }
    public void colorPanels() {;
        Color modernBlack = new Color(43, 45, 47);
        jLeft.setBackground(Color.BLACK);
        home.setBackground(modernBlack);
        accountActions.setForeground(Color.WHITE); 
        headerLabel.setForeground(Color.WHITE);
        balance.setForeground(Color.WHITE);


    }
    public void addPanels() {
        container.add(home, BorderLayout.CENTER);
        container.add(jLeft, BorderLayout.WEST);
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