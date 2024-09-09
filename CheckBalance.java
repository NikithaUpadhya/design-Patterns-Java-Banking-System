import java.util.Scanner;

public class CheckBalance {
    public CheckBalance() {
    }

    public static void checkBalance(Scanner scanner, SecuredBankSystem bankSystem, String username) {
        double balance = bankSystem.checkBalance(username);
        if (balance >= 0.0) {
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Account not found.");
        }

    }
}
