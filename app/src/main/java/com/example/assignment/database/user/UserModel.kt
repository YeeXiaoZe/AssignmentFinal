package com.example.assignment.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel (
    @PrimaryKey var username: String = "",
    var contactInfo: String = "",
    var password: String = "",
    var role: String = "",
    var companyName: String = "",
)
