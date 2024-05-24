package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem
import inialdan.com.dzikirpagipetang.data.repository.DzikirSholatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DzikirSholatViewModel(private val repository: DzikirSholatRepository) : ViewModel() {

    private val _dzikirSholat = MutableStateFlow<List<DzikirResponseItem>>(emptyList())
    val dzikirSholat: StateFlow<List<DzikirResponseItem>> = _dzikirSholat

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            val fetchData = repository.getDzikirSholat()
            _dzikirSholat.emit(fetchData)
            _isLoading.emit(false)
        }
    }
}