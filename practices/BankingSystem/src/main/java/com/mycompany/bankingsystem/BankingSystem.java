/**
 * BankingSystem class - Test class to demonstrate the functionality
 * This class demonstrates encapsulation, inheritance, and polymorphism
 */
public class BankingSystem {
    
    public static void main(String[] args) {
        System.out.println("========== SIMPLE BANKING SYSTEM ==========\n");
        
        // Create instances of different account types
        SavingsAccount savingsAccount = new SavingsAccount(
            "SAV001", 
            "John Doe", 
            5000, 
            4.5, 
            3
        );
        
        CheckingAccount checkingAccount = new CheckingAccount(
            "CHK001", 
            "Jane Smith", 
            3000, 
            2.0, 
            500
        );
        
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount(
            "FD001", 
            "Michael Johnson", 
            10000, 
            6.0, 
            12
        );
        
        // Display initial account information
        System.out.println("--- INITIAL ACCOUNT INFORMATION ---");
        savingsAccount.displayAccountInfo();
        checkingAccount.displayAccountInfo();
        fixedDepositAccount.displayAccountInfo();
        
        // Demonstrate deposit and withdrawal operations
        System.out.println("\n--- DEPOSIT AND WITHDRAWAL OPERATIONS ---");
        
        System.out.println("\nSavings Account Operations:");
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(500);
        savingsAccount.withdraw(300);
        savingsAccount.withdraw(200);
        savingsAccount.withdraw(100); // This will fail - exceeds monthly limit
        
        System.out.println("\nChecking Account Operations:");
        checkingAccount.deposit(1500);
        checkingAccount.withdraw(2000);
        checkingAccount.withdraw(1500); // This will trigger overdraft
        
        System.out.println("\nFixed Deposit Account Operations:");
        fixedDepositAccount.deposit(5000); // This will be rejected or handled
        fixedDepositAccount.withdraw(1000); // This will fail - not matured yet
        
        // Demonstrate Polymorphism - Calculate Interest
        System.out.println("\n--- POLYMORPHISM DEMONSTRATION: CALCULATE INTEREST ---");
        
        System.out.println("\nCalculating interest for Savings Account (Simple Interest):");
        double savingsInterest = savingsAccount.calculateInterest();
        System.out.println("Interest Earned: $" + String.format("%.2f", savingsInterest));
        
        System.out.println("\nCalculating interest for Checking Account (Minimal Interest):");
        double checkingInterest = checkingAccount.calculateInterest();
        System.out.println("Interest Earned: $" + String.format("%.2f", checkingInterest));
        
        System.out.println("\nCalculating interest for Fixed Deposit Account (Compound Interest):");
        double fixedInterest = fixedDepositAccount.calculateInterest();
        System.out.println("Interest Earned: $" + String.format("%.2f", fixedInterest));
        
        // Simulate passage of time for Fixed Deposit
        System.out.println("\n--- SIMULATING FIXED DEPOSIT MATURITY ---");
        for (int i = 0; i < 12; i++) {
            fixedDepositAccount.addMonth();
            if (i % 3 == 0) {
                fixedDepositAccount.calculateInterest();
                System.out.println("Month " + (i + 1) + " - Balance: $" + 
                                 String.format("%.2f", fixedDepositAccount.getBalance()));
            }
        }
        
        // Try to withdraw from fixed deposit after maturity
        System.out.println("\nAttempting withdrawal after maturity:");
        fixedDepositAccount.withdraw(15000);
        
        // Display final account information
        System.out.println("\n--- FINAL ACCOUNT INFORMATION ---");
        savingsAccount.displayAccountInfo();
        checkingAccount.displayAccountInfo();
        fixedDepositAccount.displayAccountInfo();
        
        // Reset monthly withdrawals for savings account
        System.out.println("\n--- RESETTING MONTHLY WITHDRAWALS ---");
        savingsAccount.resetMonthlyWithdrawals();
        savingsAccount.displayAccountInfo();
        
        System.out.println("\n========== END OF BANKING SYSTEM DEMO ==========");
    }
}