package BankingPackage.Tests;
import BankingPackage.FileHandle;
public class Test_FileHandle {
    public static void main(String args[]) {
        String file_name = FileHandle.createFile();
        FileHandle.deleteFile(file_name);
    }
}