import java.util.*;
import java.io.*;

public class Records extends BankRecords
{
	static FileWriter fw = null;

	public Records() { //constructor for Records, which creates the file we are going to be writing to.
		try 
		{
			fw = new FileWriter("bankrecords.txt");

		} 
		catch (IOException e) 
		{
			System.out.println("Can't write file!");
			e.printStackTrace();
		}
	}

	private static void AvgComp() //method to get the average income of males and females
	{
		Arrays.sort(robjs, new SexComparator()); //sort the array using SexComparator
		int mCount = 0, fCount = 0;
		double mIncome = 0, fIncome = 0;
		
		for(int i = 0; i < robjs.length; i++)//assigning counter and income variables values based on sex
		{
			if(robjs[i].getSex().equals("FEMALE"))
			{
				fCount++;
				fIncome += robjs[i].getIncome();
			}
			else
			{
				mCount++;
				mIncome += robjs[i].getIncome();
			}
		}
		
		System.out.printf("Average income for Females: $%.2f", (fIncome/fCount));
		System.out.printf("\nAverage income for Males: $%.2f\n", (mIncome/mCount));
		
		try//here we write to the file
		{
			fw.write("Average income for Females: $" + String.format("%.2f",fIncome/fCount));
			fw.write("\nAverage income for Males: $" + String.format("%.2f",mIncome/mCount));
		}
		catch (IOException e) {
			System.out.println("Can't write income!");
			e.printStackTrace();
		}

	}
	
	private static void fMortSave() //method to get num of females who have mortgages and savings accounts
	{
		Arrays.sort(robjs, new SexComparator());//sort the array using SexComparator
		int fCount = 0;
		
		for(int i = 0; i < robjs.length; i ++) //if we have a female with a mortgage and save_act, we add to the coutner variable
		{
			if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES") && robjs[i].getSave_act().equals("YES"))
			{
				fCount++;
			}
		}
		
		System.out.println("Number of Females with a mortgage and savings account: " + fCount);
		
		try//writing to the file
		{
			fw.write("\nNumber of Females with a mortgage and savings account: " + fCount);
		}
		catch (IOException e) {
			System.out.println("Can't write mortSave!");
			e.printStackTrace();
		}
	}
	
	private static void mCarKid() //method to get men from regions with cars and a child
	{
		Arrays.sort(robjs, new LocationComparator());
		int mCountInner = 0, mCountSub = 0, mCountTown = 0, mCountRural = 0;
		
		for(int i = 0; i < robjs.length; i ++) //big if statements to get men from different regions
		{
			if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("INNER_CITY"))
				mCountInner++;
			else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("RURAL"))
				mCountRural++;
			else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("SUBURBAN"))
				mCountSub++;
			else if(robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1 && robjs[i].getRegion().equals("TOWN"))
				mCountTown++;
		}
		
		System.out.println("Innercity region males with a car & 1 child: " + mCountInner);
		System.out.println("Rural region males with a car & 1 child: " + mCountRural);
		System.out.println("Suburban region males with a car & 1 child: " + mCountSub);
		System.out.println("Town region males with a car & 1 child: " + mCountTown);
		
		try
		{
			fw.write("\nInnercity region males with a car & 1 child: " + mCountInner);
			fw.write("\nRural region males with a car & 1 child: " + mCountRural);
			fw.write("\nSuburban region males with a car & 1 child: " + mCountSub);
			fw.write("\nTown region males with a car & 1 child: " + mCountTown);
		}
		catch (IOException e) {
			System.out.println("Can't write region!");
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Records r =  new Records();
		r.readData();
		System.out.print("\n");
		AvgComp();
		System.out.print("\n");
		fMortSave();
		mCarKid();
		
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		/* testing a printed sorted array
		Arrays.sort(robjs, new SexComparator());
		System.out.println("This is sorted array");
		System.out.println("ID\t\tAGE\t\tINCOME\t\tMORTGAGE\tSEX\t\tREGION");
        for(int i = 0; i < 25; i++){
            //System.out.println(robjs[i].toString());
        	if(robjs[i].getIncome() < 99999) { //so long as income is 5 figures is less, we print out the output a certain way
	        	System.out.print(robjs[i].getId() + "\t\t");
	        	System.out.print(robjs[i].getAge() + "\t\t");
	        	System.out.print(robjs[i].getIncome() + "\t\t");
	        	System.out.print(robjs[i].getMortgage() + "\t\t");
	        	System.out.print(robjs[i].getSex() + "\t\t");
	        	System.out.print(robjs[i].getRegion() + "\t\t");
	        	System.out.println();
        	} else { //given the income at line 12 of data, this line has its data not neatly formatted. This else statements solves the issue be removing a "\t" character after getIncome()
        		System.out.print(robjs[i].getId() + "\t\t");
	        	System.out.print(robjs[i].getAge() + "\t\t");
	        	System.out.print(robjs[i].getIncome() + "\t");
	        	System.out.print(robjs[i].getMortgage() + "\t\t");
	        	System.out.print(robjs[i].getSex() + "\t\t");
	        	System.out.print(robjs[i].getRegion() + "\t\t");
	        	System.out.println();
        	}
        }
        */
	}
	
}

class SexComparator implements Comparator<BankRecords>
{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) 
	{
		// use compareTo to compare strings
		int result = o1.getSex().compareTo(o2.getSex());
		return result;
	}
}

class LocationComparator implements Comparator<BankRecords>{
	 
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		// use compareTo to compare strings
		int result = o1.getRegion().compareTo(o2.getRegion());
		return result;
	}
}

