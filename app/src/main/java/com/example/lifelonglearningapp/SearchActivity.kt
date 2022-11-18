package com.example.lifelonglearningapp


import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import coil.util.CoilUtils.clear
import com.google.android.gms.common.util.WorkSourceUtil.size
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_aftersearch.*
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

        if (Filter == 0) {
            viewModel()
        }
        searchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(title: String?): Boolean {
                adapter.refresh()
                query = title
                Filter = 1
                viewModel()
                return true
            }
        })

        searchAdapter()
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

    fun searchAdapter(){
        adapter.addLoadStateListener { combinedLoadStates ->
            binding.apply {
                // 로딩 중 일 때
                progressBar.isVisible = combinedLoadStates.source.refresh is LoadState.Loading

                // 로딩 중이지 않을 때 (활성 로드 작업이 없고 에러가 없음)
                recyclerView.isVisible = combinedLoadStates.source.refresh is LoadState.NotLoading

                // 로딩 에러 발생 시
                //retryButton.isVisible = combinedLoadStates.source.refresh is LoadState.Error
                errorText.isVisible = combinedLoadStates.source.refresh is LoadState.Error

                // 활성 로드 작업이 없고 에러가 없음 & 로드할 수 없음 & 개수 1 미만 (empty)
                if (combinedLoadStates.source.refresh is LoadState.NotLoading
                    && combinedLoadStates.append.endOfPaginationReached
                    && adapter.itemCount < 1
                ) {
                    recyclerView.isVisible = false
                    emptyText.isVisible = true
                } else {
                    emptyText.isVisible = false
                }
            }
        }
    }

    private inline fun CombinedLoadStates.decideOnState(
        showLoading: (Boolean) -> Unit,
        showEmptyState: (Boolean) -> Unit,
        showError: (String) -> Unit
    ) {
        showLoading(refresh is LoadState.Loading)

        showEmptyState(
            source.append is LoadState.NotLoading
                    && source.append.endOfPaginationReached
                    && adapter.itemCount == 0
        )

        val errorState = source.append as? LoadState.Error
            ?: source.prepend as? LoadState.Error
            ?: source.refresh as? LoadState.Error
            ?: append as? LoadState.Error
            ?: prepend as? LoadState.Error
            ?: refresh as? LoadState.Error

        errorState?.let { showError(it.error.toString()) }
    }




}

