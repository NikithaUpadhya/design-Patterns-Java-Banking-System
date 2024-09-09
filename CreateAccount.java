
import java.util.Scanner;

public class CreateAccount {
    public static void createAccount(Scanner scanner, SecuredBankSystem bankSystem) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        bankSystem.createAccount(accountId, initialBalance);
        System.out.println("Account created successfully!");
    }
}
