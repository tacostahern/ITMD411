/*
This program will hold all the methods and attributes that an account should have
Author: Tony Acosta Hernandez
*/

public class AccountHolder
{
    public static double annualInterestRate;
    public double balance;

    public AccountHolder(double balance)
    {
        if(balance < 0)
        {
            throw new IllegalArgumentException("Balance cannot be negative!"); //Ends the program after throwing exception
        }
        else
            this.balance = balance; 
    }

    public void deposit(double depo)
    {
        this.balance += depo; //Adds deposit to our balance
    }

    public void withdrawal(double with)//balance cannot drop below $50
    {
        if (balance - with < 50) //Don't do anything if its less than 50
            System.out.println("Error: Account balance must be at least $50! Withdrawal cancelled!");
        else
            this.balance -= with; //Need error trapping
    }

    public void MonthlyInterest()//Calculates our monthly interest
    {
        this.balance += this.balance * (annualInterestRate / 12.0);
    }
}