package com.example.assignment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.database.selfDevelopment.ChapterSQLiteHelper
import com.example.assignment.database.selfDevelopment.SubchapterSQLiteHelper

class SelfDevChapterAdapter(private val context: Context, private val chapterList: ArrayList<String>) :
    RecyclerView.Adapter<SelfDevChapterAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_chapter, parent, false)
        return ChapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val currentItem = chapterList[position]
        holder.chapterTitle.text = currentItem

        val chapterHelper = ChapterSQLiteHelper(context)
        val subchapterHelper = SubchapterSQLiteHelper(context)

        holder.chapterTitle.setOnClickListener()
        {
            Log.i("Main Activity", subchapterHelper.conditionalGetAttribute("subchapterID", "chapterID",
                chapterHelper.conditionalGetAttribute("chapterID", "title", currentItem)))
        }
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chapterTitle: Button = itemView.findViewById(R.id.button)
    }
}