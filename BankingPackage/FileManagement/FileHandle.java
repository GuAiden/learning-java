package BankingPackage.FileManagement;
import java.io.*;

/**
 * This class will handle the files that contain
 * account details, i.e. store name, id, user, pass etc.
 */
public class FileHandle {
    /** 
     * Creates a file for accounts, returning the path to such file
     */    
    public static String createFile() {
        try {
            String dirName = "C:\\Users\\Aiden Gu\\Desktop\\Programming\\Java\\BankingPackage\\Data";
            String fileName = "accounts_list.txt";
            File dir = new File(dirName);
            File f = new File(dir, fileName);
            if (f.createNewFile()) {
                System.out.println("Created file: " + f.getName());
            } 
            return f.getPath();
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        System.out.println("An error has occured");
        return "Error";
    }
    /** 
    * Deletes a file, takes input of the file path. Returns true if successful
    */    
    public static boolean deleteFile(String filePath) {
        try {
            File f = new File(filePath);
            if (f.delete()) {
                System.out.println("File deleted: " + f.getName());
            } else {
                System.out.println("Failed to delete");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
