package com.example.assignment.database.company

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyModel (
    @PrimaryKey var username: String = "",
    var companyName: String = "",
)
