package com.example.shimmer_effect_text

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmer_effect_text.databinding.LayoutItemBinding

class MainRVAdapter : RecyclerView.Adapter<MainRVAdapter.SampleViewHolder>() {

    private val samples = mutableListOf<Sample>()

    //private lateinit var layoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(samples[position])
    }

    override fun getItemCount() = samples.size

    @SuppressLint("NotifyDataSetChanged")
    fun replaceAll(samples: List<Sample>) {
        this.samples.clear()
        this.samples.addAll(samples)

        notifyDataSetChanged()
    }

    inner class SampleViewHolder(private val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sample: Sample) {
            binding.sampleIv.setImageResource(sample.coverImg!!)
            binding.nameTv.text = sample.name
            binding.emailTv.text = sample.email
        }
    }
}