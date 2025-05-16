package com.example.priyalbatramachinetestminiecommapplication.data.remote

import com.example.priyalbatramachinetestminiecommapplication.data.remote.response.ProductResponse
import retrofit2.http.GET


interface ApiService {
    @GET("/products")
    suspend fun getProducts(): List<ProductResponse>
}
