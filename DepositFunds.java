// DepositFunds.java
import java.util.Scanner;

public class DepositFunds {
    public static void depositFunds(Scanner scanner, SecuredBankSystem bankSystem) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.next();
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        bankSystem.deposit(accountId, amount);
        System.out.println("Funds deposited successfully!");
    }
}
