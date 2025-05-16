package com.example.priyalbatramachinetestminiecommapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.priyalbatramachinetestminiecommapplication.data.local.model.CartItem
import com.example.priyalbatramachinetestminiecommapplication.databinding.CardViewDesignBinding


class ProductAdapter(
    private val onDeleteClick: (CartItem) -> Unit
) : ListAdapter<CartItem, ProductAdapter.CartViewHolder>(DiffCallback()) {

    inner class CartViewHolder(val binding: CardViewDesignBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            tvTitle.text = item.title
//            tvDescription.text = item.title
//            tvQuantity.text = "Qty: ${item.quantity}"
            tvPrice.text = "₹${item.price}"
//            btnDelete.setOnClickListener { onDeleteClick(item) }
//            Glide.with(holder.binding.root).load(item.image).into(imageview)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(old: CartItem, new: CartItem) = old.id == new.id
        override fun areContentsTheSame(old: CartItem, new: CartItem) = old == new
    }
}