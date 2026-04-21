/**
 * SavingsAccount class - Extends Account class
 * Specific features for savings accounts with withdrawal limits
 */
public class SavingsAccount extends Account {
    
    // Additional attribute specific to SavingsAccount
    private int maxWithdrawalsPerMonth;
    private int withdrawalsThisMonth;
    
    /**
     * Constructor for SavingsAccount
     * @param accountNumber The account number
     * @param accountHolder The name of the account holder
     * @param balance Initial balance
     * @param interestRate Interest rate for savings account
     * @param maxWithdrawalsPerMonth Maximum withdrawals allowed per month
     */
    public SavingsAccount(String accountNumber, String accountHolder, double balance, 
                         double interestRate, int maxWithdrawalsPerMonth) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.maxWithdrawalsPerMonth = maxWithdrawalsPerMonth;
        this.withdrawalsThisMonth = 0;
    }
    
    // Getter and Setter for additional attributes
    public int getMaxWithdrawalsPerMonth() {
        return maxWithdrawalsPerMonth;
    }
    
    public void setMaxWithdrawalsPerMonth(int maxWithdrawalsPerMonth) {
        this.maxWithdrawalsPerMonth = maxWithdrawalsPerMonth;
    }
    
    public int getWithdrawalsThisMonth() {
        return withdrawalsThisMonth;
    }
    
    /**
     * Override withdraw method to enforce withdrawal limits
     */
    @Override
    public void withdraw(double amount) {
        if (withdrawalsThisMonth < maxWithdrawalsPerMonth) {
            super.withdraw(amount);
            withdrawalsThisMonth++;
        } else {
            System.out.println("Monthly withdrawal limit reached!");
        }
    }
    
    /**
     * Polymorphic method - Calculate interest for Savings Account
     * Savings account earns simple interest
     */
    @Override
    public double calculateInterest() {
        double interest = getBalance() * (getInterestRate() / 100);
        setBalance(getBalance() + interest);
        return interest;
    }
    
    /**
     * Reset withdrawal count at month end
     */
    public void resetMonthlyWithdrawals() {
        withdrawalsThisMonth = 0;
        System.out.println("Monthly withdrawal counter reset.");
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== SAVINGS ACCOUNT ===");
        super.displayAccountInfo();
        System.out.println("Max Withdrawals Per Month: " + maxWithdrawalsPerMonth);
        System.out.println("Withdrawals This Month: " + withdrawalsThisMonth);
    }
}