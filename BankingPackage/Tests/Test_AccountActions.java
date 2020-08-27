package BankingPackage.Tests;
import BankingPackage.*;
public class Test_AccountActions {
    public static void main(String args[]) {
        Account test = new Account();
        test.setBalance(3000);
        test.setId(2124); 
        test.setName("John");
        test.setPass("password");
        print_line();

        // Testing withdraw
        print("testing withdraw");
        test.setBalance(3000);
        testWithdraw(test);
        print_line();

        // Testing deposits 
        print("testing deposit");
        test.setBalance(3000);
        testDeposit(test);
        print_line();

        // Testing print
        print("test printing account");
        testPrint(test);
        print_line();
    }

    // Test withdraw function
    public static void testWithdraw(Account acc) {
        System.out.println(acc.getBalance());
        AccountActions.withdraw(acc, 1000);
        System.out.println(acc.getBalance()); 
        return;
    }
    // Test deposit function
    public static void testDeposit(Account acc) {
        System.out.println(acc.getBalance());
        AccountActions.deposit(acc, 1000);
        System.out.println(acc.getBalance()); 
        return;
    }

    // Testing print function
    public static void testPrint(Account acc) {
        AccountActions.printAccount(acc); 
    }

    public static void print_line() {
        System.out.println("-------------------");
    }
    public static void print(String str) {
        System.out.println(str);
    }
}