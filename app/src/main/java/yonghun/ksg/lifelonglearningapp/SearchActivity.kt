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
import kotlinx.android.synthetic.main.activity_aftersearch.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchPagingAdapter.ClickListener {

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
                lifecycleScope.launch {
                    adapter.loadStateFlow.collectLatest { loadStates ->
                        //progressBar.isVisible = loadStates.source.refresh is LoadState.Loading
                        // 로딩 에러 발생 시
                        errorText.isVisible = loadStates.source.refresh is LoadState.Error
                    }
                }
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

        aftersearch_arrow.setOnClickListener {
            onBackPressed()
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
        adapter = SearchPagingAdapter(this)
        recyclerView.adapter = adapter
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })

    }

    override fun clickedItem(item: Items?) {

        val intent = Intent(this, LectureInformationActivity::class.java)

        intent.putExtra("lctreNm", item?.lctreNm)
        intent.putExtra("instrctrNm", item?.instrctrNm)
        intent.putExtra("edcStartDay", item?.edcStartDay)
        intent.putExtra("edcEndDay", item?.edcEndDay)
        intent.putExtra("edcStartTime", item?.edcStartTime)
        intent.putExtra("edcColseTime", item?.edcColseTime)
        intent.putExtra("lctreCo", item?.lctreCo)
        intent.putExtra("edcTrgetType", item?.edcTrgetType)
        intent.putExtra("edcMthType", item?.edcMthType)
        intent.putExtra("operDay", item?.operDay)
        intent.putExtra("edcPlace", item!!.edcPlace)
        intent.putExtra("psncpa", item?.psncpa)
        intent.putExtra("lctreCost", item?.lctreCost)
        intent.putExtra("edcRdnmadr", item!!.edcRdnmadr)
        intent.putExtra("operInstitutionNm", item?.operInstitutionNm)
        intent.putExtra("operPhoneNumber", item?.operPhoneNumber)
        intent.putExtra("rceptStartDate", item?.rceptStartDate)
        intent.putExtra("rceptEndDate", item?.rceptEndDate)
        intent.putExtra("slctnMthType", item?.slctnMthType)
        intent.putExtra("homepageUrl", item?.homepageUrl)
        intent.putExtra("pntBankAckestYn", item?.pntBankAckestYn)
        intent.putExtra("lrnAcnutAckestYn", item?.lrnAcnutAckestYn)
        intent.putExtra("referenceDate", item?.referenceDate)
        intent.putExtra("insttCode", item?.insttCode)
        intent.putExtra("oadtCtLctreYn", item?.oadtCtLctreYn)

        startActivity(intent)
    }
}







