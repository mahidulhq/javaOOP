# Simple Banking System

A comprehensive Java-based Object-Oriented Programming (OOP) project demonstrating encapsulation, inheritance, and polymorphism through a functional banking system with multiple account types.

## Overview

The Simple Banking System is an educational project that implements a complete banking system with three distinct account types: Savings Account, Checking Account, and Fixed Deposit Account. Each account type exhibits unique behaviors and interest calculation methods, effectively demonstrating core OOP principles including encapsulation, inheritance, and polymorphism.

## Features

- **Multiple Account Types**: Support for Savings, Checking, and Fixed Deposit accounts
- **Encapsulation**: Private attributes with controlled access through getter/setter methods
- **Inheritance**: Abstract base class with concrete implementations
- **Polymorphism**: Overridden methods for specialized account behaviors
- **Interest Calculation**: Account-specific interest calculation algorithms
- **Transaction Management**: Deposit and withdrawal operations with validation
- **Data Validation**: Comprehensive input validation and error handling
- **Account-Specific Features**: 
  - Savings: Monthly withdrawal limits
  - Checking: Overdraft protection
  - Fixed Deposit: Maturity period tracking with compound interest

## System Requirements

- Java Development Kit (JDK) 8 or higher
- Operating System: Windows, macOS, or Linux
- Minimum 50MB free disk space
- Terminal or command prompt access

## Project Structure

```
BankingSystem/
├── Account.java                 # Abstract base class
├── SavingsAccount.java          # Savings account implementation
├── CheckingAccount.java         # Checking account implementation
├── FixedDepositAccount.java     # Fixed deposit implementation
├── BankingSystem.java           # Test and demonstration class
└── README.md                    # This file
```

### File Descriptions

#### Account.java
Abstract base class that defines the common interface for all account types. Contains shared attributes (accountNumber, accountHolder, balance, interestRate) and common methods (deposit, withdraw, displayAccountInfo). Implements encapsulation through private attributes with public accessors.

**Key Components:**
- Private attributes with validation in setters
- Abstract method `calculateInterest()` for polymorphic behavior
- Common transaction methods (deposit/withdraw)
- Account information display method

#### SavingsAccount.java
Concrete implementation of a Savings Account designed for long-term savings with withdrawal restrictions. Introduces the concept of monthly withdrawal limits through additional attributes and overridden methods.

**Unique Features:**
- Monthly withdrawal limit enforcement
- Monthly withdrawal counter
- Simple interest calculation
- Monthly counter reset functionality

#### CheckingAccount.java
Concrete implementation of a Checking Account designed for frequent transactions. Features overdraft protection allowing account balance to go negative up to a specified limit.

**Unique Features:**
- Overdraft protection with configurable limit
- Allows negative balance within overdraft limit
- Minimal interest calculation (0.1% of standard rate)
- Available balance calculation including overdraft

#### FixedDepositAccount.java
Concrete implementation of a Fixed Deposit Account designed for fixed-term investments. Prevents withdrawal until maturity while calculating compound interest monthly.

**Unique Features:**
- Maturity period tracking in months
- Withdrawal restriction until maturity
- Compound interest calculation
- Maturity amount projection
- Month simulation for maturity tracking

#### BankingSystem.java
Comprehensive test and demonstration class showcasing all features of the banking system. Creates instances of each account type and demonstrates all operations and methods.

## Installation & Setup

### Step 1: Create Project Directory

```bash
mkdir BankingSystem
cd BankingSystem
```

### Step 2: Create Java Files

Create five new Java files in the BankingSystem directory:
- Account.java
- SavingsAccount.java
- CheckingAccount.java
- FixedDepositAccount.java
- BankingSystem.java

### Step 3: Add Code

Copy the provided Java code into each respective file, ensuring the class name matches the filename.

### Step 4: Verify Setup

```bash
ls -la          # macOS/Linux
dir             # Windows
```

You should see all five .java files listed.

