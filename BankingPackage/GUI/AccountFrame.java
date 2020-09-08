package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BankingPackage.Account;
import BankingPackage.FileManagement.*;

public class AccountFrame extends JFrame implements ActionListener  {

    private Account account; 
    private Container container;
    private CardLayout cards = new CardLayout();
    private JPanel jLeft = new JPanel();
    private JPanel cardPanel = new JPanel();
    private HomePanel home = new HomePanel();
    private DepositPanel deposit = new DepositPanel();
    private JPanel withdraw = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JLabel accountActions = new JLabel("Account Actions");
    private JButton homeButton = new JButton("Home");
    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");

    private static final long serialVersionUID = 1L;

    AccountFrame(Account account) {
        updateAccount(account);
        setFrame(account);
        setLayoutManager();
        setCards(account);
        colorPanels();
        setMenuBar();
        addButtonsToMenu();
        addPanels();
        addActionEvent();
    }

    public void updateAccount(Account account) {
        int id = account.getId();
        String filePath = FileHandle.createFile();
        String file = FileRead.readFile(filePath);
        Account updated = FileRead.findAccountById(file, id);
        this.account = updated; 
    }

    public void setFrame(Account account) {
        this.container = getContentPane();

        this.setTitle("Account Manager");
        this.setBounds(0, 0, 900, 600);
        this.setPreferredSize(new Dimension(600, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }

    public void setLayoutManager() {
        BorderLayout layout = new BorderLayout();
        jLeft.setLayout(new GridBagLayout());
        cardPanel.setLayout(cards);
        buttonPanel.setLayout(new GridLayout(3, 1));
        this.setLayout(layout);
    }

    public void setCards(Account account) {
        home = new HomePanel(account);
        deposit = new DepositPanel(account);
        cardPanel.add(home, "1");
        cardPanel.add(deposit, "2");
        cardPanel.add(withdraw, "3");
        cards.show(cardPanel, "1");
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
    public void addButtonsToMenu() {
        buttonPanel.add(homeButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
    }


    public void colorPanels() {;
        Color modernBlack = new Color(43, 45, 47);
        jLeft.setBackground(Color.BLACK);

        withdraw.setBackground(modernBlack);
        deposit.setBackground(modernBlack);

        accountActions.setForeground(Color.WHITE); 

    }
    public void addPanels() {
        container.add(cardPanel, BorderLayout.CENTER);
        container.add(jLeft, BorderLayout.WEST);
    }

    public void addActionEvent() {
        depositButton.addActionListener(this);
        homeButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            updateAccount(this.account);
            deposit = new DepositPanel(this.account);
            cardPanel.add(deposit, "2");
            cards.show(cardPanel, "2");
        }
        if (e.getSource() == homeButton) {
            // this.setCards();
            updateAccount(this.account);
            home = new HomePanel(this.account);
            cardPanel.add(home, "1");
            cards.show(cardPanel, "1");
        }
    }

    public static void main(String args[]) {
        String filePath = FileHandle.createFile();
        String file = FileRead.readFile(filePath);
        Account acc = FileRead.findAccountById(file, 2124);
        AccountFrame frame = new AccountFrame(acc);
    }
}