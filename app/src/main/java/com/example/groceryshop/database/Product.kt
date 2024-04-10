package com.example.groceryshop.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_details")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val itemCode: String,
    val itemName: String,
    val quantity: String,
    val unitPrice: String,
    val supplierName: String,
    val supplierPhone: String

)