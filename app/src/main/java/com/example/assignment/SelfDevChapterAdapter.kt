package com.example.assignment

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.database.selfDevelopment.ChapterSQLiteHelper
import com.example.assignment.database.selfDevelopment.SubchapterSQLiteHelper
import com.example.assignment.selfDevelopment.SelfDevelopmentSubchapterPage

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

        holder.chapterTitle.setOnClickListener {
            //Get the record of all subchapters associated to a chapter
            val subchapterList = subchapterHelper.getRecords(subchapterHelper.conditionalGetAttribute("chapterID", "chapterID",
                chapterHelper.conditionalGetAttribute("chapterID", "title", currentItem)))

            //If subchapter is not null
            if (subchapterList != null) {

                Log.i("Main Activity", "$subchapterList")
                //Intent of the subchapter page
                val intent = Intent(context, SelfDevelopmentSubchapterPage::class.java)
                intent.putExtra("subchapterList", subchapterList)
                context.startActivity(intent)

            } else {
                errorAlertDialog()
            }
        }
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chapterTitle: Button = itemView.findViewById(R.id.button)
    }

    private fun errorAlertDialog() {
        val alert = AlertDialog.Builder(context)
        alert.setMessage("An error has occurred. Please check later.")
        alert.setPositiveButton("OK") { _, _ -> }
        val dialog = alert.create()
        // Disable touch outside to dismiss dialog
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}