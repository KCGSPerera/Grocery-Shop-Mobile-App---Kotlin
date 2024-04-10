package com.example.groceryshop.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.groceryshop.database.Product


@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Query("SELECT * FROM product_details")
    fun getAllProduct(): List<Product>

    @Delete
    fun deleteProduct(product: Product)

    @Update
    fun updateProduct(product: Product)
}
