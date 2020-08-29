package BankingPackage.Tests;
import BankingPackage.FileManagement.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;

public class FileHandleTest {
    public static void main(String args[]) {

        String file_name = FileHandle.createFile();
        /** Testing file writing and reading 
        Account random = new Account(2124, "password", "John", 1000); 
        FileWrite.appendFile(file_name, random.getId(), random.getPass(), random.getName(), random.getBalance());
        FileWrite.appendFile("imaginaryFile", random.getId());
        */
        // FileRead.printFile(file_name);

        // Testing finding account
        Account first = FileRead.findAccountById(file_name, 2125);

        // Testing if account was actually found, 
        AccountActions.printAccount(first);

        // Testing writing to account to file
        // FileWrite.appendAccount(file_name, first.toString()); 

        // Testing error handling of duplicate accounts in database
        Account acc = FileRead.findAccountById(file_name, 1999);
        
        // FileWrite.overWriteAcc(file_name, first, newFirst); 

        // Testing 
        FileWrite.changeAccProperty(file_name, acc, "1999", "balance");

    }

    public static void testCreate() {
        return;
    }


}
