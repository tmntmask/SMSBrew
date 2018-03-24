package census.census_sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Recieve_sms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_sms);


        SmsReceiver r = new SmsReceiver();
        Intent i = new Intent(this, Recieve_sms.class)
        r.onReceive(getApplicationContext(), i);
        startActivity(i);
    }
}
