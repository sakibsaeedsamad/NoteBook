package com.sssakib.notebook.model

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * from note ORDER BY id DESC ")
    fun getAllNoteInfo(): List<Note>?

    @Insert
    fun insertNote(note: Note)
}