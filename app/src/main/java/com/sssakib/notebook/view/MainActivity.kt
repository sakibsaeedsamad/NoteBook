package com.sssakib.notebook.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sssakib.notebook.R
import com.sssakib.notebook.adapter.ListOfNotesAdapter
import com.sssakib.notebook.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    lateinit var listOfNotesAdapter: ListOfNotesAdapter
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)


        button.setOnClickListener {
                val intent = Intent(this, AddActivity::class.java)
                startActivity(intent)

        }
        ShowNotes.setOnClickListener {

            noteRC.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                listOfNotesAdapter = ListOfNotesAdapter()
                adapter = listOfNotesAdapter
            }
            viewModel.getAllNotesObservers().observe(this, Observer {

                listOfNotesAdapter.setListData(ArrayList(it))
                listOfNotesAdapter.notifyDataSetChanged()
            })


        }

    }


}



