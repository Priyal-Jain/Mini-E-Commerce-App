package com.example.priyalbatramachinetestminiecommapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.priyalbatramachinetestminiecommapplication.data.local.dao.CartDao
import com.example.priyalbatramachinetestminiecommapplication.data.local.model.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}