## Building & Running

### Compilation

Compile all Java files in the project:

```bash
javac *.java
```

**Expected Output:** No output indicates successful compilation. Check for .class files:

```bash
ls *.class      # macOS/Linux
dir *.class     # Windows
```

### Execution

Run the demonstration program:

```bash
java BankingSystem
```

The program will execute and display comprehensive output demonstrating all features.

### Clean Build

Remove all compiled class files:

```bash
# macOS/Linux
rm *.class

# Windows
del *.class
```

## Account Types & Usage

### 1. Savings Account

Designed for long-term savings with restricted withdrawal frequency.

#### Constructor

```java
SavingsAccount(String accountNumber, String accountHolder, double balance, 
               double interestRate, int maxWithdrawalsPerMonth)
```

#### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| accountNumber | String | Unique account identifier |
| accountHolder | String | Name of account owner |
| balance | double | Initial account balance |
| interestRate | double | Annual interest rate (%) |
| maxWithdrawalsPerMonth | int | Maximum withdrawals allowed per month |

#### Example Usage

```java
// Create a savings account
SavingsAccount savings = new SavingsAccount("SAV001", "John Doe", 5000, 4.5, 3);

// Display account information
savings.displayAccountInfo();

// Perform transactions
savings.deposit(1000);          // Add $1000
savings.withdraw(500);          // Remove $500 (1st withdrawal)
savings.withdraw(300);          // Remove $300 (2nd withdrawal)
savings.withdraw(200);          // Remove $200 (3rd withdrawal)
savings.withdraw(100);          // FAILS - exceeds monthly limit

// Calculate interest
double interest = savings.calculateInterest();
System.out.println("Interest: $" + String.format("%.2f", interest));

// Reset monthly counter
savings.resetMonthlyWithdrawals();
```

#### Output

```
Deposited: $1000.0 | New Balance: $6000.0
Withdrawn: $500.0 | New Balance: $5500.0
Withdrawn: $300.0 | New Balance: $5200.0
Withdrawn: $200.0 | New Balance: $5000.0
Monthly withdrawal limit reached!
Interest: $225.00
Monthly withdrawal counter reset.

=== SAVINGS ACCOUNT ===
Account Number: SAV001
Account Holder: John Doe
Balance: $5225.0
Interest Rate: 4.5%
Max Withdrawals Per Month: 3
Withdrawals This Month: 0
```

#### Interest Calculation Formula

```
Interest = Balance × (InterestRate / 100)
New Balance = Balance + Interest
```

#### Available Methods

```java
deposit(double amount)                          // Add funds
withdraw(double amount)                         // Remove funds (with limit check)
calculateInterest()                             // Returns simple interest
resetMonthlyWithdrawals()                       // Reset monthly counter
getMaxWithdrawalsPerMonth()                     // Get withdrawal limit
getWithdrawalsThisMonth()                       // Get current month count
displayAccountInfo()                            // Display all details
```

---

### 2. Checking Account

Designed for frequent transactions with overdraft protection capability.

#### Constructor

```java
CheckingAccount(String accountNumber, String accountHolder, double balance, 
                double interestRate, double overdraftLimit)
```

#### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| accountNumber | String | Unique account identifier |
| accountHolder | String | Name of account owner |
| balance | double | Initial account balance |
| interestRate | double | Annual interest rate (%) |
| overdraftLimit | double | Maximum overdraft amount ($) |

#### Example Usage

```java
// Create a checking account
CheckingAccount checking = new CheckingAccount("CHK001", "Jane Smith", 3000, 2.0, 500);

// Display account information
checking.displayAccountInfo();

// Perform transactions
checking.deposit(1500);         // Add $1500 (Balance: $4500)
checking.withdraw(2000);        // Remove $2000 (Balance: $2500)
checking.withdraw(2000);        // Remove $2000 (Balance: $500, in overdraft)
checking.withdraw(600);         // FAILS - exceeds overdraft limit

// Get available balance
double available = checking.getAvailableBalance();
System.out.println("Available Balance: $" + available);

// Calculate interest
double interest = checking.calculateInterest();
System.out.println("Interest: $" + String.format("%.2f", interest));
```

