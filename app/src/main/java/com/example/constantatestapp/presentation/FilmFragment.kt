package com.example.constantatestapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constantatestapp.databinding.FragmentFilmBinding
import com.example.constantatestapp.data.Item


class FilmFragment : Fragment() {
    lateinit var binding: FragmentFilmBinding
    lateinit var filmsViewModel: FilmsViewModel
    lateinit var filmsItems: List<Item>
    private val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        filmsViewModel = ViewModelProvider(requireActivity()).get(FilmsViewModel::class.java)
        binding = FragmentFilmBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        filmsViewModel.request()

        filmsViewModel.itemsFilms.observe(activity as LifecycleOwner, Observer {
            filmsItems = it
            adapter.setSortedFilmsList(filmsItems)
            adapter.notifyDataSetChanged()
        })

        binding.rvFilms.layoutManager = LinearLayoutManager(context)
        binding.rvFilms.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = FilmFragment()
    }
}