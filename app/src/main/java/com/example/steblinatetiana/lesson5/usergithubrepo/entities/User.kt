package com.example.steblinatetiana.lesson5.usergithubrepo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "USERS")
data class User (
    @PrimaryKey
    @ColumnInfo(name = "LOGIN")
    val login: String,

    @ColumnInfo(name = "NAME")
    val name: String,

    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val followers: Int,
    val following: Int,
    val createdAt: String,
    val updatedAt: String,

    @ColumnInfo(name = "ID")
    val id: Long,

    @ColumnInfo(name = "AVATARURL")
    val avatarUrl: String?,

    @ColumnInfo(name = "REPOSURL")
    val reposUrl: String?
): Serializable