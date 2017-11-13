package Jinhua_Yan_a1.model;

/**
 * The Account class keeps track of customer information like their name and
 * bank balance, and can perform transactions like depositing or withdrawing
 * money from the account.
 *
 * @author Jessica
 */
public class Account {

    private String customerName;
    private int id;
    private double balance;
    private double annualInterestRate;

    /**
     * Class constructor specifying name and id of the customer.
     *
     * @param customerName this is the name of the customer.
     * @param id this is the bank account id of customer.
     */
    public Account(String customerName, int id) {
        this.customerName = customerName;
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Gets amount the customer deposit. The deposit amounts cannot be negative.
     *
     * @param amount is money the customer deposit.
     */
    public void deposit(double amount) throws IllegalArgumentException{

        if (amount < 0) {
            throw new IllegalArgumentException("\n*******Deposit amounts must be a positive number! Please try again!*******");
        } else {
            balance = amount + balance;
        }
    }

    /**
     * Gets amount the customer withdraw. The withdraw amounts cannot be
     * negative and cannot greater than balance.
     *
     * @param amount is money the customer withdraw.
     */
    public void withdraw(double amount) throws IllegalArgumentException{

        if (amount <= 0) {
           throw new IllegalArgumentException("\n*******Withdraw amounts must be a positive number! Please try again!*******");
        } else if (balance - amount < 0) {
            throw new IllegalArgumentException("\n*******You do not have enough money. Please try again!*******");
        } else {
            balance = balance - amount;
        }

    }

    /**
     * Gets the interest earned this month.
     *
     * @return the interest earned this month.
     *
     */
    public double getMonthlyInterest() {
        double monthlyInterest = balance * (annualInterestRate / 12 / 100);
        return monthlyInterest;
    }
}
