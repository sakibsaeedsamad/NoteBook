package com.sssakib.notebook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.sssakib.notebook.R
import com.sssakib.notebook.model.Note
import com.sssakib.notebook.model.NoteDatabase
import com.sssakib.notebook.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        addNoteBtn.setOnClickListener {
            setNote()
        }
    }
    private fun setNote() {
        val title = noteTitleTXT.text.toString()
       val  description = noteDescriptionTXT.text.toString()


        if (title.length <= 2) {
            Toast.makeText(
                this,
                "Please enter Note Title.",
                Toast.LENGTH_LONG
            ).show()
        }
        if (description.length <= 2) {
            Toast.makeText(
                this,
                "Please enter Note",
                Toast.LENGTH_LONG
            ).show()
        }
        else {

            viewModel.insertNoteInfo(Note(0, title,description))


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(
                this,
                "Note Saved!",
                Toast.LENGTH_LONG
            ).show()

        }


    }
}