package com.example.groceryshop

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_view)

        val firstNameTextView = findViewById<TextView>(R.id.itemcode)
        val lastNameTextView = findViewById<TextView>(R.id.itemName)
        val emailTextView = findViewById<TextView>(R.id.itemQty)
        val phoneTextView = findViewById<TextView>(R.id.uPrice)
        val rollNumberTextView = findViewById<TextView>(R.id.supName)
        val courseTextView = findViewById<TextView>(R.id.supPhone)

        // Retrieve student details from intent extras
        val firstName = intent.getStringExtra("ITEM_CODE")
        val lastName = intent.getStringExtra("ITEM_NAME")
        val email = intent.getStringExtra("ITEM_QTY")
        val phone = intent.getStringExtra("UNIT_PRICE")
        val rollNumber = intent.getStringExtra("SUPPLIER NAME")
        val course = intent.getStringExtra("SUPPLIER PHONE")

        // Set student details to TextViews
        firstNameTextView.text = "ITEM_CODE: $firstName"
        lastNameTextView.text = "ITEM_NAME: $lastName"
        emailTextView.text = "ITEM_QTY: $email"
        phoneTextView.text = "UNIT_PRICE: $phone"
        rollNumberTextView.text = "SUPPLIER_NAME: $rollNumber"
        courseTextView.text = "SUPPLIER_PHONE: $course"
    }
}