#### Output

```
Deposited: $1500.0 | New Balance: $4500.0
Withdrawn: $2000.0
New Balance: $2500.0
Withdrawn: $2000.0
WARNING: Account is in overdraft! Current Balance: $500.0
Withdrawal exceeds overdraft limit!
Available Balance: $1000.0
Interest: $0.10

=== CHECKING ACCOUNT ===
Account Number: CHK001
Account Holder: Jane Smith
Balance: $500.0
Interest Rate: 2.0%
Overdraft Limit: $500.0
Available Balance: $1000.0
```

#### Interest Calculation Formula

```
Interest = Balance × (InterestRate / 100) × 0.1
New Balance = Balance + Interest
```

Note: Checking accounts earn only 10% of the standard interest rate.

#### Available Methods

```java
deposit(double amount)                          // Add funds
withdraw(double amount)                         // Remove funds (with overdraft check)
calculateInterest()                             // Returns minimal interest
getAvailableBalance()                           // Returns balance + overdraft limit
getOverdraftLimit()                             // Get overdraft limit
setOverdraftLimit(double overdraftLimit)        // Set overdraft limit
displayAccountInfo()                            // Display all details
```

---

### 3. Fixed Deposit Account

Designed for fixed-term investments with maturity period and compound interest.

#### Constructor

```java
FixedDepositAccount(String accountNumber, String accountHolder, double balance, 
                    double interestRate, int maturityPeriodMonths)
```

#### Parameters

| Parameter | Type | Description |
|-----------|------|-------------|
| accountNumber | String | Unique account identifier |
| accountHolder | String | Name of account owner |
| balance | double | Deposit amount |
| interestRate | double | Annual interest rate (%) |
| maturityPeriodMonths | int | Duration until maturity (months) |

#### Example Usage

```java
// Create a fixed deposit for 12 months
FixedDepositAccount fd = new FixedDepositAccount("FD001", "Michael Johnson", 10000, 6.0, 12);

// Display account information
fd.displayAccountInfo();

// Try to withdraw before maturity (will fail)
fd.withdraw(1000);              // FAILS - not matured yet

// Simulate 12 months passing
for (int i = 1; i <= 12; i++) {
    fd.addMonth();
    fd.calculateInterest();
    
    if (i % 3 == 0) {
        System.out.println("Month " + i + " - Balance: $" + 
                         String.format("%.2f", fd.getBalance()));
    }
}

// Display final information
fd.displayAccountInfo();

// Withdraw after maturity (will succeed)
fd.withdraw(15000);
```

#### Output

```
Cannot withdraw before maturity! Months remaining: 12

=== FIXED DEPOSIT ACCOUNT ===
Account Number: FD001
Account Holder: Michael Johnson
Balance: $10000.0
Interest Rate: 6.0%
Maturity Period: 12 months
Months Remaining: 12
Matured: false
Expected Maturity Amount: $10630.49

Month 3 - Balance: $10151.50
Month 6 - Balance: $10307.03
Month 9 - Balance: $10466.68
Month 12 - Balance: $10630.49
Fixed Deposit has matured! You can now withdraw your amount.

=== FIXED DEPOSIT ACCOUNT ===
Account Number: FD001
Account Holder: Michael Johnson
Balance: $10630.49
Interest Rate: 6.0%
Maturity Period: 12 months
Months Remaining: 0
Matured: true
Expected Maturity Amount: $10630.49

Withdrawn: $15000.0 | New Balance: $-4369.51
```

#### Interest Calculation Formula

```
Monthly Rate = AnnualRate / 12 / 100
Monthly Interest = Balance × Monthly Rate
New Balance = Balance + Monthly Interest
```

