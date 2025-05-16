package com.example.priyalbatramachinetestminiecommapplication.di

import android.content.Context
import androidx.room.Room
import com.example.priyalbatramachinetestminiecommapplication.data.local.dao.CartDao
import com.example.priyalbatramachinetestminiecommapplication.data.local.db.AppDatabase
import com.example.priyalbatramachinetestminiecommapplication.data.remote.ApiService
import com.example.priyalbatramachinetestminiecommapplication.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): ApiService = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(app: Context): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "cart_db").build()

    @Provides
    fun provideCartDao(db: AppDatabase): CartDao = db.cartDao()

    @Provides
    fun provideRepository(api: ApiService, dao: CartDao): ProductRepository =
        ProductRepository(api, dao)
}