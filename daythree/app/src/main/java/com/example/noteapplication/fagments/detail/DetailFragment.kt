package com.example.noteapplication.fagments.detail
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.noteapplication.viewModel.DetailViewModel
import com.example.noteapplication.model.NoteEntity
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var mDetailViewModel: DetailViewModel
    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        mDetailViewModel=ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.buttonSave.setOnClickListener(){
            insertDatatoDatabase() }
        return binding.root }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun insertDatatoDatabase(){

        val name=binding.editTextName.text.toString()
        val note=binding.editTextNote.text.toString()
        if(inputCheck(name,note)){
            val note = NoteEntity(0,name,note)
            mDetailViewModel.addNote(note)
            Toast.makeText(requireContext(),"Saved",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Fill out all fields",Toast.LENGTH_LONG).show() } }
    private fun inputCheck(name:String,note:String):Boolean{
        return !(TextUtils.isEmpty(note) &&TextUtils.isEmpty(name) )
    }
}


