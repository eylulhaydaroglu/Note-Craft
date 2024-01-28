package com.example.noteapplication.viewModel
import android.app.Application
import androidx.lifecycle.*
import com.example.noteapplication.data.AppDatabase
import com.example.noteapplication.repository.NoteRepository
import com.example.noteapplication.model.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(application: Application):AndroidViewModel(application) {

    val readAllNotes: LiveData<List<NoteEntity>>
    private val repository: NoteRepository

    init {
        val noteDao = AppDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllNotes = repository.realAllNote

    }

    fun addNote(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(noteEntity)
        }
    }

    fun updateNote(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(noteEntity)
        }
    }
    fun deleteNote(noteEntity: NoteEntity){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteNote(noteEntity)
        }
    }


}

