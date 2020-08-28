package BankingPackage.Tests;
import BankingPackage.FileManagement.*;
import BankingPackage.Account;

public class FileHandleTest {
    public static void main(String args[]) {
        String file_name = FileHandle.createFile();
        Account random = new Account(2124, "password", "John", 1000); 
        FileWrite.appendFile(file_name, random.getId(), random.getPass(), random.getName(), random.getBalance());
        FileWrite.appendFile("imaginaryFile", random.getId());
        FileRead.printFile(file_name);
        FileRead.printAccountById(file_name, 3211);
    }

    public static void testCreate() {
        return;
    }


}
