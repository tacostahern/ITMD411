public class AccountHolder
{
    public static double annualInterestRate;
    public double balance;

    public AccountHolder(double balance)
    {
        this.balance = balance; //Need error message for negative balance
    }

    public void deposit(double depo)
    {
        balance += deposit; //Adds deposit to our balance
    }

    public void withdrawal(double with)//balance cannot drop below $50
    {
        balance -= with; //Need error trapping
    }

    public void MonthlyInterest()//Calculates our monthly interest
    {
        balance += balance * (annualInterestRate / 12.0)
    }
}