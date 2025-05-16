package com.example.priyalbatramachinetestminiecommapplication.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.priyalbatramachinetestminiecommapplication.databinding.ActivityShoppingCartBinding
import com.example.priyalbatramachinetestminiecommapplication.ui.adapter.ProductAdapter
import com.example.priyalbatramachinetestminiecommapplication.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCartBinding
    private val viewModel: ProductViewModel by viewModels()
    private val adapter = ProductAdapter { item ->
        viewModel.deleteItem(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cartRecyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.cartItems.collect { items ->
                adapter.submitList(items)
                binding.btnCheckout.isEnabled = items.isNotEmpty()
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.totalPrice.collect {
                binding.tvTotalPrice.text = "Total: ₹%.2f".format(it)
            }
        }

        binding.btnCheckout.setOnClickListener {
            Toast.makeText(this, "Proceeding to checkout!", Toast.LENGTH_SHORT).show()
        }
    }
}
