import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	// constructor
	public Dao() { // create db object instance
		conn = new DBConnect();
	}

	// CREATE TABLE METHOD
	public void createTable() {
		try {
			// Open a connection
			System.out.println("Connecting to a selected database to create Table...");
			System.out.println("Connected database successfully...");

			// Execute create query
			System.out.println("Creating table in given database...");

			stmt = conn.connect().createStatement();

			String sql = "CREATE TABLE t_acos_tab4 " + "(pid INTEGER not NULL AUTO_INCREMENT, " + " id VARCHAR(10), "
					+ " income numeric(8,2), " + " pep VARCHAR(4), " + " PRIMARY KEY ( pid ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			conn.connect().close(); // close db connection
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}

	// INSERT INTO METHOD
	public void insertRecords(BankRecords[] robjs) {
		try {
			System.out.println("Connecting to a selected database for Inserts...");
			System.out.println("Connected database successfully...");
			// Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.connect().createStatement();
			String sql = null;

			// Include all object data to the database table
			for (int i = 0; i < robjs.length; ++i) {

				// finish string assignment to insert all object data
				// (id, income, pep) into your database table

				sql = "INSERT INTO t_acos_tab4(id, income, pep)" + "VALUES(' " + robjs[i].getId().toUpperCase() + "', ' "
						+ robjs[i].getIncome() + "', ' " + robjs[i].getPep() + "')";

				stmt.executeUpdate(sql);
			}
			System.out.println("Inserted records into the table...");
			conn.connect().close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public ResultSet retrieveRecords() {
		ResultSet rs = null;

		try {
			System.out.println("Connecting to a selected database for Record retrievals...");
			stmt = conn.connect().createStatement();
			System.out.println("Connected database successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Creating Select statement...");
		String sql = "SELECT id,income, pep from t_acos_tab4 ORDER BY pep DESC";
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.connect().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
