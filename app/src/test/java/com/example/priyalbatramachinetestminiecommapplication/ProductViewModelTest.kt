//package com.example.priyalbatramachinetestminiecommapplication
//
//import com.example.priyalbatramachinetestminiecommapplication.data.remote.response.Product
//import com.example.priyalbatramachinetestminiecommapplication.repository.ProductRepository
//import com.example.priyalbatramachinetestminiecommapplication.viewModel.ProductViewModel
//import org.junit.Assert.assertEquals
//import org.junit.Test
//import org.junit.Before
//
//@RProductViewModelTest {
//    private lateinit var viewModel: ProductViewModel
//    private val repository = mock(ProductRepository::class.java)
//
//    @Before
//    fun setup() {
//        viewModel = ProductViewModel(repository)
//    }
//
//    @Test
//    unWith(MockitoJUnitRunner::class)
//    class     fun testLoadProducts() = runBlocking {
//        val mockProducts = listOf(Product(1, "Test", 10.0, ""))
//        `when`(repository.fetchProducts()).thenReturn(mockProducts)
//        viewModel.loadProducts()
//        assertEquals(1, viewModel.products.value.size)
//    }
//}