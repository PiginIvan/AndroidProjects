package com.example.recyclerviewapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        binding.buttonAddTask.setOnClickListener { showAddSubjectDialog() }
    }

    private fun setupRecyclerView() {
        adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun showAddSubjectDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_subject, null)
        val editTextSubject = dialogView.findViewById<EditText>(R.id.editTextSubject)
        val editTextGrade = dialogView.findViewById<EditText>(R.id.editTextGrade)

        AlertDialog.Builder(this).apply {
            setView(dialogView)
            setPositiveButton(getString(R.string.add)) { _, _ ->
                val subject = editTextSubject.text.toString()
                val grade = editTextGrade.text.toString()
                addSubject(subject, grade)
            }
            setNegativeButton(getString(R.string.cancel), null)
            create().apply {
                window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
                show()
            }
        }
    }

    private fun addSubject(subject: String, grade: String) {
        if (subject.isNotBlank() && grade.isNotBlank()) {
            adapter.addSubject(Subject(subject, grade))
            adapter.notifyItemInserted(adapter.getItemCount() - 1)
        }
    }
}