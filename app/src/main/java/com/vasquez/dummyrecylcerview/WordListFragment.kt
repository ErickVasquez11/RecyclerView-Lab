package com.vasquez.dummyrecylcerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vasquez.dummyrecylcerview.databinding.FragmentWordListBinding

import com.vasquez.dummyrecylcerview.model.Word
import com.vasquez.dummyrecylcerview.repository.DictionaryRepository


class WordListFragment : Fragment() {
    private val viewModelFactory by lazy {
        val repository = DictionaryRepository()
        WordViewModelFactory(repository)
    }

    private val viewModel: WorldViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordListRecyclerView = binding.wordListRecyclerView
        val wordAdapter = WordAdapter()
        wordListRecyclerView.apply {
            adapter = wordAdapter
        }

        binding.btnAddWord.setOnClickListener {
            viewModel.onAddWord(Word("Nota","Prueba, Exitosa"))

        }
        viewModel.words.observe(viewLifecycleOwner) { data ->
            wordAdapter.setData(data)
        }
    }
}