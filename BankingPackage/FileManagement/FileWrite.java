package BankingPackage.FileManagement;
import java.io.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
public class FileWrite {

    /**
     * Functions writes over a file with a new string 
     * @param filePath 
     * @param text
     */
    public static void writeOver(String filePath, String text) {
        try {
            File file = new File(filePath); 
            FileWriter fr = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(text); 
            br.close();
            System.out.println("Wrote to " + filePath + ": \n" + text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }                
    }
    // This function appends an account to a file, adding a new line after.
    public static void appendAccount(String filePath, String text) {
        try {
            File file = new File(filePath); 
            FileWriter fr = null;
            if (file.exists()) {
                fr = new FileWriter(file, true);
            } else {
                System.out.println("File does not exist");
                return;
            }
            BufferedWriter br = new BufferedWriter(fr);
            br.write(text); 
            br.close();
            System.out.println("Appended to " + filePath + ": \n" + text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }        
    }

    // This function will overwrite an old account with a new successor account
    public static void overWriteAcc(String filePath, Account predecessor, Account successor) {
        // Read file, change line, then overwrite existing file, 
        if (predecessor == null || successor == null) {
            System.out.println("Accounts don't exist"); 
            return;
        }
        String file = FileRead.readFile(filePath);
        String newFile = new String();
        Account[] accounts = FileRead.loadListOfAccounts(file); 
        int numAcc = FileRead.numAccounts(file);
        for (int i = 0; i < numAcc; i++) {
            if (AccountActions.compareAcc(predecessor, accounts[i])) {
                accounts[i] = successor; 
            }
            newFile = newFile + accounts[i].toString() + "\n";
        }
        FileWrite.writeOver(filePath, newFile);
    }
    
    // This function will change a certain property of an account
    public static void changeAccProperty(String filePath, Account acc, String change, String member) {
        int property = AccountActions.whatProperty(member);
        Account updatedAcc = AccountActions.changeProperty(acc, property, change);
        FileWrite.overWriteAcc(filePath, acc, updatedAcc);
        return;
    }

    /**
     * Deletes an account from file registry. First reads the file,
     * rewrites the file string and over writes the previous file. 
     */
    public static void deleteAcc(String filePath, Account acc) {
        String file = FileRead.readFile(filePath);
        Account[] accounts = FileRead.loadListOfAccounts(file); 
        int numAcc = FileRead.numAccounts(file); 
        String newFile = new String(); 
        for (int i = 0; i < numAcc; i++) {
            if (AccountActions.compareAcc(accounts[i], acc)) { 
                System.out.println("Successfully deleted: " + accounts[i].toString() + "\n"); 
                continue;
            }
            newFile = newFile + accounts[i].toString() + "\n";
        }
        FileWrite.writeOver(filePath, newFile); 
    }

}