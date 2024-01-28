package com.example.noteapplication.fagments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentDetailBinding
import com.example.noteapplication.databinding.FragmentUpdateBinding
import com.example.noteapplication.model.NoteEntity
import com.example.noteapplication.viewModel.DetailViewModel


@Suppress("DEPRECATION")
class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private lateinit var mDetailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        mDetailViewModel= ViewModelProvider(this).get(DetailViewModel::class.java)
        // Set the name to the editText using data binding
        binding.updateeditTextName.setText(args.currentNote.name)
        binding.updateeditTextNote.setText(args.currentNote.note)
        binding.updatebuttonSave.setOnClickListener{

            updateItem()
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun updateItem(){
        val name=binding.updateeditTextName.text.toString()
        val note=binding.updateeditTextNote.text.toString()
        if(inputCheck(name,note)){
            val updatedNote = NoteEntity(args.currentNote.id,name,note)
            mDetailViewModel.updateNote(updatedNote)
            Toast.makeText(requireContext(),"Updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name:String,note:String):Boolean{
        return !(TextUtils.isEmpty(note) && TextUtils.isEmpty(name) )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteNote()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun deleteNote(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_->
            mDetailViewModel.deleteNote(args.currentNote)
            Toast.makeText(requireContext(),"Deleted: ${args.currentNote.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_->}
        builder.setTitle("Delete ${args.currentNote.name}?")
        builder.setMessage("Are you sure you want to delete ${args.currentNote.name}?")
        builder.create().show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}