import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

class BankingSystem {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public BankingSystem() {
        // Single predefined account
        account = new BankAccount(1001, "Dragonmas", 5000.0);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        account.deposit(amount);
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public void displayAccountDetails() {
        account.displayAccountDetails();
    }

    public void start() {
        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> checkBalance();
                case 4 -> displayAccountDetails();
                case 5 -> {
                    System.out.println("Exiting the system. Have a good day!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class BankMang {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.start();
    }
}
