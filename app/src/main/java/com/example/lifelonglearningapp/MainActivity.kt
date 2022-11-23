package com.example.lifelonglearningapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentActivity
import com.example.lifelonglearningapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.apply {
            adapter = MyPageradapter(context as FragmentActivity)
        }

        val tabElement: List<String> = Arrays.asList("서울", "경기도", "인천","충청도", "강원도", "세종","대전", "경상도","대구","울산","부산","전라도","광주","제주도")

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "${tabElement.get(position)}"
        }.attach()

        // 메인 검색 선택 시 이벤트 설정
        search_image.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }





    }

}