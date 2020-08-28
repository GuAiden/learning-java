package BankingPackage.FileManagement;
import java.io.*;
import BankingPackage.Account;
public class FileWrite {

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
            System.out.println("Appended to " + filePath + ": " + text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }        
    }

    // This function will overwrite an old account with a new successor account
    public static void overWrite(String filePath, Account predecessor, Account successor) {
        
    }
    
    // This function will change a certain property of an account
    public static void changeAccProperty(String filePath, Account acc, String change, String member) {

    }

}