package com.example.shimmer_effect_text

import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.shimmer_effect_text.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainRVAdapter by lazy { MainRVAdapter() }
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러뷰 어댑터 연결
        binding.recyclerviewLayout.adapter = mainRVAdapter

        // 스와이프 리프레쉬 레이아웃 초기화
        swipeRefreshLayout = binding.swipeRefreshLayout


        // 스와이프 리프레쉬 레이아웃 관련 동작 설정
        swipeRefreshLayout.setOnRefreshListener {
            CoroutineScope(Dispatchers.Main).launch {
                isLoading(true)
                delay(1500)

                val stores = getStoreList() // 데이터 리스트
                mainRVAdapter.replaceAll(stores) // 어댑터에게 데이터가 변경되었음을 알림

                isLoading(false)

                swipeRefreshLayout.isRefreshing = false
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            val stores = getStoreList() // 데이터 리스트
            mainRVAdapter.replaceAll(stores)
        }

    }



    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.shimmerLayout.startShimmer()
            binding.shimmerLayout.visibility = View.VISIBLE
            binding.recyclerviewLayout.visibility = View.GONE
        } else {
            binding.shimmerLayout.stopShimmer()
            binding.shimmerLayout.visibility = View.GONE
            binding.recyclerviewLayout.visibility = View.VISIBLE
        }
    }
}