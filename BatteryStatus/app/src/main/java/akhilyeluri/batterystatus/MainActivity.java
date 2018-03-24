package akhilyeluri.batterystatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver BatteryStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView batterystatus=(TextView)findViewById(R.id.battery_percentage);
        ProgressBar percentage_bar=(ProgressBar)findViewById(R.id.percentage);
        BatteryStatus=new RecieveBatteryStatus();


    }
    @Override
    protected void onStart() {
        registerReceiver(BatteryStatus,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }
    private class RecieveBatteryStatus extends BroadcastReceiver{
        ProgressBar percentage_bar=(ProgressBar)findViewById(R.id.percentage);
        TextView batterystatus=(TextView)findViewById(R.id.battery_percentage);
        TextView status=(TextView)findViewById(R.id.status);
        @Override
        public void onReceive(Context context, Intent intent) {
            int battery_status=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            batterystatus.setText("Battery Percentage:"+battery_status);
            percentage_bar.setProgress(battery_status);
           int IsCharging=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);

             switch (IsCharging){
                 case 2: status.setText("BATTERY STATUS : CHARGING");
                         break;
                 case 3: status.setText("BATTERY STATUS : DISCHARGING");
                         break;
             }
             if(IsCharging==2 && battery_status==100){
                 Intent intent1=new Intent(MainActivity.this,Website.class);
                 startActivity(intent1);
             }


        }

    }


}
