package Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static AccountDAO accountDAO = new AccountDAO();

    public static void main(String[] args) {

        Account account = accountDAO.loadAccount();
        boolean running = true;

        while (running) {
            showMenu();
            int choice = getChoice();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = getAmount();
                        account.deposit(depositAmount);
                        accountDAO.saveAccount(account);
                        System.out.println("Amount deposited successfully.");
                        break;

                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = getAmount();
                        account.withdraw(withdrawAmount);
                        accountDAO.saveAccount(account);
                        System.out.println("Amount withdrawn successfully.");
                        break;

                    case 4:
                        running = false;
                        accountDAO.saveAccount(account);
                        System.out.println("Thank you for using ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select again.");
                }
            } catch (InsufficientFundsException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--- ATM MENU ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return -1;
        }
    }

    private static double getAmount() {
        try {
            double amount = scanner.nextDouble();
            return amount;
        } catch (InputMismatchException e) {
            scanner.next();
            throw new IllegalArgumentException("Invalid amount entered.");
        }
    }
}
