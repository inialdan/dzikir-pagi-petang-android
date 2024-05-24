package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import inialdan.com.dzikirpagipetang.data.repository.DzikirPagiRepository

class DzikirPagiViewModelFactory(private val repository: DzikirPagiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DzikirPagiViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DzikirPagiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}