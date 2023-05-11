package com.example.assignment.database.selfDevelopment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "question",
    foreignKeys = [ForeignKey(
        entity = ChapterModel::class,
        parentColumns = ["chapterID"],
        childColumns = ["chapterID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class QuizModel(
    @PrimaryKey val quizID: String,
    @ColumnInfo(name = "chapterID") val chapterID: String
)