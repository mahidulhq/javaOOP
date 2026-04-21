/**
 * FixedDepositAccount class - Extends Account class
 * Features for fixed deposit accounts with maturity period
 */
public class FixedDepositAccount extends Account {
    
    // Additional attributes specific to FixedDepositAccount
    private int maturityPeriodMonths;
    private int monthsRemaining;
    private boolean isMatured;
    
    /**
     * Constructor for FixedDepositAccount
     * @param accountNumber The account number
     * @param accountHolder The name of the account holder
     * @param balance Initial balance (deposit amount)
     * @param interestRate Interest rate for fixed deposit
     * @param maturityPeriodMonths Duration of the fixed deposit in months
     */
    public FixedDepositAccount(String accountNumber, String accountHolder, double balance, 
                              double interestRate, int maturityPeriodMonths) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.maturityPeriodMonths = maturityPeriodMonths;
        this.monthsRemaining = maturityPeriodMonths;
        this.isMatured = false;
    }
    
    // Getter and Setter for additional attributes
    public int getMaturityPeriodMonths() {
        return maturityPeriodMonths;
    }
    
    public int getMonthsRemaining() {
        return monthsRemaining;
    }
    
    public boolean isMatured() {
        return isMatured;
    }
    
    /**
     * Override withdraw method - Fixed deposits can only be withdrawn after maturity
     */
    @Override
    public void withdraw(double amount) {
        if (isMatured) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw before maturity! Months remaining: " + monthsRemaining);
        }
    }
    
    /**
     * Reduce remaining months and check for maturity
     */
    public void addMonth() {
        if (monthsRemaining > 0) {
            monthsRemaining--;
            if (monthsRemaining == 0) {
                isMatured = true;
                System.out.println("Fixed Deposit has matured! You can now withdraw your amount.");
            }
        }
    }
    
    /**
     * Polymorphic method - Calculate interest for Fixed Deposit Account
     * Fixed deposits earn compound interest
     */
    @Override
    public double calculateInterest() {
        // Fixed deposits earn compound interest monthly
        double monthlyRate = getInterestRate() / 12 / 100;
        double interest = getBalance() * monthlyRate;
        setBalance(getBalance() + interest);
        return interest;
    }
    
    /**
     * Method to calculate maturity amount (Principal + Total Interest)
     */
    public double getMaturityAmount() {
        // Calculate what the balance will be at maturity
        double tempBalance = getBalance();
        int remainingMonths = monthsRemaining;
        
        while (remainingMonths > 0) {
            double monthlyRate = getInterestRate() / 12 / 100;
            tempBalance += (tempBalance * monthlyRate);
            remainingMonths--;
        }
        
        return tempBalance;
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== FIXED DEPOSIT ACCOUNT ===");
        super.displayAccountInfo();
        System.out.println("Maturity Period: " + maturityPeriodMonths + " months");
        System.out.println("Months Remaining: " + monthsRemaining);
        System.out.println("Matured: " + isMatured);
        System.out.println("Expected Maturity Amount: $" + String.format("%.2f", getMaturityAmount()));
    }
}