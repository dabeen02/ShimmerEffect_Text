package com.example.shimmer_effect_text

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.shimmer_effect_text.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainRVAdapter by lazy { MainRVAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSample.adapter = mainRVAdapter

        loadSampleData()

    }

    private fun loadSampleData() {
        CoroutineScope(Dispatchers.Main).launch {
            isLoading(true)

            delay(1500)

            val samples = getSampleList()
            mainRVAdapter.replaceAll(samples)

            isLoading(false)
        }
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.sflSample.startShimmer()
            binding.sflSample.visibility = View.VISIBLE
            binding.rvSample.visibility = View.GONE
        } else {
            binding.sflSample.stopShimmer()
            binding.sflSample.visibility = View.GONE
            binding.rvSample.visibility = View.VISIBLE
        }
    }
}