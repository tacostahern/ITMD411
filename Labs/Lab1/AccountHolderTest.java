import java.util.*;
/*
This is our tester program for AccountHolder. We will createa an AccountHolder object and work with it
Author: Tony Acosta Hernandez
*/
public class AccountHolderTest
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        AccountHolder.annualInterestRate = .04;

        //Ask for balance here
        System.out.print("Please enter your balance: ");
        double balance = scan.nextDouble();

        //Constructor will handle negative balance
        AccountHolder account = new AccountHolder(balance);

        //Get a deposit amount
        System.out.print("Please enter in a deposit amount: ");
        double deposit = scan.nextDouble();
        account.deposit(deposit);

        //Get a withdrawal amount. withdrawal() will handle the added rule
        System.out.print("Please enter in a withdrawal amount: ");
        double withdrawal = scan.nextDouble();
        account.withdrawal(withdrawal);

        //Get and print out monthly balance after interest rate is applied
        account.MonthlyInterest();
        System.out.printf("Balance: $%.2f", account.balance);
        scan.close();

    }
}