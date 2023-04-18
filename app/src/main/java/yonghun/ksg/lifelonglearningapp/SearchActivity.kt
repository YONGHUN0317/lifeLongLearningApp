package yonghun.ksg.lifelonglearningapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import yonghun.ksg.lifelonglearningapp.databinding.ActivityAftersearchBinding
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import yonghun.ksg.lifelonglearningapp.R

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchPagingAdapter.ClickListener {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: ActivityAftersearchBinding

    private val adapter: SearchPagingAdapter by lazy { SearchPagingAdapter(this) }

    companion object {
        var inputTitle: String? = null
        var FILTER = "SHOW_ALL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAftersearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()
        setupSearchView()
        observeLoadState()

        binding.aftersearchArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupViewModel() {
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            setHasFixedSize(true)
            adapter = this@SearchActivity.adapter
        }
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(title: String?): Boolean {
                inputTitle = title
                if (!title.isNullOrBlank()) {
                    FILTER = "SEARCH"
                } else {
                    FILTER = "SHOW_ALL"
                }
                adapter.refresh()
                binding.errorText.isVisible = false
                observeLoadState()
                return true
            }

        })
    }

    private fun observeLoadState() {
        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest { loadStates ->
                binding.progressBar.isVisible = loadStates.source.refresh is LoadState.Loading
                binding.errorText.isVisible = loadStates.source.refresh is LoadState.Error
                Log.d("LoadState", "Load state updated: $loadStates")
            }
        }
    }

    override fun clickedItem(item: Items?) {
        item?.let {
            val intent = Intent(this, LectureInformationActivity::class.java)
            with(intent) {
                putExtra("lctreNm", it.lctreNm)
                putExtra("instrctrNm", it.instrctrNm)
                putExtra("edcStartDay", it.edcStartDay)
                putExtra("edcEndDay", it.edcEndDay)
                putExtra("edcStartTime", it.edcStartTime)
                putExtra("edcColseTime", it.edcColseTime)
                putExtra("lctreCo", it.lctreCo)
                putExtra("edcTrgetType", it.edcTrgetType)
                putExtra("edcMthType", it.edcMthType)
                putExtra("operDay", it.operDay)
                putExtra("edcPlace", it.edcPlace)
                putExtra("psncpa", it.psncpa)
                putExtra("lctreCost", it.lctreCost)
                putExtra("edcRdnmadr", it.edcRdnmadr)
                putExtra("operInstitutionNm", it.operInstitutionNm)
                putExtra("operPhoneNumber", it.operPhoneNumber)
                putExtra("rceptStartDate", it.rceptStartDate)
                putExtra("rceptEndDate", it.rceptEndDate)
                putExtra("slctnMthType", it.slctnMthType)
                putExtra("homepageUrl", it.homepageUrl)
                putExtra("pntBankAckestYn", it.pntBankAckestYn)
                putExtra("lrnAcnutAckestYn", it.lrnAcnutAckestYn)
                putExtra("referenceDate", it.referenceDate)
                putExtra("insttCode", it.insttCode)
                putExtra("oadtCtLctreYn", it.oadtCtLctreYn)
            }
            startActivity(intent)
        }
    }
}
