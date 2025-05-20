### ATM Simulation Program Description

This Java-based **ATM Simulation Program** models a basic ATM system where a user can perform various operations like checking their balance, depositing money, and withdrawing money, all while interacting with a user-defined account number and PIN.

#### **Features**:

1. **User-Defined Account Setup**:

   * When starting the program, the user is prompted to enter their **4-digit account number**, **PIN**, and an **initial balance** for their account. These values are stored and used during the session.

2. **Login Process**:

   * The user is required to enter their **4-digit PIN** to access the ATM features. If the PIN entered is correct, the user gains access to the main menu of the ATM. The system allows up to 3 login attempts, after which the program exits if the user is unsuccessful in entering the correct PIN.

3. **Main Menu Operations**:

   * Once logged in, the user is presented with a **Main Menu** offering the following options:

     * **Check Balance**: The user can view their current balance.
     * **Deposit Money**: The user can deposit a specified amount into their account. Only positive amounts are allowed for deposit.
     * **Withdraw Money**: The user can withdraw a specified amount from their account. The system checks that the withdrawal amount is positive and that sufficient funds are available.
     * **Exit**: The user can exit the program.

4. **Input Validation**:

   * The program includes robust input validation to handle incorrect or invalid inputs. For example:

     * If the user enters a non-numeric input where a number is expected (like for the deposit or withdrawal amounts), the program catches this error and prompts the user to try again.
     * The program ensures that the deposit and withdrawal amounts are positive numbers and checks for sufficient funds when withdrawing.

5. **Feedback**:

   * After each transaction (deposit, withdrawal), the program provides feedback on the success of the operation, showing the new balance after a deposit or withdrawal. If an operation is invalid (e.g., negative withdrawal or insufficient funds), the program informs the user of the issue.

6. **Program Termination**:

   * The program automatically terminates if the user fails to log in after 3 failed attempts, providing a message about the failed login attempts and exiting.

#### **Sample Output**:

```
Welcome to the ATM Simulation
Please enter your 4-digit account number: 12345678
Please set your 4-digit PIN: 4321
Please enter your initial balance: $5000

Your account has been created successfully.

Please enter your 4-digit PIN: 4321
Login successful!

ATM Main Menu:
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
Enter your choice: 1
Your current balance is: $5000.00

Enter amount to deposit: $200
Successfully deposited $200.00. New balance: $5200.00

Enter amount to withdraw: $1000
Successfully withdrew $1000.00. Remaining balance: $4200.00

Thank you for using the ATM. Goodbye!
