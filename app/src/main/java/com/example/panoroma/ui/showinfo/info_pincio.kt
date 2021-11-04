package com.example.panoroma.ui.showinfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.panoroma.Main2Activity
import com.example.panoroma.R

class info_pincio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pincio)
        setTitle("Terrazza del pincio")

        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        val button = findViewById<Button>(R.id.pincio_map)
        button.setOnClickListener{
            val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?daddr=41.91124627890949, 12.477920068646357")
            )
            startActivity(intent)
        }
        val leggi = findViewById<TextView>(R.id.leggi_pincio)
        leggi.setOnClickListener{
            val myIntent = Intent(this, long_info_pincio::class.java)
            startActivity(myIntent)

            leggi.movementMethod = LinkMovementMethod.getInstance();
        }
    }

    // this event will enable the back
    // function to the button on press
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}