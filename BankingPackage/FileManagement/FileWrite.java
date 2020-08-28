package BankingPackage.FileManagement;
import java.io.*;

public class FileWrite {

    // This function writes a string to the file (APPEND NOT OVERRWRITE)  

    public static void appendFile(String filePath, String text) {
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
            br.write(text + " ");
            br.close();
            System.out.println("Appended to " + filePath + ": " + text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }
    }
    // This function appends a number to a file 
    public static void appendFile(String filePath, int num) {
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
            br.write(String.valueOf(num) + " ");
            br.close();
            System.out.println("Appended to " + filePath + ": " + num);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }
    }
    // This function appends an account to a file, adding a new line after.
    public static void appendFile(String filePath, int id, String pass, String name, int balance) {
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
            br.write(id + " " + pass + " " + name + " " + balance + " ");
            br.newLine();
            br.close();
            System.out.println("Appended to " + filePath + ": " + id + " " + pass + " " + name + " " + balance);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }        
    }
}