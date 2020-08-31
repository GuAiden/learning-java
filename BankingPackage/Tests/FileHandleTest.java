package BankingPackage.Tests;
import BankingPackage.FileManagement.*;
import BankingPackage.Account;
import BankingPackage.AccountActions;

public class FileHandleTest {
    public static void main(String args[]) {

        String file_name = FileHandle.createFile();
        /**
         * Test File Reading
         */
        String file = FileRead.readFile(file_name);
        System.out.println(file);
        int numAcc = FileRead.numAccounts(file);

        Account acc = FileRead.findAccountById(file, 9999);
        AccountActions.printAccount(acc);
        System.out.println("\n");

        Account[] listAcc = FileRead.loadListOfAccounts(file);
        for (int i = 0; i < numAcc ; i++) {
            AccountActions.printAccount(listAcc[i]);
        }
        System.out.println("\n");

        /**
         * Testing file write functions
         */
        Account newAcc = new Account(2222, "hello", "world", 1);
        FileWrite.overWriteAcc(file_name, listAcc[1], newAcc);
        // Testing delete account function
        FileWrite.deleteAcc(file_name, newAcc);
    }

    public static void testCreate() {
        return;
    }


}
