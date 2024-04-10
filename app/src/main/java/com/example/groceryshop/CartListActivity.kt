package com.example.groceryshop

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryshop.database.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CartListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CartListAdapter { product ->
            // Handle delete action here
            // For example, show a confirmation dialog and delete the student upon confirmation
            showDeleteConfirmationDialog(product)
        }

        recyclerView.adapter = adapter

        // Fetch data and set it to the adapter
        GlobalScope.launch(Dispatchers.Main) {
            val products = MyApplication.database.productDao().getAllProduct()
            adapter.setData(products)
        }
    }

    private fun showDeleteConfirmationDialog(product: Product) {
        AlertDialog.Builder(this)
            .setTitle("Delete Product")
            .setMessage("Are you sure you want to delete this Product?")
            .setPositiveButton("Yes") { _, _ ->
                // Delete the student from the database
                GlobalScope.launch(Dispatchers.IO) {
                    MyApplication.database.productDao().deleteProduct(product)
                }

                // Update the UI after deletion
                GlobalScope.launch(Dispatchers.Main) {
                    val products = MyApplication.database.productDao().getAllProduct()
                    adapter.setData(products)
                }
            }
            .setNegativeButton("No", null)
            .show()
    }
}