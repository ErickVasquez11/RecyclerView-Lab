package com.vasquez.dummyrecylcerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vasquez.dummyrecylcerview.repository.DictionaryRepository


class WordViewModelFactory(private val repository: DictionaryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WorldViewModel::class.java)) {
            return WorldViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}