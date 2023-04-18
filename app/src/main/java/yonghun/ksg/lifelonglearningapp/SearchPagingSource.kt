package yonghun.ksg.lifelonglearningapp

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException
import java.lang.NullPointerException

class SearchPagingSource(
    private val retrofitAPI: ApiService
) : PagingSource<Int, Items>() {

    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val page = params.key ?: 1

        return try {
            val response = retrofitAPI.getEmgMedData(
                BuildConfig.PUBLIC_APIKEY,
                page,
                "json"
            )

            val body = response.response.body
            val items = body.items
            val totalCount = body.totalCount.toInt()
            val numOfRows = body.numOfRows.toInt()

            when (SearchActivity.FILTER) {
                "SHOW_ALL" -> {
                    val totalPages = totalCount / numOfRows + if (totalCount % numOfRows != 0) 1 else 0
                    val prevKey = if (page == 1) null else page - 1
                    val nextKey = if (page == totalPages) null else page + 1
                    LoadResult.Page(data = items, prevKey = prevKey, nextKey = nextKey)
                }

                "SEARCH" -> {
                    val filteredItems = items.filter { item ->
                        item.lctreNm.contains(SearchActivity.inputTitle ?: "", ignoreCase = true)
                    }
                    LoadResult.Page(data = filteredItems, prevKey = null, nextKey = null)
                }
                else -> LoadResult.Error(IllegalArgumentException("Invalid filter"))
            }
        } catch (exception: IOException) {
            Log.d("데이터", "네트워크")
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Log.d("데이터", "HTTP")
            LoadResult.Error(exception)
        } catch (e: NullPointerException) {
            Log.d("데이터", "데이터없음")
            LoadResult.Error(e)
        }
    }
}
