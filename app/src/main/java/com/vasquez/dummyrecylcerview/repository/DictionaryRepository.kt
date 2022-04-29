package com.vasquez.dummyrecylcerview.repository

import androidx.lifecycle.MutableLiveData
import com.vasquez.dummyrecylcerview.data.model.Word
import com.vasquez.dummyrecylcerview.data.model.dao.AntonymDao
import com.vasquez.dummyrecylcerview.data.model.dao.SynonymDao
import com.vasquez.dummyrecylcerview.data.model.dao.WordDao

class DictionaryRepository(
    private val wordDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
) {

    fun getAllWords() = wordDoa.getAllWords()

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}