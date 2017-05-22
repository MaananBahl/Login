package com.example.maanan.intent

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {
    internal var b: Button? = null
    internal var e1: EditText? = null
    internal var e2: EditText? = null
    internal var e3: EditText? = null
    internal var e4: EditText? = null
    internal var s1: String? = null
    internal var s2: String? = null
    internal var s3: String? = null
    internal var s4: String? = null
    internal var pref: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref = applicationContext.getSharedPreferences(MY_PREFS_NAME, 0)
        if ((pref as SharedPreferences).getString("firstname", null) != null) {
            s1 = (pref as SharedPreferences).getString("firstname", null)
            s2 = (pref as SharedPreferences).getString("lastname", null)
            s3 = (pref as SharedPreferences).getString("email", null)
            s4 = (pref as SharedPreferences).getString("password", null)
            launchActivity()
        }
        setContentView(R.layout.activity_main)
        b = findViewById(R.id.button) as Button
        e1 = findViewById(R.id.editText1) as EditText
        e2 = findViewById(R.id.editText2) as EditText
        e3 = findViewById(R.id.editText3) as EditText
        e4 = findViewById(R.id.editText4) as EditText
        (b as Button).setOnClickListener(this)
    }

    private fun launchActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("firstname", s1)
        intent.putExtra("lastname", s2)
        intent.putExtra("email", s3)
        intent.putExtra("password", s4)
        startActivity(intent)
        finish()
    }

    override fun onClick(v: View) {
        s1 = e1?.text.toString()
        s2 = e2?.text.toString()
        s3 = e3?.text.toString()
        s4 = e4?.text.toString()


        val editor1 = pref?.edit()
        editor1?.putString("firstname", s1)
        editor1?.putString("lastname", s2)
        editor1?.putString("email", s3)
        editor1?.putString("password", s4)
        editor1?.apply()
        launchActivity()
    }

    companion object {

        val MY_PREFS_NAME = "MyPrefsFile"
    }

}
