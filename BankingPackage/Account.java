package BankingPackage;

/** 
* Class Account holds an id, pass, name and balance of a person. 
* Its methods only change the private properties of an account. 
*/
public class Account {
    private int id; 
    private String pass; 
    private String name; 
    private int balance; 

    public Account(int id, String pass, String name, int balance) {
        this.setId(id);
        this.setPass(pass);
        this.setName(name);
        this.setBalance(balance);
    }

    public Account() {
    }

    // Establish Get/Set functions 
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return this.pass; 
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int balance) {
        this.balance = balance; 
    }
}