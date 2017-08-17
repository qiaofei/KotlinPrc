package com.qiaofei.gankio.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.databinding.ItemFuckgoodsBinding

/**
 * Created by wing on 11/23/16.
 */
class FuckGoodsAdapter(private val mList: List<FuckGoods>) :BaseBindingAdapter<ItemFuckgoodsBinding>() {
  override fun getItemCount(): Int {
    return mList.size
  }

  override fun onBindViewHolder(holder: DataBoundViewHolder<ItemFuckgoodsBinding>, position: Int) {
    super.onBindViewHolder(holder, position)
    holder.binding.fuckgoods = mList[position]
    holder.binding.executePendingBindings()
  }

  override fun onCreateViewHolder(parent: ViewGroup,
      viewType: Int): DataBoundViewHolder<ItemFuckgoodsBinding> {
    return DataBoundViewHolder(
        ItemFuckgoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }
}