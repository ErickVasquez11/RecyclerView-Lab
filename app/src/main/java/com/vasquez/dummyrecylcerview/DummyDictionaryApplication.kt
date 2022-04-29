package com.vasquez.dummyrecylcerview

import android.app.Application
import com.vasquez.dummyrecylcerview.data.model.DummyDictionaryDatabase
import com.vasquez.dummyrecylcerview.repository.DictionaryRepository

class DummyDictionaryApplication : Application() {
    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }
    fun getDictionaryRepository() = with(dataBase) {
        DictionaryRepository(wordDao(), synonymDao(), antonymDao())
    }

}