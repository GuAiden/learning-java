package BankingPackage.FileManagement;

import java.io.*;
import BankingPackage.Account;
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
    public static Account FindAccountById(String filePath, int id) {
        if (FileRead.isDuplicate(filePath, id)) {
            System.out.println("Sorry, an issue has occured");
            return null;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = br.readLine();
            while (line != null) {
                String[] account = line.split(" ");
                int accountId = Integer.parseInt(account[0]);
                if (accountId == id) {
                    System.out.println("Found account, ");
                    Account acc = new Account(accountId, account[1], 
                                              account[2], Integer.parseInt(account[3]));
                    br.close();
                    return acc;
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        System.out.println("Could not find account");       
        return null;
    }

    /**
     * This function searches for duplicates in a certain id and returns -1 for no duplicates, 
     *  
     */
    public static boolean isDuplicate(String filePath, int id) {
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String line = br.readLine();
            while (line != null) {
                String[] account = line.split(" ");
                if (Integer.parseInt(account[0]) == id) {
                    i++;
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      

        if (i > 1) {
            return true;
        } else {
            return false;
        }       
    }
}