Example: For $10,000 at 6% annual rate:
- Monthly rate = 6 / 12 / 100 = 0.005 (0.5%)
- Month 1 interest = 10,000 × 0.005 = $50
- Month 2 balance = 10,050 × 0.005 = $50.25

#### Available Methods

```java
withdraw(double amount)                         // Only works after maturity
calculateInterest()                             // Returns compound interest
addMonth()                                      // Simulate one month passing
getMaturityAmount()                             // Calculate expected maturity value
getMaturityPeriodMonths()                       // Get total maturity period
getMonthsRemaining()                            // Get remaining months
isMatured()                                     // Check if deposit matured
displayAccountInfo()                            // Display all details
```

---

## OOP Concepts Demonstrated

### Encapsulation

Encapsulation protects data integrity through access control. All attributes are declared private with controlled public access:

```java
// Private attributes
private String accountNumber;
private String accountHolder;
private double balance;
private double interestRate;

// Public getters provide read access
public double getBalance() {
    return balance;
}

// Public setters provide controlled write access
public void setBalance(double balance) {
    if (balance >= 0) {
        this.balance = balance;
    } else {
        System.out.println("Balance cannot be negative!");
    }
}
```

**Benefits:**
- Data validation at assignment time
- Prevents invalid states (negative balance)
- Internal implementation can change without affecting external code
- Protects sensitive banking data

### Inheritance

Inheritance establishes a hierarchy where subclasses inherit common functionality from a parent class:

```java
// Abstract base class
public abstract class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected double interestRate;
    
    public void deposit(double amount) { ... }
    public void withdraw(double amount) { ... }
    public abstract double calculateInterest();
}

// Concrete subclasses
public class SavingsAccount extends Account { ... }
public class CheckingAccount extends Account { ... }
public class FixedDepositAccount extends Account { ... }
```

**Benefits:**
- Code reuse through inheritance of common methods
- Consistent interface across all account types
- Specialized behavior in subclasses
- Hierarchy represents real-world relationships

### Polymorphism

Polymorphism allows the same method call to produce different results based on the object type:

```java
// Base class abstract method
public abstract class Account {
    public abstract double calculateInterest();
}

// Subclass implementations
public class SavingsAccount extends Account {
    @Override
    public double calculateInterest() {
        // Simple interest: Balance × Rate
        double interest = getBalance() * (getInterestRate() / 100);
        setBalance(getBalance() + interest);
        return interest;
    }
}

public class CheckingAccount extends Account {
    @Override
    public double calculateInterest() {
        // Minimal interest: Balance × Rate × 0.1
        double interest = getBalance() * (getInterestRate() / 100) * 0.1;
        setBalance(getBalance() + interest);
        return interest;
    }
}

public class FixedDepositAccount extends Account {
    @Override
    public double calculateInterest() {
        // Compound interest: Balance × (Rate/12)
        double monthlyRate = getInterestRate() / 12 / 100;
        double interest = getBalance() * monthlyRate;
        setBalance(getBalance() + interest);
        return interest;
    }
}

// Usage - same method, different behavior
Account acc1 = new SavingsAccount("SAV001", "John", 1000, 6.0, 3);
Account acc2 = new CheckingAccount("CHK001", "Jane", 1000, 6.0, 500);
Account acc3 = new FixedDepositAccount("FD001", "Mike", 1000, 6.0, 12);

acc1.calculateInterest();   // Returns $60 (simple)
acc2.calculateInterest();   // Returns $0.60 (minimal)
acc3.calculateInterest();   // Returns $5 (compound)
```

**Benefits:**
- Single interface for multiple implementations
- Easy to add new account types
- Code remains flexible and maintainable
- Supports real-world object behavior

---

## API Reference

### Account Class (Abstract Base Class)

#### Attributes (Private)
```java
private String accountNumber;      // Unique account identifier
private String accountHolder;      // Account owner name
private double balance;            // Current account balance
private double interestRate;       // Annual interest rate (%)
```

