package BankingPackage.DataManagement;
import BankingPackage.AccountActions;
import BankingPackage.Account;
public class BinaryTree {

    // Properties/Members
    private Node root; 

    // Initializers
    public BinaryTree(Node root) {
        this.root = root; 
    }
    public BinaryTree() {
    }

    // Getter and Setters
    public Node getRoot() {
        return this.root;
    }
    public void setRoot(Node root) {
        this.root = root; 
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0; 
        } 
        int leftDepth = getHeight(root.getLeft()); 
        int rightDepth = getHeight(root.getRight());
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        return maxDepth;
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.getLeft());
        AccountActions.printAccId(root.getAccount()); 
        printInOrder(root.getRight());
    }

    public void insertNode(Account newAcc, Node root) {
        if (root == null) {
            this.root = new Node(newAcc, null, null);
        }
        Account current = root.getAccount();
        if (newAcc.getId() < current.getId()) {
            this.insertNode(newAcc, root.getLeft()); 
        } else if (newAcc.getId() > current.getId()) {
            this.insertNode(newAcc, root.getRight()); 
        } else {
            System.out.println("Something wrong has occurred, multiple ID's detected");
        }
    }
}