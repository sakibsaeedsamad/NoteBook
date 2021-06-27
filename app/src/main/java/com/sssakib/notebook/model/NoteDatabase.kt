package com.sssakib.notebook.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase? {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder<NoteDatabase>(

                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notedatabase"
                )
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }

    }

}