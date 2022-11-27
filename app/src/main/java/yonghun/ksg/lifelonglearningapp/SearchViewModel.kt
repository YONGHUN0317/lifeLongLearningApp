package yonghun.ksg.lifelonglearningapp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(private val repository: SearchRepository) : ViewModel() {
    val list = repository.getQuotes().cachedIn(viewModelScope)
}