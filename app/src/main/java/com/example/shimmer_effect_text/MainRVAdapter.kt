package com.example.shimmer_effect_text

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmer_effect_text.databinding.ItemUserBinding

class MainRVAdapter : RecyclerView.Adapter<MainRVAdapter.StoreViewHolder>() {

    private val storesList = mutableListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(storesList[position])
    }

    override fun getItemCount() = storesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun replaceAll(stores: List<Store>) { // 어댑터의 데이터 리스트를
        this.storesList.clear() // 기존 데이터 리스트 비움
        this.storesList.addAll(stores) // 새 데이터 리스트 추가
        notifyDataSetChanged() // 어댑터에게 데이터가 변경되었음을 알림
    }

    inner class StoreViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(store: Store) {
            binding.sampleIv.setImageResource(store.coverImg!!)
            binding.nameTv.text = store.name
            binding.costTv.text = store.cost
        }
    }
}