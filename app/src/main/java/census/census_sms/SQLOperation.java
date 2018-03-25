package census.census_sms;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

/**
 * Created by spham on 25/03/18.
 */

public class SQLOperation extends AsyncTask<HashMap<String,String>,Void,Void> {
    private Connection conn =null;
    private Context context;

    public SQLOperation(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(context, "Data submitted successfully", Toast.LENGTH_SHORT).show();
        super.onPostExecute(aVoid);
    }

    @Override
    protected Void doInBackground(HashMap<String, String>[] hashMaps) {
        try {
            //Log.e("TEST", "START");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Toast.makeText(context, "got driver", Toast.LENGTH_SHORT).show();
            conn = DriverManager.getConnection("jdbc:mysql://128.199.224.104:3306/census", "codebrew", "codebrew");
            if (conn !=null ) {
                Toast.makeText(context, "made connection", Toast.LENGTH_SHORT).show();
            }


            //Log.e("TEST", "DONE");

            Statement statement = conn.createStatement();
            Toast.makeText(context, "made statement", Toast.LENGTH_SHORT).show();
            String[] keys = {"Gender", "DOB", "Region", "Citizenship"};
            String sqlcol = "(`Gender`,`DOB`, `Region`,`Citizenship`)";
            String sqlval = "(";
            for (String item : keys) {
                if (item.equals("Citizenship"))
                    sqlval += '"' + hashMaps[0].get(item) + '"';
                else
                    sqlval += '"' + hashMaps[0].get(item) + '"' + ",";

            }
            sqlval += ");";
            //Log.e("TEST", "INSERT INTO `census`.`Person`" + sqlcol + "VALUES" + sqlval);
            statement.execute("INSERT INTO `census`.`Person`" + sqlcol + "VALUES" + sqlval);
            Toast.makeText(context, "data put in database", Toast.LENGTH_SHORT).show();
            //statement.execute("SELECT * FROM `census`.`Person`");

        }
        catch (Exception e) {
            System.err.print(e);
            //e.printStackTrace();
        }
        return null;
    }
}
