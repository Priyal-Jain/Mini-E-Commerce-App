package com.example.priyalbatramachinetestminiecommapplication.repository

import com.example.priyalbatramachinetestminiecommapplication.data.local.dao.CartDao
import com.example.priyalbatramachinetestminiecommapplication.data.local.model.CartItem
import com.example.priyalbatramachinetestminiecommapplication.data.remote.ApiService
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val apiService: ApiService,
    private val cartDao: CartDao
    ) {
        suspend fun fetchProducts() = apiService.getProducts()

        suspend fun addToCart(item: CartItem) = cartDao.insertCartItem(item)

//        fun getCartItems() = cartDao.getAllCartItems()


    fun getCartItems(): Flow<List<CartItem>> = cartDao.getAllCartItems()
    suspend fun addItem(item: CartItem) = cartDao.insertCartItem(item)
    suspend fun removeItem(item: CartItem) = cartDao.deleteCartItem(item)
}
