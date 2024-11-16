package com.rizki.noteapp_mi2a.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.rizki.noteapp_mi2a.R
import com.rizki.noteapp_mi2a.model.Note

class NotesAdapter(
    private var notes: List<Note>,
    context: Context
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder> (){

    class NoteViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val txtItemTitle :TextView = itemView.findViewById(R.id.txtItemJudul)
        val txtItemContent :TextView = itemView.findViewById(R.id.txtItemIsiNotes)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,
            parent, false)
        return  NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesAdapter.NoteViewHolder, position: Int) {
       val noteData = notes[position]
        holder.txtItemTitle.text = noteData.title
        holder.txtItemContent.text = noteData.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    //fitur untuk auto refresh dat
    fun refreshData(newNotes: List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }



}