package com.example.panoroma.ui.showinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.panoroma.R

class long_info_pincio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_info_pincio)
        setTitle("Info Terrazza del pincio")
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


