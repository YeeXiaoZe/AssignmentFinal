package com.example.assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class SelfDevChapterAdapter(private val chapterList: ArrayList<String>) :
    RecyclerView.Adapter<SelfDevChapterAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_chapter, parent, false)
        return ChapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val currentItem = chapterList[position]
        holder.chapterTitle.text = currentItem
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chapterTitle: Button = itemView.findViewById(R.id.button)
    }
}