package BankingPackage.FileManagement;
import java.io.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;
public class FileWrite {

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
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath)); 
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            // Read through the file and add it to the string buffer, 
            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n'); 
            }
            file.close();

            // Now change the account within the string buffer
            String input = inputBuffer.toString();

            String[] splitInput = input.split("\s|\n");
            int size = splitInput.length;

            // Find the account to change, 
            for (int i = 0; i < size; i += 4) {
                int id = Integer.parseInt(splitInput[i]);
                String pass = splitInput[i+1];
                String name = splitInput[i+2];
                int bal = Integer.parseInt(splitInput[i+3]);
                
                Account temp = new Account(id, pass, name, bal); 
                if (AccountActions.compareAcc(temp, predecessor)) {
                    input = input.replace(predecessor.toString(), successor.toString()); 
                    System.out.println("Successfuly overwritten"); 
                }
            }
            // Write 
            FileWrite.writeOver(filePath, input);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
    
    // This function will change a certain property of an account
    public static void changeAccProperty(String filePath, Account acc, String change, String member) {
        int property = AccountActions.whatProperty(member);
        Account updatedAcc = AccountActions.changeProperty(acc, property, change);
        FileWrite.overWriteAcc(filePath, acc, updatedAcc);
        return;
    }

}