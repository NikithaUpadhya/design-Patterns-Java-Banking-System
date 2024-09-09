import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SecuredBankSystem {
    private Map<String, SecureAccount> accounts;

    public SecuredBankSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountId, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, new SecureAccount(initialBalance));
            System.out.println("Account created: " + accountId + ", Balance: " + initialBalance);
            saveToFile("Data.txt"); 
        } else {
            System.out.println("Account already exists: " + accountId);
        }
    }
    

    public void deposit(String accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            accounts.get(accountId).deposit(amount);
            System.out.println("Deposited " + amount + " into account " + accountId);
            saveToFile("Data.txt"); 
        }
    }
    
    public boolean withdraw(String accountId, double amount) {
        if (accounts.containsKey(accountId)) {
            boolean success = accounts.get(accountId).withdraw(amount);
            if (success) {
                System.out.println("Withdrawn " + amount + " from account " + accountId);
                saveToFile("Data.txt"); 
            } else {
                System.out.println("Withdrawal failed. Insufficient funds in account " + accountId);
            }
            return success;
        }
        return false;
    }
    
    public double checkBalance(String accountId) {
        if (accounts.containsKey(accountId)) {
            double balance = accounts.get(accountId).getBalance();
            System.out.println("Balance of account " + accountId + ": " + balance);
            return balance;
        }
        System.out.println("Account not found: " + accountId);
        return -1; 
    }
    
    public void transferFunds(String sourceAccountId, String destinationAccountId, double amount) {
        if (accounts.containsKey(sourceAccountId) && accounts.containsKey(destinationAccountId)) {
            SecureAccount sourceAccount = accounts.get(sourceAccountId);
            SecureAccount destinationAccount = accounts.get(destinationAccountId);
            boolean success = sourceAccount.withdraw(amount);
            if (success) {
                destinationAccount.deposit(amount);
                System.out.println("Transferred " + amount + " from account " + sourceAccountId + " to account " + destinationAccountId);
                saveToFile("Data.txt"); 
            } else {
                System.out.println("Transfer failed. Insufficient funds in account " + sourceAccountId);
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }
    
    public void updateAccount(String accountId, String newInfo) {
        if (accounts.containsKey(accountId)) {
            // Assuming newInfo update logic
            System.out.println("Updated account " + accountId + ": " + newInfo);
            saveToFile("Data.txt"); // Save data to file after updating account information
        } else {
            System.out.println("Account not found: " + accountId);
        }
    }
    

    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, SecureAccount> entry : accounts.entrySet()) {
                SecureAccount account = entry.getValue();
                writer.write(entry.getKey() + "," + account.getBalance() + "\n");
            }
            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Line read from file: " + line); // Debug statement
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String accountId = parts[0];
                    double balance = Double.parseDouble(parts[1]);
                    accounts.put(accountId, new SecureAccount(balance));
                }
            }
            System.out.println("Data loaded from file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SecuredBankSystem bankSystem = new SecuredBankSystem();

        // Example usage
        bankSystem.createAccount("123456", 1000);
        bankSystem.deposit("123456", 500);
        bankSystem.saveToFile("Data.txt");

        // Later, when needed...
        bankSystem.loadFromFile("Data.txt");
    }
}

class SecureAccount {
    private double balance;

    public SecureAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
