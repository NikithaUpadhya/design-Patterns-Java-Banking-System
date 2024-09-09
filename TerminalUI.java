 import java.util.Scanner;

        public class TerminalUI {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                SecuredBankSystem bankSystem = new SecuredBankSystem();
                
                boolean exit = false;
                
                while (!exit) {
                    displayMainMenu();
                    int choice = getUserChoice(scanner);
                    
                    switch (choice) {
                        case 1:
                            CreateAccount.createAccount(scanner, bankSystem);
                            break;
                        case 2:
                            DepositFunds.depositFunds(scanner, bankSystem);
                            break;
                        case 3:
                            WithdrawFunds.withdrawFunds(scanner, bankSystem);
                            break;
                        case 4:
                            CheckBalance.checkBalance(scanner, bankSystem);
                            break;
                        case 5:
                            TransferFunds.transferFunds(scanner, bankSystem);
                            break;
                        case 6:
                            UpdateAccount.updateAccount(scanner, bankSystem);
                            break;
                        case 7:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                
                scanner.close();
                System.out.println("Thank you for using the bank system. Goodbye!");
            }
            
            private static void displayMainMenu() {
                System.out.println(" _______________________________________");
                System.out.println("|                                       |");
                System.out.println("|      Welcome to the Bank System       |");
                System.out.println("|_______________________________________|");
                System.out.println("|                                       |");
                System.out.println("| 1. Create Account                     |");
                System.out.println("| 2. Deposit Funds                      |");
                System.out.println("| 3. Withdraw Funds                     |");
                System.out.println("| 4. Check Balance                      |");
                System.out.println("| 5. Transfer Funds                     |");
                System.out.println("| 6. Update Account Information         |");
                System.out.println("| 7. Exit                               |");
                System.out.println("|_______________________________________|");
                System.out.println("|                                       |");
                System.out.println("| Select an option:                     |");
                System.out.println("|                                       |");
                System.out.println(" ---------------------------------------");
            }
            
            private static int getUserChoice(Scanner scanner) {
                return scanner.nextInt();
            }
        }
        