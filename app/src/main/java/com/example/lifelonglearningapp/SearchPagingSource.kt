package com.example.lifelonglearningapp


import android.provider.DocumentsContract
import android.text.method.TextKeyListener.clear
import android.util.Log
import com.example.lifelonglearningapp.BuildConfig
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.android.synthetic.main.activity_aftersearch.*
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException


class SearchPagingSource(private val retrofitAPI: ApiService) : PagingSource<Int, Items>() {


    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val position = params.key ?: 1
        lateinit var getData: LoadResult<Int, Items>

        var response1 = retrofitAPI.getEmgMedData(
            BuildConfig.PUBLIC_APIKEY,
            position,
            "json"
        )
        var response2 = retrofitAPI.getTitleData(
            BuildConfig.PUBLIC_APIKEY,
            position,
            "json",
            SearchActivity.query
        )


        try {
            if (SearchActivity.Filter == 0) {
                getData = LoadResult.Page(
                    data = response1.response.body.items,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = if (position == 2299) null else position + 1
                )
            } else if (SearchActivity.Filter == 1) {
                SearchActivity.Filter = 0
                getData = LoadResult.Page(
                    data = response2.response.body.items,
                    prevKey = if (position == 1) null else position - 1,
                    nextKey = if (position == (response2.response.body.totalCount.toInt() / response2.response.body.numOfRows.toInt()) + 1) null else position + 1
                )
            }
            return getData
        } catch (exception: IOException) {
            // 네트워크 연결 자체를 실패한 경우 처리
            Log.d("데이터", "네트워크")
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            // http 통신중 http 오류코드(400, 403..)를 통한 처리
            Log.d("데이터", "HTTP")
            return LoadResult.Error(exception)
        } catch (e: NullPointerException) {
            Log.d("데이터", "데이터없음")
            return LoadResult.Error(e)
        }
    }





}