#### Constructors
```java
Account(String accountNumber, String accountHolder, double balance, double interestRate)
```

#### Getter Methods
```java
String getAccountNumber()           // Returns account number
String getAccountHolder()           // Returns account holder name
double getBalance()                 // Returns current balance
double getInterestRate()            // Returns interest rate
```

#### Setter Methods
```java
void setAccountNumber(String accountNumber)     // Set account number
void setAccountHolder(String accountHolder)     // Set account holder name
void setBalance(double balance)                 // Set balance (validated)
void setInterestRate(double interestRate)       // Set interest rate (validated)
```

#### Transaction Methods
```java
void deposit(double amount)         // Add funds to account
void withdraw(double amount)        // Remove funds from account
```

#### Display Method
```java
void displayAccountInfo()           // Print account details
```

#### Abstract Method
```java
abstract double calculateInterest() // Calculate interest (implemented in subclasses)
```

---

### SavingsAccount Class

#### Additional Attributes
```java
private int maxWithdrawalsPerMonth;  // Monthly withdrawal limit
private int withdrawalsThisMonth;    // Current month withdrawal count
```

#### Overridden Methods
```java
void withdraw(double amount)        // Enforces monthly withdrawal limit
double calculateInterest()          // Returns simple interest
void displayAccountInfo()           // Displays savings account details
```

#### Specific Methods
```java
int getMaxWithdrawalsPerMonth()                 // Get withdrawal limit
void setMaxWithdrawalsPerMonth(int max)         // Set withdrawal limit
int getWithdrawalsThisMonth()                   // Get current month count
void resetMonthlyWithdrawals()                  // Reset monthly counter
```

---

### CheckingAccount Class

#### Additional Attributes
```java
private double overdraftLimit;      // Maximum overdraft amount
```

#### Overridden Methods
```java
void withdraw(double amount)        // Allows overdraft up to limit
double calculateInterest()          // Returns minimal interest (10% of rate)
void displayAccountInfo()           // Displays checking account details
```

#### Specific Methods
```java
double getOverdraftLimit()                      // Get overdraft limit
void setOverdraftLimit(double limit)            // Set overdraft limit
double getAvailableBalance()                    // Get balance + overdraft limit
```

---

### FixedDepositAccount Class

#### Additional Attributes
```java
private int maturityPeriodMonths;   // Total months until maturity
private int monthsRemaining;        // Remaining months until maturity
private boolean isMatured;          // Maturity status flag
```

#### Overridden Methods
```java
void withdraw(double amount)        // Only works after maturity
double calculateInterest()          // Returns compound interest
void displayAccountInfo()           // Displays fixed deposit details
```

#### Specific Methods
```java
int getMaturityPeriodMonths()                   // Get total maturity period
int getMonthsRemaining()                        // Get remaining months
boolean isMatured()                             // Check if matured
void addMonth()                                 // Simulate one month passing
double getMaturityAmount()                      // Calculate maturity value
```

---

## Complete Usage Examples

### Example 1: Basic Savings Account Operations

```java
// Create account
SavingsAccount account = new SavingsAccount("SAV001", "John Doe", 1000, 4.5, 3);

// Show initial state
System.out.println("Initial Balance: $" + account.getBalance());

// Deposit money
account.deposit(500);
System.out.println("After deposit: $" + account.getBalance());

// Withdraw money
account.withdraw(200);
System.out.println("After withdrawal: $" + account.getBalance());

// Calculate interest
double interest = account.calculateInterest();
System.out.println("Interest earned: $" + String.format("%.2f", interest));
```

**Output:**
```
Initial Balance: $1000.0
Deposited: $500.0 | New Balance: $1500.0
After deposit: $1500.0
Withdrawn: $200.0 | New Balance: $1300.0
After withdrawal: $1300.0
Interest earned: $58.50
```

---

### Example 2: Checking Account with Overdraft

