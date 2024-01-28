package com.example.noteapplication.repository

import androidx.lifecycle.LiveData
import com.example.noteapplication.data.NoteDao
import com.example.noteapplication.model.NoteEntity

class NoteRepository(private val noteDao: NoteDao) {
    val realAllNote: LiveData<List<NoteEntity>> =noteDao.readAllNotes()
    suspend fun addNote(noteEntity: NoteEntity){

        noteDao.addnote(noteEntity)
    }
    suspend fun updateNote(noteEntity: NoteEntity){
        noteDao.updateNote(noteEntity)
    }
    suspend fun deleteNote(noteEntity: NoteEntity){
        noteDao.deleteNote(noteEntity)
    }

}