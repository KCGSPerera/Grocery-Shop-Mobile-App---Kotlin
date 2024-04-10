package com.example.groceryshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddItem: Button
    private lateinit var buttonViewItem: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons
        buttonAddItem = findViewById(R.id.buttonAddItem)
        buttonViewItem = findViewById(R.id.buttonViewItem)

        // Set click listeners
        buttonAddItem.setOnClickListener {
            val intent = Intent(this, CartDetailsActivity::class.java)
            startActivity(intent)
        }

        buttonViewItem.setOnClickListener {
            val intent = Intent(this, CartListActivity::class.java)
            startActivity(intent)
        }
    }
}