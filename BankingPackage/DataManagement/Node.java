package BankingPackage.DataManagement;
import BankingPackage.Account;
import BankingPackage.AccountActions;
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

    public Node findAcc(Account newAcc, Node root) {
        if (root == null) {
            System.out.println("Not found");
            return null; 
        }
        Account current = root.getAccount();
        if (AccountActions.compareAcc(newAcc, current)) {
            System.out.println("The account exists and belongs to " + current.getName()); 
            return root; 
        }

        if (newAcc.getId() < current.getId()) {
            findAcc(newAcc, root.getLeft());
        } else if (newAcc.getId() > current.getId()) {
            findAcc(newAcc, root.getRight());
        }
        return root; 
    }

    public Node recDelete(Account acc, Node root) {
        if (root == null) {
            return root;
        }
        Account current = root.getAccount(); 
        if (acc.getId() < current.getId()) {
            root.setLeft(recDelete(acc, root.getLeft())); 
        } else if (acc.getId() > current.getId()) {
            root.setRight(recDelete(acc, root.getRight()));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setAccount(minValue(root.getRight()));
            root.setRight(recDelete(acc, root.getRight()));
        }
        return root;
    }

    public Account minValue(Node root) {
        Account minv = root.getAccount();
        while (root.getLeft() != null) {
            minv = root.getLeft().getAccount();
            root = root.getLeft();
        }
        return minv;
    }

}