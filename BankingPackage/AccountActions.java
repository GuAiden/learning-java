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
        if (acc == null) {
            return;
        }
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

    public static boolean compareAcc(Account first, Account second) {
        if (!compareId(first, second)) {
            return false;
        } else if (!comparePass(first, second)) {
            return false;
        } else if (!compareName(first, second)) {
            return false;
        } else if (!compareBal(first, second)) {
            return false;
        } else {
            return true; 
        }
    }

    public static boolean compareId(Account first, Account second) {
        return (first.getId() == second.getId());
    }

    public static boolean comparePass(Account first, Account second) {
        String firstPass = first.getPass();
        if (firstPass.compareTo(second.getPass()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compareName(Account first, Account second) {
        // Might adjust for lower case
        String firstName = first.getName();
        if (firstName.compareTo(second.getName()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compareBal(Account first, Account second) {
        return (first.getBalance() == second.getBalance()); 
    }

    /** 
     *  This function scans a string input and if it matches an account property, 
    *  returns an appropriate integer value, enum style for the account property:
    *  -1 = bad input, 0 = id; 1 = pass; 2 = name; 3 = balance
    */
    public static int whatProperty(String property) {
        switch(property.toLowerCase()) {
            case "id":
                return 0;
            case "pass":
                return 1;
            case "password":
                return 1;
            case "name":
                return 2;
            case "bal":
                return 3;
            case "balance":
                return 3;
            default:
                return -1;
        }
    }
    /** 
     *  This function changes a certain property given an index, 
     *  0 = id, 1 = pass, 2 = name, 3 = balance,
     */
    public static Account changeProperty(Account acc, int index, String change) {
        if (index == -1) {
            return null;
        }
        String[] list; 
        list = new String[4];
        list[0] = Integer.toString(acc.getId());
        list[1] = acc.getPass();
        list[2] = acc.getName();
        list[3] = Integer.toString(acc.getBalance());
        list[index] = change;
        Account updatedAcc = new Account(Integer.parseInt(list[0]), list[1], list[2], Integer.parseInt(list[3]));
        return updatedAcc;
    }

    /**
     * This function assumes that the input will be as such, 
     * "id pass name balance", later on should add functions that
     * ensure that id is of int type, pass, name, balance are of
     * correct input. 
     * @param account_details
     * @return
     */
    public static Account createAccount(String account_details) {
        String[] input = account_details.split("\s");
        int id = Integer.parseInt(input[0]); 
        String pass = input[1]; 
        String name = input[2];
        int balance = Integer.parseInt(input[3]); 
        Account acc = new Account(id, pass, name, balance);
        return acc;
    }
     
}