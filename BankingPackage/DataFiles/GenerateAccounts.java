package BankingPackage.DataFiles;

import BankingPackage.Account;
import BankingPackage.AccountActions;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import BankingPackage.FileManagement.*;

public class GenerateAccounts {
    final String name_chars = "abcdefghijklmnopqrstuvwxyz";
    final String pass_chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    final Random rand = new Random();
    final Set<String> name_identifiers = new HashSet<String>();
    final Set<Integer> id_identifiers = new HashSet<Integer>();

    public static void main(String args[]) {
        
        GenerateAccounts generate = new GenerateAccounts(); 
        // Generate 1000 accounts, 
        for (int i = 0; i < 50; i++) {
            int id = generate.idGenerate(i);
            String pass = generate.passGenerate();
            String name = generate.nameGenerate();
            int balance = generate.balGenerate();
            String account_details = Integer.toString(id) + " " + pass + " " + name + " " + Integer.toString(balance);
            String filePath = FileHandle.createFile();
            FileWrite.appendAccount(filePath, account_details);
        }


    }

    public String nameGenerate() {
        StringBuilder name = new StringBuilder();

        while (name.toString().length() == 0) {

            // Set the random name length
            int length = rand.nextInt(5) + 5;
            
            // For every letter up to the name length, assign a random char. 
            for (int i = 0; i < length; i++) {
                name.append(name_chars.charAt(rand.nextInt(name_chars.length())));
            }

            // If such a name already exists, reset the stringbuilder
            if (name_identifiers.contains(name.toString())) {
                name = new StringBuilder();
            }
        }
        return name.toString();
    }

    // We don't care about unique passwords, so just use whatever
    public String passGenerate() {
        StringBuilder pass = new StringBuilder();

        int length = rand.nextInt(10) + 5;
        for (int i = 0; i < length; i++) {
            pass.append(pass_chars.charAt(rand.nextInt(pass_chars.length())));
        }
        return pass.toString();
    }

    public int idGenerate(int index) {
        IntStream idList = rand.ints(3000, 1000, 10000);
        int[] idArray = idList.toArray();
        int id = idArray[index];
        if (id_identifiers.contains(id)) {
            id = idGenerate(index);
        }
        return id;
    }

    public int balGenerate() {
        int balance = rand.nextInt(10000);
        return balance;
    }
}