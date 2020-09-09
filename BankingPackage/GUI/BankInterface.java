package BankingPackage.GUI;
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