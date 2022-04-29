package com.vasquez.dummyrecylcerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vasquez.dummyrecylcerview.data.model.Word
import com.vasquez.dummyrecylcerview.repository.DictionaryRepository
import kotlinx.coroutines.launch

class WorldViewModel(private val repository: DictionaryRepository) : ViewModel() {
    val words = repository.getAllWords()
    fun onAddWord(word: Word){
        viewModelScope.launch { repository.addWord(word) }
    }
}