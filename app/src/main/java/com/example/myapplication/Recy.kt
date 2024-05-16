package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemBinding

 class Recy(val array: List<Item>):RecyclerView.Adapter<Recy.Mholder>() {

     class Mholder(val itemBinding: ItemBinding,val context:Context):RecyclerView.ViewHolder(itemBinding.root)
    {
        @SuppressLint("CheckResult")
        fun bind(model:Item) {
            itemBinding.apply {

                Glide.with(imageView.context).setDefaultRequestOptions(
                    RequestOptions().placeholder(R.drawable.loading_img).override(1000,500)
                ).load(model.url.toUri())
                    .into(itemBinding.imageView)
                textView.text = model.title
            }
        }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mholder {
         val inf=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false,)
         return Mholder(ItemBinding.bind(inf),parent.context)
     }

     override fun getItemCount(): Int {
         return array.size
     }

     override fun onBindViewHolder(holder: Mholder, position: Int) {
         holder.bind(array[position])
     }
 }