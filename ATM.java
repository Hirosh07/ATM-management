package atm;

import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;
    private boolean authenticated;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
        this.authenticated = false;
    }

    public void authenticate(int inputPin) {
        if (inputPin == pin) {
            authenticated = true;
            System.out.println("Authentication successful.");
        } else {
            authenticated = false;
            System.out.println("Authentication failed. Please try again.");
        }
    }

    public void checkBalance() {
        if (authenticated) {
            System.out.println("Current balance: $" + balance);
        } else {
            System.out.println("Please authenticate first.");
        }
    }

    public void deposit(double amount) {
        if (authenticated) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Please authenticate first.");
        }
    }

    public void withdraw(double amount) {
        if (authenticated) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
            } else {
                System.out.println("Invalid withdraw amount or insufficient balance.");
            }
        } else {
            System.out.println("Please authenticate first.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.00, 1234); // Initial balance and PIN

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Authenticate");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter PIN: ");
                    int inputPin = scanner.nextInt();
                    atm.authenticate(inputPin);
                    break;
                case 2:
                    atm.checkBalance();
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

