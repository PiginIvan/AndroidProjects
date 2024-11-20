package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.databinding.ItemBinding

data class Subject(val name: String, val grade: String)

class MyAdapter : RecyclerView.Adapter<MyAdapter.SubjectViewHolder>() {
    private val subjects = mutableListOf<Subject>()

    class SubjectViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: Subject, onDelete: () -> Unit) {
            binding.textViewSubject.text = subject.name
            binding.textViewGrade.text = subject.grade
            binding.buttonTaskDone.setOnClickListener { onDelete() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(subjects[position]) {
            removeSubjectAt(position)
        }
    }

    override fun getItemCount(): Int = subjects.size

    fun addSubject(subject: Subject) {
        subjects.add(subject)
        notifyItemInserted(subjects.size - 1)
    }

    private fun removeSubjectAt(position: Int) {
        if (position >= 0 && position < subjects.size) {
            subjects.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}