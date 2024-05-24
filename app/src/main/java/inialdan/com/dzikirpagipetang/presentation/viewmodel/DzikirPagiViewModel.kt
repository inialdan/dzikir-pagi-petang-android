package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem
import inialdan.com.dzikirpagipetang.data.repository.DzikirPagiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DzikirPagiViewModel(private val repository: DzikirPagiRepository) : ViewModel() {

    private val _dzikirPagi = MutableStateFlow<List<DzikirResponseItem>>(emptyList())
    val dzikirPagi: StateFlow<List<DzikirResponseItem>> = _dzikirPagi

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            val fetchData = repository.getDzikirPagi()
            _dzikirPagi.emit(fetchData)
            _isLoading.emit(false)
        }
    }
}