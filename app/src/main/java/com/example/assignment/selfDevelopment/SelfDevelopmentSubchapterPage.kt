package com.example.assignment.selfDevelopment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.SelfDevChapterAdapter
import com.example.assignment.Validation
import com.example.assignment.database.selfDevelopment.ChapterSQLiteHelper
import com.example.assignment.database.selfDevelopment.SubchapterModel
import com.example.assignment.databinding.SelfDevelopmentSubchapterPageBinding
import java.io.Serializable

class SelfDevelopmentSubchapterPage : AppCompatActivity() {
    //Set binding variables
    lateinit var binding: SelfDevelopmentSubchapterPageBinding

    //Use validation methods
    private lateinit var validation: Validation

    //Use SQL helper
    private lateinit var sqliteHelper: ChapterSQLiteHelper

    private lateinit var chapterAdapter: SelfDevChapterAdapter
    private lateinit var chapterList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelfDevelopmentSubchapterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieve the subchapter records
        val subchapterList = intent.getSerializableExtra("subchapterList")
        var position = 0

        if (subchapterList != null) {
            Log.i("Main Activity", "Reached here yay")

            //Log.i("Main Activity", "$subchapterList")
            setContent(subchapterList, position)
        }

        binding.backButton.setOnClickListener()
        {
            position--
            setContent(subchapterList, position)

            /*
            startActivity(
                Intent(
                this,
                SelfDevelopmentMainPage::class.java
            )

            */
        }

        binding.forwardButton.setOnClickListener()
        {
            position++
            setContent(subchapterList, position)
        }
    }

    private fun setContent(serializable: Serializable?, position: Int) {
        val subchapterList = serializable as? ArrayList<SubchapterModel>

        //Decide to whether proceed to content setting
        if (!changePage(subchapterList, position))
        {
            return
        }

        binding.selfDevTitle.text = subchapterList?.get(position)?.title
        binding.selfDevContent.text = subchapterList?.get(position)?.content
        binding.selfDevLink.text = subchapterList?.get(position)?.link

        binding.selfDevLink.setOnClickListener{
            Log.i("Main Activity", "Try")
            if (!subchapterList?.get(position)?.link.isNullOrEmpty()) {
                addLink(subchapterList?.get(position)?.link)
            }
        }
    }

    private fun changePage(subchapterList: ArrayList<SubchapterModel>?, position: Int): Boolean
    {
        Log.i("Main Activity", "Reach here?")

        if (position == -1)
        {
            startActivity(
                Intent(
                    this,
                    SelfDevelopmentMainPage::class.java
                )
            )

            return false
        }
        else if (position == subchapterList?.size)
        {
            startActivity(
                Intent(
                    this,
                    SelfDevelopmentMainPage::class.java
                )
            )

            return false
        }

        return true
    }

    private fun addLink(link: String?)
    {
        Log.i("Main Activity", "Try")
        //Intent for web search
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }
}