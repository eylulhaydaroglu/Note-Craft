package com.example.noteapplication.fagments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.viewModel.DetailViewModel
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentListBinding
import com.example.noteapplication.fagments.detail.ListAdapter


class ListFragment : Fragment() {

    private var _binding:FragmentListBinding?=null
    private lateinit var mDetailViewModel: DetailViewModel
    private lateinit var adapter: ListAdapter
    private val binding  get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
        adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        mDetailViewModel=ViewModelProvider(this).get(DetailViewModel::class.java)

        mDetailViewModel.readAllNotes.observe(viewLifecycleOwner, Observer {noteEntity ->
            adapter.setData(noteEntity)
        })

        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}