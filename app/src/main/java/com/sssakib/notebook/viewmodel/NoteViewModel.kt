package com.sssakib.notebook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sssakib.notebook.model.Note
import com.sssakib.notebook.model.NoteDatabase

class NoteViewModel(application: Application) : AndroidViewModel(application){

    lateinit var allNotes: MutableLiveData<List<Note>>

    init{
        allNotes = MutableLiveData()
        getAllNotes()
    }

    fun getAllNotesObservers() : MutableLiveData<List<Note>>{
        return allNotes
    }

    private fun getAllNotes(){
        val noteDao = NoteDatabase.getDatabase(getApplication())?.noteDao()
        val list = noteDao?.getAllNoteInfo()
        allNotes.postValue(list)
    }
    fun insertNoteInfo(note: Note){
        val noteDao = NoteDatabase.getDatabase(getApplication())?.noteDao()
        noteDao?.insertNote(note)
        getAllNotes()
    }

}