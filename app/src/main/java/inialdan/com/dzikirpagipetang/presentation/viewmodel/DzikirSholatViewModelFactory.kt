package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import inialdan.com.dzikirpagipetang.data.repository.DzikirSholatRepository

class DzikirSholatViewModelFactory(private val repository: DzikirSholatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DzikirSholatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DzikirSholatViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}