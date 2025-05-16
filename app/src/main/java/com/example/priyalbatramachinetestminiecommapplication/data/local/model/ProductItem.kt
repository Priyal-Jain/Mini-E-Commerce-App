package com.example.priyalbatramachinetestminiecommapplication.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products")
data class ProductItem(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int = 1
)