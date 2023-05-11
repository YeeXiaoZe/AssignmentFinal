package com.example.assignment.selfDevelopment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.SelfDevChapterAdapter
import com.example.assignment.Validation
import com.example.assignment.database.selfDevelopment.ChapterSQLiteHelper
import com.example.assignment.databinding.SelfDevelopmentMainPageBinding

class SelfDevelopmentMainPage : AppCompatActivity() {
    //Set binding variables
    private lateinit var binding: SelfDevelopmentMainPageBinding

    //Use validation methods
    private lateinit var validation: Validation

    //Use SQL helper
    private lateinit var sqliteHelper: ChapterSQLiteHelper

    private lateinit var chapterAdapter: SelfDevChapterAdapter
    private lateinit var chapterList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initialization
        binding = SelfDevelopmentMainPageBinding.inflate(layoutInflater)
        validation = Validation()
        setContentView(binding.root)

        sqliteHelper = ChapterSQLiteHelper(this)
        recyclerViewInit()

        binding.logoNavigation.setOnClickListener()
        {
            Log.i("Main Activity", "Button onclick worked")
        }
    }

    private fun recyclerViewInit() {
        binding.selfDevChapter.layoutManager = LinearLayoutManager(this)
        chapterList = sqliteHelper.getAttribute("title")

        chapterAdapter = SelfDevChapterAdapter(chapterList)
        binding.selfDevChapter.adapter = chapterAdapter
    }
}