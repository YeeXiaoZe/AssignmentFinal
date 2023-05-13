package com.example.assignment.database.selfDevelopment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

//Make it serializable so that it can be passed through the intent
@Entity(tableName = "chapter",
    foreignKeys = [ForeignKey(
        entity = ChapterModel::class,
        parentColumns = ["chapterID"],
        childColumns = ["chapterID"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class SubchapterModel(
    @PrimaryKey var subchapterID: String,
    var title: String,
    var content: String,
    var link: String,
    @ColumnInfo(name = "chapterID") val chapterID: String
) : Serializable