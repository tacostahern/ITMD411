import java.util.*;

public class AccountHolderTest
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your balance: ");
        double balance = scan.nextDouble();

        //Error trapping here for negative balance
        AccountHolder account = new AccountHolder(balance);

        System.out.println("Please enter in a deposit amount: ");
        double deposit = scan.nextDouble();
        account.deposit(deposit);

        System.out.println("Please enter in a withdrawal amount");
        double withdrawal = scan.nextDouble();
        account.withdrawal(withdrawal);

        account.MonthlyInterest();
        System.out.println("Balance: $" + account.balance);

    }
}