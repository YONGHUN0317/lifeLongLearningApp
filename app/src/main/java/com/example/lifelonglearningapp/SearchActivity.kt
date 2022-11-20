package com.example.lifelonglearningapp


import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import coil.util.CoilUtils.clear
import com.google.android.gms.common.util.WorkSourceUtil.size
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_aftersearch.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import java.nio.file.Files.size

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SearchPagingAdapter
    lateinit var searchView: SearchView
    private lateinit var binding: ActivityAftersearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAftersearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel()

        searchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(title: String?): Boolean {

                adapter.refresh()
                errorText.isVisible = false
                Log.d("텍스트제출", "텍스트제출")
                query = title
                Filter = 1
                viewModel()
                return true
            }
        })



        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadStates ->
                progressBar.isVisible = loadStates.source.refresh is LoadState.Loading


                // 로딩 에러 발생 시
                errorText.isVisible = loadStates.source.refresh is LoadState.Error



            }
        }

    }

    companion object {
        var query: String? = null
        var Filter: Int = 0

    }

    fun viewModel() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        adapter = SearchPagingAdapter()
        recyclerView.adapter = adapter
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })

    }
}







