package BankingPackage.DataManagement;
import BankingPackage.Account;

public class Node {

    private Account acc;
    private Node left; 
    private Node right;

    public Node (Account acc, Node left, Node right) {
        this.setAccount(acc);
        this.setLeft(left);
        this.setRight(right); 
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

    public Node insertNode(Account newAcc, Node root) {
        if (root == null) {
            root = new Node(newAcc, null, null);
            return root;
        } 
        Account current = root.getAccount();
        if (newAcc.getId() < current.getId()) {
            root.setLeft(this.insertNode(newAcc, root.getLeft())); 
        } else if (newAcc.getId() > current.getId()) {
            root.setRight(this.insertNode(newAcc, root.getRight()));
        } else {
            System.out.println("Something wrong has happened");
        }
        return root;
    }

}