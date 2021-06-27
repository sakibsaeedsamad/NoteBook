package com.sssakib.notebook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sssakib.notebook.R
import com.sssakib.notebook.model.Note
import kotlinx.android.synthetic.main.list_note_recyclerview.view.*

class ListOfNotesAdapter() :
    RecyclerView.Adapter<ListOfNotesAdapter.MyViewHolder>() {

    var items = ArrayList<Note>()

    fun setListData(data: ArrayList<Note>) {
        this.items = data
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListOfNotesAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_note_recyclerview, parent, false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListOfNotesAdapter.MyViewHolder, position: Int) {


        holder.bind(items[position])


    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleTextView = view.textViewTitle
        val descriptionTextView = view.textViewDescription

        fun bind(data: Note) {
            titleTextView.text = "Title: " + data.title
            descriptionTextView.text = "Description: " + data.description
        }


    }


}