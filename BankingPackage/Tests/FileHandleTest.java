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
        Account account = FileRead.FindAccountById(file_name, 3211);

        // Testing if account was actually found, 
        AccountActions.printAccount(account);

        // Testing writing to account to file
        FileWrite.appendAccount(file_name, account.toString()); 

        // Testing error handling of duplicate accounts in database
        Account second = FileRead.FindAccountById(file_name, 2124);

    }

    public static void testCreate() {
        return;
    }


}
