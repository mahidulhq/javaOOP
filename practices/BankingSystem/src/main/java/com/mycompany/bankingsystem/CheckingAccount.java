/**
 * CheckingAccount class - Extends Account class
 * Features for checking accounts with overdraft protection
 */
public class CheckingAccount extends Account {
    
    // Additional attribute specific to CheckingAccount
    private double overdraftLimit;
    
    /**
     * Constructor for CheckingAccount
     * @param accountNumber The account number
     * @param accountHolder The name of the account holder
     * @param balance Initial balance
     * @param interestRate Interest rate for checking account
     * @param overdraftLimit Maximum overdraft allowed
     */
    public CheckingAccount(String accountNumber, String accountHolder, double balance, 
                          double interestRate, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, interestRate);
        this.overdraftLimit = overdraftLimit;
    }
    
    // Getter and Setter for additional attributes
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    
    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit >= 0) {
            this.overdraftLimit = overdraftLimit;
        } else {
            System.out.println("Overdraft limit cannot be negative!");
        }
    }
    
    /**
     * Override withdraw method to allow overdraft
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: $" + amount);
            if (getBalance() < 0) {
                System.out.println("WARNING: Account is in overdraft! Current Balance: $" + getBalance());
            } else {
                System.out.println("New Balance: $" + getBalance());
            }
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }
    
    /**
     * Polymorphic method - Calculate interest for Checking Account
     * Checking accounts earn minimal interest or no interest
     */
    @Override
    public double calculateInterest() {
        // Checking account earns very low interest (0.1% of balance)
        double interest = getBalance() * (getInterestRate() / 100) * 0.1;
        setBalance(getBalance() + interest);
        return interest;
    }
    
    /**
     * Method to get current available balance including overdraft
     */
    public double getAvailableBalance() {
        return getBalance() + overdraftLimit;
    }
    
    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== CHECKING ACCOUNT ===");
        super.displayAccountInfo();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
        System.out.println("Available Balance: $" + getAvailableBalance());
    }
}