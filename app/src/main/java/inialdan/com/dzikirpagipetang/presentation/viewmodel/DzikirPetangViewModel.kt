package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inialdan.com.dzikirpagipetang.data.remote.DzikirResponseItem
import inialdan.com.dzikirpagipetang.data.repository.DzikirPetangRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DzikirPetangViewModel(private val repository: DzikirPetangRepository) : ViewModel() {

    private val _dzikirPetang = MutableStateFlow<List<DzikirResponseItem>>(emptyList())
    val dzikirPetang: StateFlow<List<DzikirResponseItem>> = _dzikirPetang

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.emit(true)
            val fetchData = repository.getDzikirPetang()
            _dzikirPetang.emit(fetchData)
            _isLoading.emit(false)
        }
    }

}