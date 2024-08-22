import java.sql.*;

public class JDBC_example1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection connection = DriverManager.getConnection("jdbc:h2:file:~/OneDrive - Cognizant/h2db;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MySQL", "sa", "password");

        // Registering H2 JDBC driver
        Class.forName("org.h2.Driver");

        // Creating a connection to the database
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:;");

        // Creating a statement to execute SQL queries
        Statement st = connection.createStatement();

        // Creating a table (if not exists)
        st.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR (100))");

        // Inserting some data into the table
        st.executeUpdate("INSERT INTO users (id, name) VALUES (1, 'kamal')");
        st.executeUpdate("INSERT INTO users (id, name) VALUES (2, 'babu')");

        // Retrieving data from the table
        ResultSet re = st.executeQuery("select * from users");

        // Displaying the data
        while(re.next()){
            System.out.println(re.getInt("id")+" : "+re.getString("name"));
        }

        re.close();
        st.close();
        connection.close();

    }
}
