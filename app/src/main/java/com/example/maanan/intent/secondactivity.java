package com.example.maanan.intent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity implements View.OnClickListener{


    public static final String MY_PREFS_NAME = "MyPrefsFile";
    TextView t1;
    TextView t2;
    TextView t3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        t1 = (TextView)findViewById(R.id.textView1);
        t2 = (TextView)findViewById(R.id.textView2);
        t3 = (TextView)findViewById(R.id.textView3);
        b1 = (Button)findViewById(R.id.button2);
        Bundle b = getIntent().getExtras();

        if(b!=null){
            String s = (String) b.get("firstname");
            t1.setText(s);
            String s2 = (String)b.get("lastname");
            t2.setText(s2);
            String s3 = (String)b.get("email");
            t3.setText(s3);
        }
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==b1){
            Intent i = new Intent(this,MainActivity.class);
            SharedPreferences pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME,0);
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.apply();

            startActivity(i);
        }
    }
}