```java
// Create account with $500 overdraft
CheckingAccount account = new CheckingAccount("CHK001", "Jane Smith", 1000, 2.0, 500);

// Display details
account.displayAccountInfo();

// Deposit additional funds
account.deposit(500);
System.out.println("\nAfter deposit - Balance: $" + account.getBalance());

// Withdraw normal amount
account.withdraw(1000);
System.out.println("After withdrawal - Balance: $" + account.getBalance());

// Withdraw with overdraft (within limit)
account.withdraw(400);
System.out.println("After overdraft withdrawal - Balance: $" + account.getBalance());

// Try to exceed overdraft limit
account.withdraw(300);  // This will fail
```

**Output:**
```
=== CHECKING ACCOUNT ===
Account Number: CHK001
Account Holder: Jane Smith
Balance: $1000.0
Interest Rate: 2.0%
Overdraft Limit: $500.0
Available Balance: $1500.0

Deposited: $500.0 | New Balance: $1500.0

After deposit - Balance: $1500.0
Withdrawn: $1000.0
New Balance: $500.0
After withdrawal - Balance: $500.0
Withdrawn: $400.0
WARNING: Account is in overdraft! Current Balance: $100.0
After overdraft withdrawal - Balance: $100.0
Withdrawal exceeds overdraft limit!
```

---

### Example 3: Fixed Deposit Maturity Simulation

```java
// Create 6-month fixed deposit
FixedDepositAccount fd = new FixedDepositAccount("FD001", "Mike", 5000, 12.0, 6);

System.out.println("Initial Amount: $" + fd.getBalance());
System.out.println("Maturity Period: " + fd.getMaturityPeriodMonths() + " months");
System.out.println("Expected Maturity Amount: $" + 
                   String.format("%.2f", fd.getMaturityAmount()));

// Simulate 6 months
for (int i = 1; i <= 6; i++) {
    fd.addMonth();
    double interest = fd.calculateInterest();
    System.out.println("Month " + i + " - Interest: $" + 
                       String.format("%.2f", interest) + 
                       " | Balance: $" + 
                       String.format("%.2f", fd.getBalance()));
}

// Now can withdraw
System.out.println("\nAccount is matured: " + fd.isMatured());
fd.withdraw(5300);
System.out.println("Final Balance: $" + String.format("%.2f", fd.getBalance()));
```

**Output:**
```
Initial Amount: $5000.0
Maturity Period: 6 months
Expected Maturity Amount: $5308.39

Month 1 - Interest: $50.00 | Balance: $5050.00
Month 2 - Interest: $50.50 | Balance: $5100.50
Month 3 - Interest: $51.01 | Balance: $5151.51
Month 4 - Interest: $51.52 | Balance: $5203.02
Month 5 - Interest: $52.03 | Balance: $5255.05
Month 6 - Interest: $52.55 | Balance: $5307.60
Fixed Deposit has matured! You can now withdraw your amount.

Account is matured: true
Withdrawn: $5300.0 | New Balance: $7.60
Final Balance: $7.60
```

---

### Example 4: Polymorphic Interest Calculation

```java
// Create three different account types with same parameters
Account savings = new SavingsAccount("SAV", "John", 10000, 12.0, 3);
Account checking = new CheckingAccount("CHK", "Jane", 10000, 12.0, 500);
Account fd = new FixedDepositAccount("FD", "Mike", 10000, 12.0, 1);

System.out.println("Initial Balance: $10000.00");
System.out.println("\nInterest Calculation (Interest Rate: 12%):");
System.out.println("=============================================");

double savingsInterest = savings.calculateInterest();
System.out.println("\nSavings Account:");
System.out.println("  Interest: $" + String.format("%.2f", savingsInterest));
System.out.println("  New Balance: $" + String.format("%.2f", savings.getBalance()));

double checkingInterest = checking.calculateInterest();
System.out.println("\nChecking Account:");
System.out.println("  Interest: $" + String.format("%.2f", checkingInterest));
System.out.println("  New Balance: $" + String.format("%.2f", checking.getBalance()));

double fdInterest = fd.calculateInterest();
System.out.println("\nFixed Deposit Account:");
System.out.println("  Interest: $" + String.format("%.2f", fdInterest));
System.out.println("  New Balance: $" + String.format("%.2f", fd.getBalance()));
```

