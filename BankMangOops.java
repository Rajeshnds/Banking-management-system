import java.util.Scanner;

class BankAccount {
    // Private properties to encapsulate account details
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

public class BankMangOops {
    public static void main(String[] args) {
        // Create a single predefined account
        BankAccount account = new BankAccount(1001, "Alice Smith", 5000.0);

        Scanner scanner = new Scanner(System.in);

        // Simple menu to interact with the single account
        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
