package com.a02363064.usucsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.usucsapp.databinding.FacultyListItemBinding

class FacultyAdapter(val faculty: List<FacultyMember>): RecyclerView.Adapter<FacultyAdapter.ViewHolder>() {

    class ViewHolder(val binding: FacultyListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FacultyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val facultyMember = faculty[position]
        holder.binding.facultyNameTextView.text = facultyMember.name
        holder.binding.TitleTextView.text = facultyMember.title
        holder.binding.OfficeLocationTextView.text = facultyMember.officeLocation
    }

    override fun getItemCount(): Int {
        return faculty.size
    }
}