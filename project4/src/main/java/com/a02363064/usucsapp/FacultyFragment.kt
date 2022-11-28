package com.a02363064.usucsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.a02363064.usucsapp.databinding.FragmentFacultyBinding

data class FacultyMember(
    val name: String,
    val title: String,
    val officeLocation: String
)

class FacultyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentFacultyBinding.inflate(inflater, container, false)
        binding.GoToHome.setOnClickListener{
            findNavController().navigate(R.id.faculty_to_home)
        }
        binding.GoToResearch.setOnClickListener{
            findNavController().navigate(R.id.faculty_to_research)
        }
        val facultyNames = arrayOf<String>("Erik Falor", "Joseph Ditton", "Curtis Dyreson",
            "Vicki Allan", "Heng-Da Cheng", "Stephen Clyde", "Haitao Wang", "Dan Watson",
            "Dean Mathias", "Mario Harper")
        val facultyTitles = arrayOf<String>("Professional Practice Associate Professor",
            "Professional Practice Assistant Professor", "Professor", "Associate Professor",
            "Professor", "Emeritus Associate Professor", "Professor" , "Associate Professor",
            "Professional Practice Associate Professor", "Assistant Professor")
        val facultyOffice = arrayOf<String>("Old Main 418A", "Old Main 420", "Old Main 402A",
            "Old Main 429", "Old Main 401B", "Old Main 418", "Old Main 402F", "Old Main 402B",
            "Old Main 426", "Old Main 401E")
        val facultyMembers = (0 until 10).map {
            FacultyMember(facultyNames[it], facultyTitles[it], facultyOffice[it])
        }.toList()
        binding.facultyRecyclerView.adapter = FacultyAdapter(facultyMembers)
        binding.facultyRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }
}