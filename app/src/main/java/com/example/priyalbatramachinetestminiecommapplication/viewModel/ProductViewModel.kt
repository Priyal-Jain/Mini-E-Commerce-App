package com.example.priyalbatramachinetestminiecommapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.priyalbatramachinetestminiecommapplication.data.local.model.CartItem
//import com.example.priyalbatramachinetestminiecommapplication.data.local.model.CartItem
import com.example.priyalbatramachinetestminiecommapplication.data.remote.response.ProductResponse
import com.example.priyalbatramachinetestminiecommapplication.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<ProductResponse>>(emptyList())
    val products: StateFlow<List<ProductResponse>> = _products

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

//    val cartItems = repository.getCartItems().stateIn(
//        viewModelScope, SharingStarted.Eagerly, emptyList()
//    )

    val totalPrice = cartItems.map { items ->
        items.sumOf { it.price }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, 0.0)

    fun loadProducts() = viewModelScope.launch {
        _products.value = repository.fetchProducts()
    }

    fun addToCart(product: ProductResponse) = viewModelScope.launch {
        val cartItem = CartItem(
            id = product.id,
            title = product.title,
            price = product.price,
            image = product.image
        )
        repository.addToCart(cartItem)
    }

    fun loadCartItems() {
        viewModelScope.launch {
            repository.getCartItems().collect {
                _cartItems.value = it
            }
        }
    }


    fun deleteItem(item: CartItem) {
        viewModelScope.launch {
            repository.removeItem(item)
        }
    }
}

