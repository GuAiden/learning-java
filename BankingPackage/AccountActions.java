package BankingPackage;

/**
 * This class performs the basic transactional actions that 
 * changes accounts, i.e. Deposit, Withdraw, Print Balance, 
 */
public class AccountActions {
    /** 
     * This take in the deposit cheque and adds it to
     * the current balance in an account. Returns new balance. 
     */
    public static int deposit(Account acc, int cheque) {
        int currBal = acc.getBalance(); 
        int newBal = currBal + cheque;
        acc.setBalance(newBal); 
        return newBal;
    }

    /**
     * This takes in the amount to be withdrawed, and deducts
     * it from the current balance in the account, returns new balance. 
     */
     public static int withdraw(Account acc, int sum) {
         int currBal = acc.getBalance(); 
         int newBal = currBal - sum; 
         acc.setBalance(newBal); 
         return newBal;
     }

     // Prints account name and balance
     public static void printAccount(Account acc) {
         System.out.println("Name: " + acc.getName());
         System.out.println("Balance: "+ acc.getBalance());
         return;
     }

     // Prints balance of an account
     public static void printBal(Account acc) {
         System.out.println(acc.getBalance());
     }

     // Prints name of an account
     public static void printAccName(Account acc) {
         System.out.println(acc.getName());
     }

     
}