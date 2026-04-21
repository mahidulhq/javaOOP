/**
 * Account class - Base class for all types of bank accounts
 * Demonstrates encapsulation with private attributes and getter/setter methods
 */
public abstract class Account {
    
    // Private attributes - Encapsulation
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private double interestRate;
    
    /**
     * Constructor for Account class
     * @param accountNumber The account number
     * @param accountHolder The name of the account holder
     * @param balance Initial balance
     * @param interestRate Interest rate for the account
     */
    public Account(String accountNumber, String accountHolder, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    
    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    // Setter methods
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }
    
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Interest rate cannot be negative!");
        }
    }
    
    /**
     * Deposit money into the account
     * @param amount Amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
    
    /**
     * Withdraw money from the account
     * @param amount Amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }
    
    /**
     * Abstract method for calculating interest - Polymorphism
     * Each subclass will implement this differently
     */
    public abstract double calculateInterest();
    
    /**
     * Display account information
     */
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}