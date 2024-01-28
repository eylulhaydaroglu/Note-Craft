package com.example.noteapplication.fagments.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.model.NoteEntity
import com.example.noteapplication.databinding.NoteRowBinding
import com.example.noteapplication.fagments.list.ListFragmentDirections


class ListAdapter :RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    private var noteList= emptyList<NoteEntity>()
    class MyViewHolder(private val binding: NoteRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(noteEntity: NoteEntity) {
            binding.idTxt.text = noteEntity.id.toString()
            binding.nameTxt.text=noteEntity.name.toString()
            binding.noteTxt.text=noteEntity.note.toString()
            binding.root.tag = noteEntity.id
            binding.rowLayout.setOnClickListener {
                // Get the NavController associated with the ListFragment
                val navController = Navigation.findNavController(binding.root)
                // Use the generated action from ListFragment to UpdateFragment
                navController.navigate(ListFragmentDirections.actionListFragmentToUpdateFragment(noteEntity))
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NoteRowBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return noteList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.bind(currentItem)
    }// Function to update the adapter's data
    fun setData(noteEntity:List<NoteEntity> ) {
        this.noteList = noteEntity
        notifyDataSetChanged()
    }

}