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
    }
    public static void main(String args[]) {
        BankInterface graphic = new BankInterface();
    }
}