package com.a02363064.usucsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.usucsapp.databinding.ResearchTopicItemBinding

class ResearchAdapter (val topic: List<researchTopic>): RecyclerView.Adapter<ResearchAdapter.ViewHolder>() {

    class ViewHolder(val binding: ResearchTopicItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ResearchTopicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val researchTopic = topic[position]
        holder.binding.topicTextView.text = researchTopic.researchTopic
        holder.binding.descriptionTextView.text = researchTopic.researchDescription
        holder.binding.researchNamesTextView.text = researchTopic.researchFaculty
    }

    override fun getItemCount(): Int {
        return topic.size
    }
}