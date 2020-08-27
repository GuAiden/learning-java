package BankingPackage.Tests;
import BankingPackage.FileHandle;
import BankingPackage.Account;
import BankingPackage.AccountActions;
public class Test_FileHandle {
    public static void main(String args[]) {

        String file_name = FileHandle.createFile();
        Account random = new Account(2124, "password", "John", 1000); 
        AccountActions.printAccount(random);
        FileHandle.writeFile(file_name, random.getId());
    }
}