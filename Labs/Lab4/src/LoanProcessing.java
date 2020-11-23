import java.sql.ResultSet;

public class LoanProcessing extends BankRecords{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRecords br = new BankRecords();
		br.readData();
		Dao dao = new Dao();
		dao.createTable();
		dao.insertRecords(robjs); // perform inserts
		ResultSet rs = dao.retrieveRecords(); // fill result set object

		// Create heading for display
		
		
		// Extract data from result set
			while (rs.next()) {
			// Retrieve data by column name (i.e., for id,income,pep)
			


			// Display values for id,income,pep
			
		      }
		rs.close(); // closes result set object


	}

}
