package BankingPackage.Tests;
import BankingPackage.FileManagement.*;
import BankingPackage.DataManagement.*;

public class DataManagementTest {
    public static void main(String args[]) {
        String file_name = FileHandle.createFile();
        String file = FileRead.readFile(file_name);

        BinaryTree tree = FileRead.loadTreeOfAccounts(file);
        tree.printInOrder(tree.getRoot()); 
    }
}