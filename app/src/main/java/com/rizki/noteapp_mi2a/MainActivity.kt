package com.rizki.noteapp_mi2a

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizki.noteapp_mi2a.adapter.NotesAdapter
import com.rizki.noteapp_mi2a.databinding.ActivityMainBinding
import com.rizki.noteapp_mi2a.helper.NoteDatabaseHelper
import com.rizki.noteapp_mi2a.screen.AddNoteActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var db : NoteDatabaseHelper
    //private lateinit var addBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(), this)

        binding.notesRecycleview.layoutManager = LinearLayoutManager(this)
        binding.notesRecycleview.adapter = notesAdapter

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }
    //TASK
    //Ketika item list note di  klik dia akan ke page detail sesuai dengan item dan content nya
    override fun onResume() {
        super.onResume()
        val notes = db.getAllNotes()
        notesAdapter.refreshData(notes)
    }
}