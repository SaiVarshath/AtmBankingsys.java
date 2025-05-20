import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    private static String userAccountNumber; // User-defined account number
    private static String userPIN; // User-defined PIN
    private static double balance; // User-defined balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the ATM Simulation");

        // User setup
        System.out.print("Please enter your last 4-digits of account number: ");
        userAccountNumber = scanner.nextLine();

        System.out.print("Please set your 4-digit PIN: ");
        userPIN = scanner.nextLine();

        System.out.print("Please enter your initial balance:⟨₹⟩");
        balance = scanner.nextDouble();
        scanner.nextLine(); // To consume the newline character left by nextDouble()

        System.out.println("Your account has been created successfully.\n");

        // Login process
        boolean loggedIn = false;
        int loginAttempts = 0;
        while (!loggedIn && loginAttempts < 3) {
            System.out.print("Please enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine();

            if (enteredPin.equals(userPIN)) {
                loggedIn = true;
                System.out.println("Login successful!\n");
            } else {
                loginAttempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - loginAttempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Exiting...");
            scanner.close();
            return;
        }

        // Main menu operations
        int choice = 0;
        do {
            System.out.println("ATM Main Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Display current balance
                        System.out.printf("Your current balance is: ⟨₹⟩%.2f%n%n", balance);
                        break;

                    case 2:
                        // Deposit money
                        System.out.print("Enter amount to deposit: ⟨₹⟩");
                        double depositAmount = scanner.nextDouble();
                        if (depositAmount <= 0) {
                            System.out.println("Deposit amount must be positive.\n");
                        } else {
                            balance += depositAmount;
                            System.out.printf("Successfully deposited ⟨₹⟩%.2f. New balance:  ⟨₹⟩%.2f%n%n", depositAmount, balance);
                        }
                        break;

                    case 3:
                        // Withdraw money
                        System.out.print("Enter amount to withdraw: ⟨₹⟩");
                        double withdrawAmount = scanner.nextDouble();
                        if (withdrawAmount <= 0) {
                            System.out.println("Withdrawal amount must be positive.\n");
                        } else if (withdrawAmount > balance) {
                            System.out.println("Insufficient funds for this withdrawal.\n");
                        } else {
                            balance -= withdrawAmount;
                            System.out.printf("Successfully withdrew ⟨₹⟩%.2f. Remaining balance: $%.2f%n%n", withdrawAmount, balance);
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear invalid input
            }
        } while (choice != 4);

        scanner.close();
    }
}
