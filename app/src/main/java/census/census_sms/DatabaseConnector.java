package census.census_sms;

import android.database.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by home on 24/3/18.
 */

public class DatabaseConnector {

    private static String username = "codebrew";
    private static String password = "codebrew";



    public int connectToDB() throws Exception {
    /*/
    static public void main(String[] args) throws Exception {
        /**/
        System.out.println("Trying to connect");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Got driver");
        } catch(ClassNotFoundException e) {
            System.err.println("Unable to load MySQL driver");
            System.out.println("Didn't get driver!");
        }
        String jdbcUrl = "jdbc:mysql://128.199.224.104:3306/census?autoReconnect=true&useSSL=false";
        System.out.println(jdbcUrl);
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected!");
            con.close();
            return 0;
        } catch(SQLException e) {
            System.err.println("Error connecting");
            return 1;
        }
    }

}
