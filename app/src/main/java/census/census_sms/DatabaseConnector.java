package census.census_sms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by home on 24/3/18.
 */

public class DatabaseConnector {

    private static String username = "codebrew";
    private static String password = "codebrew";

    static {
        try {
            Class.forName("com.mysql.jdbc.census");
        } catch(ClassNotFoundException e) {
            System.err.println("Unable to load MySQL census");
        }
    }

    static public void main(String[] args) throws Exception {
        String jdbcUrl = "jdbc:mysql://localhost/sample?user="+username+"&password="+password;
        Connection con = DriverManager.getConnection(jdbcUrl);
        System.out.println("Connected!");
        con.close();
    }

}
