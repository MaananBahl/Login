package com.example.maanan.intent

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    internal var t1: TextView? = null
    internal var t2: TextView? = null
    internal var t3: TextView? = null
    internal var b1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        t1 = findViewById(R.id.textView1) as TextView
        t2 = findViewById(R.id.textView2) as TextView
        t3 = findViewById(R.id.textView3) as TextView
        b1 = findViewById(R.id.button2) as Button
        val b = intent.extras

        if (b != null) {
            val s = b.get("firstname") as String
            (t1 as TextView).text = s
            val s2 = b.get("lastname") as String
            (t2 as TextView).text = s2
            val s3 = b.get("email") as String
            (t3 as TextView).text = s3
        }
        (b1 as Button).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v === b1) {
            val i = Intent(this, MainActivity::class.java)
            val pref = applicationContext.getSharedPreferences(MY_PREFS_NAME, 0)
            val editor = pref.edit()
            editor.clear()
            editor.apply()

            startActivity(i)
            finish()
        }
    }

    companion object {


        val MY_PREFS_NAME = "MyPrefsFile"
    }
}
