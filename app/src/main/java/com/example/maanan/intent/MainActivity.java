package com.example.maanan.intent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    Button b;
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    String s1,s2,s3,s4;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME,0);
        if (pref.getString("firstname",null)!=null) {
            s1 = pref.getString("firstname",null);
            s2 = pref.getString("lastname",null);
            s3 = pref.getString("email",null);
            s4 = pref.getString("password",null);
            launchActivity();
        }
        setContentView(R.layout.activity_main);
        b= (Button) findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        b.setOnClickListener(this);
    }

    private void launchActivity() {
        Intent intent = new Intent(this, secondactivity.class);
        intent.putExtra("firstname",s1);
        intent.putExtra("lastname",s2);
        intent.putExtra("email",s3);
        intent.putExtra("password",s4);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();


        SharedPreferences.Editor editor1 = pref.edit();
        editor1.putString("firstname",s1);
        editor1.putString("lastname",s2);
        editor1.putString("email",s3);
        editor1.putString("password",s4);
        editor1.apply();
        launchActivity();
    }
}
