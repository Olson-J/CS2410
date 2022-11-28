package com.a02363064.usucsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.a02363064.usucsapp.R
import com.a02363064.usucsapp.databinding.FragmentFacultyBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val listBinding = FragmentFacultyBinding.inflate(layoutInflater)
//        val facultyMembers = (0 until 11).map {
//            FacultyMember("Member ${it}", "${it}", "$it")
//        }.toList()
//        listBinding.facultyRecyclerView.adapter = FacultyAdapter(facultyMembers)
//        listBinding.facultyRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        setContentView(listBinding.root)
    }
}