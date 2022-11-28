package com.a02363064.usucsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.a02363064.usucsapp.databinding.FragmentFacultyBinding
import com.a02363064.usucsapp.databinding.FragmentResearchBinding


data class researchTopic(
    val researchTopic: String,
    val researchDescription: String,
    val researchFaculty: String
)

class ResearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentResearchBinding.inflate(inflater, container, false)
        binding.GoToHomeFromResearch.setOnClickListener{
            findNavController().navigate(R.id.research_to_home)
        }
        binding.GoToFacultyFromResearch.setOnClickListener{
            findNavController().navigate(R.id.research_to_faculty)
        }

        val researchTopic = arrayOf<String>("Artificial Intelligence", "Algorithms", "Augmented " +
                "Virtual Reality", "Computer Science Education", "Computer Vision", "Cybersecurity",
                "Data Science and Data Mining", "Data Visualization and Visual Analytics", "Database" +
                " Systems", "High Performance Computing and Scientific Visualization", "Information " +
                "and Communication Technology for Development (ICT4D)", "Human Computer Interaction")

        val description = arrayOf<String>("Multi-agent systems, physics informed deep learning, " +
                "criticality in natural systems, automatic differentiation, deep neural networks, " +
                "AI for social impact, robotics, decision science, precision apiculture, precision " +
                "agriculture, assistive technology, PIV/PTV, and computability.", "Planning " +
                "algorithms, optimization algorithms, simulation, and computational geometry.",
                "3D user interfaces, human perception and cognition in VR and AR.", "Educational " +
                "data mining, keystroke analysis, and educational psychology.", "Computer vision, " +
                "pattern recognition, breast ultrasound (BUS) image processing, pavement crack " +
                "detection/classification, uncertainty theories & new logics, meta-learning, deep " +
                "learning for medical Information processing, medical image segmentation, deep " +
                "learning-based object detection & recognition, morphed face detection, graph-based" +
                " deep learning, and machine learning.", "Human aspects of security, and privacy " +
                "perceptions of users.", "Applied data mining for space weather research and pattern " +
                "discovery from large time series data, social network analysis, graph mining, social" +
                " media mining, educational data mining, machine learning, deep learning, " +
                "representation learning of graphs and multivariate time series, ML " +
                "cyberinfrastructure development, deep learning and its applications in anomaly " +
                "detection, and natural language processing.", "Decision-making and sense making, " +
                "user behavior analytics, text analytics, and data analytics.", "Temporal databases," +
                " hierarchical databases, and biodiversity databases.", "Big data analysis and " +
                "visualization, distributed and parallel computing, topological analysis, " +
                "cyberinfrastructure, cloud computing, and simulation visualization.", "Usability " +
                "issues and privacy concerns around digital technology use in developing countries.",
                "User behavior and challenges in technology use and corresponding workarounds, " +
                "virtual reality, augmented reality, and 3D user interfaces.")

        val researchFaculty = arrayOf<String>("Vicki Allan, Nick Flann, Hamid Karimi, Mario Harper, " +
                "and Vladimir Kulyukin", "John Edwards, Mario Harper, and Haitao Wang", "Isaac Cho",
                "John Edwards", "Hengda Cheng and Xiaojun Qi", "Mahdi Nasrullah Al-Ameen", "Soukaina" +
                " Filali Boubrahimi, Hamid Karimi, Shah Muhammad Hamdi, and Shuhan Yuan", "Isaac " +
                "Cho", "Curtis Dyreson", "John Edwards and Steve Petruzza", "Mahdi Nasrullah " +
                "Al-Ameen", "Mahdi Nasrullah Al-Ameen, Isaac Cho")

        val facultyMembers = (0 until 12).map {
            FacultyMember(researchTopic[it], description[it], "Faculty: " +
                    researchFaculty[it])
        }.toList()
        binding.researchRecyclerView.adapter = FacultyAdapter(facultyMembers)
        binding.researchRecyclerView.layoutManager = LinearLayoutManager(this.context)

        return binding.root
    }
}