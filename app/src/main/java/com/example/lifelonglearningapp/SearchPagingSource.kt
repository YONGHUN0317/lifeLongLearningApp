package com.example.lifelonglearningapp


import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception


class SearchPagingSource(private val retrofitAPI: ApiService) : PagingSource<Int, Items>() {

    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        return try {

            val position = params.key ?: 1
            val response =
                retrofitAPI.getEmgMedData(
                    "5suQeq4QuBctnq8436EEoB1uFhgkMgC1E84bQl4TtrdWjovDg9CM0wYPJfwU+2T+zEBOkJ6foKxaTnYPPyg/dw==",
                    position,
                    "json"
                )
            return LoadResult.Page(
                data = response.response.body.items,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == 2299) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}



