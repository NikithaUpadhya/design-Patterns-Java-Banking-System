
import java.util.Scanner;

public class UpdateAccount {
    public static void updateAccount(Scanner scanner, SecuredBankSystem bankSystem) {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.next();
        System.out.print("Enter New Account Information: ");
        String newInfo = scanner.next(); // Assuming new info as a string for simplicity
        bankSystem.updateAccount(accountId, newInfo);
        System.out.println("Account information updated successfully!");
    }
}
