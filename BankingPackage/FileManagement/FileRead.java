package BankingPackage.FileManagement;

import java.io.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
import BankingPackage.DataManagement.*;
public class FileRead {

    /**
     * Read through the file and return a string of the contents, 
     */
    public static String readFile(String filePath) {
        StringBuffer buffer = new StringBuffer(); 
        try {
            BufferedReader file = new BufferedReader(new FileReader(new File(filePath)));
            String line = file.readLine();
            while (line != null) {
                buffer.append(line); 
                buffer.append("\n"); 
                line = file.readLine();
            }
            file.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
    /**
     * This function reads thorugh a file and returns the number of lines read
     * @param filePath = Path to file
     */
    public static int numAccounts(String fileContents) {
        String[] splitFile = fileContents.split("\n");
        return splitFile.length;
    }    
    
    /**
     * This function prints a data file out line by line
     */
    public static void printFile(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 
     * This function reads up to a certain id and returns that account as an object
     */
    public static Account findAccountById(String fileContents, int id) {
        // Test if there are duplicates in datafile
        if (FileRead.isDuplicate(fileContents, id)) {
            System.out.println("Sorry, an issue has occured");
            return null;
        }

        String[] accounts = fileContents.split("\n");
        for (int i = 0; i < accounts.length; i++) {
            String[] account = accounts[i].split("\s"); 
            if (Integer.parseInt(account[0]) == id) {
                Account foundAcc = AccountActions.createAccount(accounts[i]); 
                System.out.println("Found Account"); 
                return foundAcc;
            }
        }
        return null; 
    }

    /**
     * This function searches for duplicates in a certain id and returns -1 for no duplicates, 
     * Potential bug: assumes that there is always a possible int on every line 
     */
    public static boolean isDuplicate(String fileContents, int id) {
        int i = 0;
        String[] listAccounts = fileContents.split("\s|\n"); 
        for (int j = 0; j < listAccounts.length; j += 4) {
            int curr_id = Integer.parseInt(listAccounts[j]); 
            if (curr_id == id) {
                i++;
            }
        }
        if (i > 1) {
            return true;
        } else {
            return false;
        }       
    }

    /**
     * This function reads the file and loads in the accounts into a linked list data structure
     */
    public static Account[] loadListOfAccounts(String fileContents) {
        Account[] listOfAccounts;
        int numAccounts = FileRead.numAccounts(fileContents);
        listOfAccounts = new Account[numAccounts];
        String[] accounts = fileContents.split("\n");
        for (int i = 0; i < accounts.length; i++) {
            listOfAccounts[i] = AccountActions.createAccount(accounts[i]);
        }
        return listOfAccounts;
    }

    public static BinaryTree loadTreeOfAccounts(String fileContents) {
        BinaryTree tree = new BinaryTree();
        String[] accounts = fileContents.split("\n");
        for (int i = 0; i < accounts.length; i++) {
            Account account = AccountActions.createAccount(accounts[i]); 
            Node root = tree.getRoot();
            tree.insertNode(account, root); 
        }
        return tree; 
    }
}