package akhilyeluri.batterystatus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IpActivity extends AppCompatActivity {
    Button ok;
    EditText ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("IP_ADDRESS",0);
        final SharedPreferences.Editor editor=preferences.edit();
        String ipa=preferences.getString("ip_address",null);
       if(ipa!=null){
            Intent intent=new Intent(IpActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        ip=(EditText)findViewById(R.id.ip);
        ok=(Button)findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ip.getText().toString().length()!=0){
                editor.putString("ip_address",ip.getText().toString());
                editor.commit();
                    Intent intent=new Intent(IpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(IpActivity.this, "IP ADDRESS CANT BE EMPTY", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
