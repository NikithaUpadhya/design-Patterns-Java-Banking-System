// WithdrawFunds.java
import java.util.Scanner;

public class WithdrawFunds {
    public static void withdrawFunds(Scanner scanner, SecuredBankSystem bankSystem) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.next();
        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();
        boolean success = bankSystem.withdraw(accountId, amount);
        if (success) {
            System.out.println("Funds withdrawn successfully!");
        } else {
            System.out.println("Insufficient funds or account not found.");
        }
    }
}
