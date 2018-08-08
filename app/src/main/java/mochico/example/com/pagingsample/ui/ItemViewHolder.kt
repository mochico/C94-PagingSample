package mochico.example.com.pagingsample.ui

import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import mochico.example.com.pagingsample.R
import mochico.example.com.pagingsample.data.Item
import mochico.example.com.pagingsample.databinding.RecyclerViewItemBinding

class ItemViewHolder(parent :ViewGroup,
                     private val binding : RecyclerViewItemBinding =
                             DataBindingUtil.inflate<RecyclerViewItemBinding>(
                                     LayoutInflater.from(parent.context),
                                     R.layout.recycler_view_item,
                                     parent,
                                     false))
    : RecyclerView.ViewHolder(binding.root) {

    var item : Item? = null

    fun bindTo(item : Item?) {
        this.item = item
        binding.itemName.item_name.text = item?.name
    }
}