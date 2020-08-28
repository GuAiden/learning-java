package BankingPackage.FileManagement;

import java.io.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
public class FileRead {
    /**
     * This function reads thorugh a file and returns the number of lines read
     * @param filePath = Path to file
     */
    public static int readFile(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int i = 0;
            try {
                while (line != null) {
                    line = br.readLine();
                    i++;
                }
            } finally {
                br.close();
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
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
     * This function reads up to a certain id and prints that one account 
     */
    public static void printAccountById(String filePath, int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = br.readLine();
            while (line != null) {
                String[] account = line.split(" ");
                int accountId = Integer.parseInt(account[0]);
                System.out.println(accountId);
                if (accountId == id) {
                    System.out.println("Found account: " + account[0] + " " + account[1] + " ");
                    Account acc = new Account(accountId, account[1], account[2], Integer.parseInt(account[3]));
                    AccountActions.printAccount(acc);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public static boolean isInt(String text) {
        if (text.isEmpty()) return false;
        for(int i = 0; i < text.length(); i++) {
            if(i == 0 && text.charAt(i) == '-') {
                if(text.length() == 1) return false;
                else continue;
            }
            if(Character.digit(text.charAt(i), 10) < 0) return false;
        }
        return true;    
    }
}