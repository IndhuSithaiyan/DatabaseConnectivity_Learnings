import java.sql.*;

public class JDBC_example2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Connection connection = DriverManager.getConnection("jdbc:h2:file:~/OneDrive - Cognizant/h2db;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MySQL", "sa", "password");

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:import.sql';");
        System.out.println(connection.isValid(0));

//         CURD
//         SELECT
        PreparedStatement ps = connection.prepareStatement("select * from EMPLOYEES where name = ?");       //? - placeholder
        ps.setString(1,"Lisa");
        ResultSet re = ps.executeQuery();
        while (re.next()){
            System.out.println(re.getInt("id")+" "+re.getString("name"));
        }

//         CREATE
        PreparedStatement insertPs = connection.prepareStatement("insert into EMPLOYEES (id, name) values (?,?)");
        insertPs.setInt(1,3);
        insertPs.setString(2,"kamal");
        int insertRs = insertPs.executeUpdate();
        System.out.println("insert count "+ insertRs);


        //  UPDATE
        PreparedStatement updatePs = connection.prepareStatement("update EMPLOYEES set name = ? where id = ?");
        updatePs.setString(1,"kamal");
        updatePs.setInt(2,1);
        int updateRs = updatePs.executeUpdate();
        System.out.println("update count "+ updateRs);

        //  DELETE
        PreparedStatement deletePs = connection.prepareStatement("delete from EMPLOYEES where name = ?");
        deletePs.setString(1,"kamal");
        int delete = deletePs.executeUpdate();
        System.out.println("delete count "+ delete);
    }
}
