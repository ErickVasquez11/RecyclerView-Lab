package com.vasquez.dummyrecylcerview

import androidx.lifecycle.ViewModel
import com.vasquez.dummyrecylcerview.model.Word
import com.vasquez.dummyrecylcerview.repository.DictionaryRepository

class WorldViewModel(private val repository: DictionaryRepository) : ViewModel() {
    val words = repository.words
    fun onAddWord(word: Word){
        repository.addWord(word)
    }
}