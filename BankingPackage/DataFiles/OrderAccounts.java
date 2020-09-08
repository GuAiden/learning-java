package BankingPackage.DataFiles;

import BankingPackage.FileManagement.FileHandle;
import BankingPackage.FileManagement.FileRead;
import BankingPackage.DataManagement.BinaryTree;

public class OrderAccounts {
    public static void main(String args[]) {
        String filePath = FileHandle.createFile();
        String file = FileRead.readFile(filePath);
        BinaryTree tree = FileRead.loadTreeOfAccounts(file);
        tree.printInOrder(tree.getRoot());
    }
    
}