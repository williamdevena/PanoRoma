package com.example.panoroma.ui.showinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panoroma.R

class long_info_zodiaco : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_info_zodiaco)
        setTitle("Info Zodiaco")
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


