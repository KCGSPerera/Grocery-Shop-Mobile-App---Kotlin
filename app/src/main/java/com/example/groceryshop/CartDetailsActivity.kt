package com.example.groceryshop

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryshop.database.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartDetailsActivity : AppCompatActivity() {
    private lateinit var itemcode: EditText
    private lateinit var itemName: EditText
    private lateinit var itemQty: EditText
    private lateinit var uPrice: EditText
    private lateinit var supName: EditText
    private lateinit var supPhone: EditText
    private lateinit var saveButton: Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        itemcode = findViewById(R.id.itemcode)
        itemName = findViewById(R.id.itemName)
        itemQty = findViewById(R.id.itemQty)
        uPrice = findViewById(R.id.uPrice)
        supName = findViewById(R.id.supName)
        supPhone = findViewById(R.id.supPhone)
        saveButton = findViewById(R.id.button10)

        saveButton.setOnClickListener {
            if (validateForm()) {
                saveStudent()
            }
        }
    }

    private fun validateForm(): Boolean {
        val icode = itemcode.text.toString().trim()
        val iname = itemName.text.toString().trim()
        val itemQtyStr = itemQty.text.toString().trim()
        val uPriceStr = uPrice.text.toString().trim()
        val sname = supName.text.toString().trim()
        val sphone = supPhone.text.toString().trim()

        if (icode.isEmpty() || iname.isEmpty() || itemQtyStr.isEmpty() || uPriceStr.isEmpty() || sname.isEmpty() || sphone.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }

        // Check if item code is exactly 4 numbers
        if (icode.length != 4 || !icode.matches("[0-9]+".toRegex())) {
            Toast.makeText(this, "Invalid item code. It must be 4 numbers.", Toast.LENGTH_SHORT).show()
            return false
        }

        // Check if phone is exactly 10 digits
        if (sphone.length != 10 || !sphone.matches("[0-9]+".toRegex())) {
            Toast.makeText(this, "Invalid phone number. It must be 10 digits.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun saveStudent() {
        val icode = itemcode.text.toString()
        val iname = itemName.text.toString()
        val qty = itemQty.text.toString()
        val uprice = uPrice.text.toString()
        val sname = supName.text.toString()
        val sphone = supPhone.text.toString()

        val product = Product(itemCode = icode, itemName = iname, quantity = qty, unitPrice = uprice, supplierName = sname, supplierPhone = sphone)

        CoroutineScope(Dispatchers.IO).launch {
            MyApplication.database.productDao().insertProduct(product)
        }

        Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_LONG).show()
        clearFields()
    }

    private fun clearFields() {
        itemcode.text.clear()
        itemName.text.clear()
        itemQty.text.clear()
        uPrice.text.clear()
        supName.text.clear()
        supPhone.text.clear()
    }
}