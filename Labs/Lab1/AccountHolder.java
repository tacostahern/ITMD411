public class AccountHolder
{
    public static double annualInterestRate;
    public double balance;

    public AccountHolder(double balance)
    {
        if(balance < 0)
        {
            throw new IllegalArgumentException("Balance cannot be negative!");
        }
        else
            this.balance = balance; //Need error message for negative balance
    }

    public void deposit(double depo)
    {
        balance += depo; //Adds deposit to our balance
    }

    public void withdrawal(double with)//balance cannot drop below $50
    {
        if (balance - with < 50)
            System.out.println("Error: Account balance must be at least $50! Withdrawal cancelled!");
        else
            this.balance -= with; //Need error trapping
    }

    public void MonthlyInterest()//Calculates our monthly interest
    {
        balance += balance * (annualInterestRate / 12.0);
    }
}