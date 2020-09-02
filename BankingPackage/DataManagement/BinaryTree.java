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

    public void insert(Account newAcc, Node root) {
        if (this.root == null) {
            this.setRoot(new Node(newAcc, null, null));
            return;
        } else {
            root.insertNode(newAcc, root);
        }
    }

    public Account find(Account newAcc, Node root) {
        Node node = root.findAcc(newAcc, root);
        return node.getAccount();
    }

    public void delete(Account acc, Node root) {
        this.setRoot(root.recDelete(acc, root));
    }

    public String toString() {
        if (root == null) {
            return null;
        }
        StringBuffer accounts = new StringBuffer();
        recToString(this.getRoot(), accounts);
        return accounts.toString();
    }
    public void recToString(Node root, StringBuffer buffer) {
        if (root == null) {
            return; 
        }
        recToString(root.getLeft(), buffer); 
        buffer.append(root.getAccount().toString()); 
        buffer.append("\n");
        recToString(root.getRight(), buffer); 
    }
}