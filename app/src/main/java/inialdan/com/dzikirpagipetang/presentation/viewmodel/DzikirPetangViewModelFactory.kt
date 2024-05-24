package inialdan.com.dzikirpagipetang.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import inialdan.com.dzikirpagipetang.data.repository.DzikirPetangRepository

class DzikirPetangViewModelFactory(private val repository: DzikirPetangRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DzikirPetangViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DzikirPetangViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}