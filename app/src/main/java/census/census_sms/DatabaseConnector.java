package census.census_sms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by home on 24/3/18.
 */

public class DatabaseConnector {

    private static String username = "codebrew";
    private static String password = "codebrew";



    static public void main(String[] args) throws Exception {
        try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch(ClassNotFoundException e) {
                System.err.println("Unable to load MySQL driver");
            }
        String jdbcUrl = "jdbc:mysql://128.199.224.104:3306/census";
        Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Connected!");
        con.close();
    }

}
