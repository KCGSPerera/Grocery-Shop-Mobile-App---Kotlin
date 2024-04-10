package com.example.groceryshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryshop.database.Product

class CartListAdapter(private val onDeleteClickListener: (Product) -> Unit) : RecyclerView.Adapter<CartListAdapter.StudentViewHolder>() {

    private var products: List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            onDeleteClickListener(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.findViewById<TextView>(R.id.textName).text = "${product.itemCode} ${product.itemName}"
            itemView.findViewById<TextView>(R.id.textEmail).text = "Quantity: ${product.quantity}"
            itemView.findViewById<TextView>(R.id.textPhone).text = "Unit Price: ${product.unitPrice}"
            itemView.findViewById<TextView>(R.id.textrollNumber).text = "Supplier Name: ${product.supplierName}"
            itemView.findViewById<TextView>(R.id.textViewSupphone).text = "Supplier Phone: ${product.supplierPhone}"
        }
    }
}