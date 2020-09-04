package BankingPackage.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BankInterface {

    public BankInterface() {
        prepareLogin();
    }

    private void prepareLogin() {
        LoginFrame login = new LoginFrame();
        login.setTitle("Gu Banking Login");
        login.setBounds(10, 10, 400, 400);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }
    public static void main(String args[]) {
        BankInterface graphic = new BankInterface();
    }
}