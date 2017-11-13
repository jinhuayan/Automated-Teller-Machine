package Jinhua_Yan_a1;

import Jinhua_Yan_a1.model.*;
import java.util.*;

/**
 * The ATM class is a simulation of ATM machine.
 *
 * @author Jinhua Yan
 */
public class ATM {

    /**
     * Simulate the process of an ATM machine.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Make two bank accounts
        Account account1 = new Account("Jinhua Yan", 101);
        Account account2 = new Account("Andy Lau", 102);

        //Set the balance of account1 and account2
        account1.setBalance(50);
        account2.setBalance(1000);

        //Set the annual interest rate of account1 and account2
        account1.setAnnualInterestRate(5);
        account2.setAnnualInterestRate(5);
        
        int id = 0;
        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.print("Enter an account ID: ");
                String userInput = input.nextLine();
                id = Integer.parseInt(userInput);

                ATM atm = new ATM();
                //The ID has to be 101 or 102.
                if (id == 101) {
                    atm.displayMenu(account1);
                } else if (id == 102) {
                    atm.displayMenu(account2);
                } else {
                    //If the customer input number is not 101 or 102,
                    System.out.println("\n*******Please enter a valid number*******");
                }

                //Catch the input is not a number.
            } catch (Exception ex) {
                System.out.println("\n*******Please enter a valid number*******");
            }

        }
    }

    /**
     * Display Menu.
     * <p>
     * When the customer choose option 1, it will display account informations.
     * </p>
     * <p>
     * When the customer choose option 2 or 3, it will ask the customer to
     * withdraw or deposit money. </p>
     * <p>
     * When the customer choose option 4, it will exit the ATM machine and ask
     * ID again. </p>
     *
     * @param account is bank account
     *
     */
    public void displayMenu(Account account) {
        int num = 0;
        boolean error = false;
        while (num != 4) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n Main Menu \n 1: Account info \n 2: Withdraw \n 3: Deposit \n 4: Exit \n");
            System.out.print("Please choose what you'd like to do: ");
            try {
                num = input.nextInt();
                if (num == 1) {
                    //Print account info
                    System.out.printf("\nCustomer: %s \nAccount Banlance: $%.2f \nMonthly interest earned: $%.2f \n", account.getCustomerName(), account.getBalance(), account.getMonthlyInterest());
                } else if (num == 2) {
                    //Asking for an amount the customer want to withdraw.
                    do {
                        System.out.print("\nEnter the amount to withdraw: ");

                        Scanner input2 = new Scanner(System.in);
                        String userInput = input2.nextLine();

                        try {
                            error = false;
                            double withdraw = Double.parseDouble(userInput);
                            account.withdraw(withdraw);
                        } catch (NumberFormatException ex) {
                            error = true;
                            System.out.println("\n*******Please enter a valid number*******");
                        } catch (IllegalArgumentException ex) {
                            error = true;
                            System.out.println(ex.getMessage());
                        }
                    } while (error);
                } else if (num == 3) {
                    //Asking for an amount the customer want to deposit.
                    do {
                        System.out.print("\nEnter the amount to deposit: ");

                        Scanner input3 = new Scanner(System.in);
                        String userInput = input3.nextLine();

                        try {
                            error = false;
                            double deposit = Double.parseDouble(userInput);
                            account.deposit(deposit);
                        } catch (NumberFormatException ex) {
                            error = true;
                            System.out.println("\n*******Please enter a valid number*******");
                        } catch (IllegalArgumentException ex) {
                            error = true;
                            System.out.println(ex.getMessage());
                        }
                    } while (error);
                } else if (num == 4) {
                    return;
                } else {
                    //If the customer input number is not 1, 2, 3, or 4, 
                    System.out.println("\n*******Please enter a valid number*******");
                }
                //Catch the input is not a number.    
            } catch (Exception ex) {
                System.out.println("\n*******Please enter a valid number*******");
                displayMenu(account);
                break;
            }
        }

    }

}
