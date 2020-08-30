package BankingPackage.DataManagement;
import BankingPackage.Account;



public class Node {
    private Account acc;
    private Node left; 
    private Node right;

    public Node (Account acc) {
        this.setAccount(acc);
        this.setLeft(null);
        this.setRight(null); 
    }
    public Node () {
    }
    
    // Establish getter and setter functions 
    public Account getAccount() {
        return this.acc;
    }

    public void setAccount(Account acc) {
        this.acc = acc;
    }

    public Node getRight() {
        return this.right;
    }
    public void setRight(Node newRight) {
        this.right = newRight;
    }

    public Node getLeft() {
        return this.left;
    } 
    public void setLeft(Node newLeft) {
        this.right = newLeft;
    }



}