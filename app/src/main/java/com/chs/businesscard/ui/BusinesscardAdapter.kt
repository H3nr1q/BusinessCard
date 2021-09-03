package com.chs.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chs.businesscard.data.BusinessCard
import com.chs.businesscard.databinding.ItemBusinessCardBinding

class BusinesscardAdapter :
    ListAdapter<BusinessCard, BusinesscardAdapter.ViewHolder>(DiffCallBack()){
    var listenerShare : (View) -> Unit = {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(item: BusinessCard){
                binding.tvNome.text = item.nome
                binding.tvTelefone.text = item.telefone
                binding.tvEmail.text = item.email
                binding.tvEmpresa.text = item.empresa
                binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
                binding.mcvContent.setOnClickListener{
                    listenerShare(it)
                }

            }
        }



}


class DiffCallBack: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id
}

