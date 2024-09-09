// TransferFunds.java
import java.util.Scanner;

public class TransferFunds {
    public static void transferFunds(Scanner scanner, SecuredBankSystem bankSystem) {
        System.out.print("Enter Source Account ID: ");
        String sourceAccountId = scanner.next();
        System.out.print("Enter Destination Account ID: ");
        String destinationAccountId = scanner.next();
        System.out.print("Enter Transfer Amount: ");
        double amount = scanner.nextDouble();
        bankSystem.transferFunds(sourceAccountId, destinationAccountId, amount);
        System.out.println("Funds transferred successfully!");
    }
}