**Output:**
```
Initial Balance: $10000.00

Interest Calculation (Interest Rate: 12%)
=============================================

Savings Account:
  Interest: $1200.00
  New Balance: $11200.00

Checking Account:
  Interest: $12.00
  New Balance: $10012.00

Fixed Deposit Account:
  Interest: $100.00
  New Balance: $10100.00
```


## Quick Reference

### Common Commands

```bash
# Compile all Java files
javac *.java

# Compile specific file
javac Account.java

# Run main program
java BankingSystem

# List class files
ls *.class              # macOS/Linux
dir *.class             # Windows

# Remove class files
rm *.class              # macOS/Linux
del *.class             # Windows

# Check Java version
java -version
javac -version

# View file contents
cat FileName.java       # macOS/Linux
type FileName.java      # Windows
```

### Account Creation Templates

**Savings Account:**
```java
SavingsAccount acc = new SavingsAccount("ACC_NUM", "Name", 5000, 4.5, 3);
```

**Checking Account:**
```java
CheckingAccount acc = new CheckingAccount("ACC_NUM", "Name", 3000, 2.0, 500);
```

**Fixed Deposit Account:**
```java
FixedDepositAccount acc = new FixedDepositAccount("ACC_NUM", "Name", 10000, 6.0, 12);
```

### Common Operations

```java
// Deposit
account.deposit(1000);

// Withdraw
account.withdraw(500);

// Get balance
double balance = account.getBalance();

// Calculate interest
double interest = account.calculateInterest();

// Display info
account.displayAccountInfo();

// For Savings Account
account.resetMonthlyWithdrawals();

// For Checking Account
double available = account.getAvailableBalance();

// For Fixed Deposit
account.addMonth();
double maturity = account.getMaturityAmount();
```

---

## Learning Outcomes

Upon completing this project, you will understand:

✅ Abstract class design and implementation  
✅ Inheritance hierarchy and method overriding  
✅ Polymorphic behavior through method overriding  
✅ Encapsulation and data protection  
✅ Access modifiers (private, public, protected)  
✅ Object-oriented design principles  
✅ Real-world application modeling  
✅ Input validation and error handling  
✅ Method overloading concepts  
✅ Testing and demonstration techniques  

---

## Next Steps

1. **Extend the System**: Add more account types (e.g., Student Account, Senior Account)
2. **Add Persistence**: Save account data to files using serialization
3. **Create GUI**: Build a graphical interface using Swing or JavaFX
4. **Add Transactions**: Track transaction history for each account
5. **Implement Security**: Add authentication and encryption
6. **Add Reporting**: Generate account statements and reports
7. **Multi-Currency Support**: Handle multiple currencies
8. **Interest Calculations**: Implement different tax scenarios

---

## References

- Java Programming Language: https://docs.oracle.com/javase/
- Object-Oriented Programming Concepts: https://docs.oracle.com/javase/tutorial/java/concepts/
- Java Coding Standards: https://www.oracle.com/java/technologies/javase/codeconventions-136091.html

---

## Version History

| Version | Date | Changes |
|---------|------|---------|
| 1.0 | 2026-04-21 | Initial release with 3 account types |

---

## Author

- **Name**: Mahidul
- **Username**: mahidulhq
- **Contact**: Available via GitHub profile

---

## License

This project is provided for educational purposes. Feel free to use, modify, and distribute for learning and non-commercial purposes.

---

## Disclaimer

This is an educational project and should not be used for actual banking transactions. It is designed to demonstrate OOP principles in Java. Always use official banking systems for real financial transactions.

---