import java.sql.ResultSet;
import java.sql.SQLException;

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
			try {
				while (rs.next()) {
				// Retrieve data by column name (i.e., for id,income,pep)
				


				// Display values for id,income,pep
				
				  }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // closes result set object


	}

}
