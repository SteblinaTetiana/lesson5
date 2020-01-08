package com.example.steblinatetiana.lesson5.usergithubrepo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "REPOS")
data class Repo (
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: Int,

    @ColumnInfo(name = "NAME")
    val name: String,

    @ColumnInfo(name = "DESCRIPTION")
    val description: String?,

    val htmlUrl: String?,
    val language: String?,
    val size: Int?,
    val createdAt: String?,
    val updatedAt: String?

): Serializable