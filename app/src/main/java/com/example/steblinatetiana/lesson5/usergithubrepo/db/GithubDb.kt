package com.example.steblinatetiana.lesson5.usergithubrepo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.User

@Database(entities = [User::class, Repo::class], version = 1, exportSchema = true)

abstract class GithubDb: RoomDatabase() {
    abstract fun githubUserRepoDao(): GithubUserRepoDao


    companion object {

        @Volatile
        private var INSTANCE: GithubDb? = null

        fun database(context: Context): GithubDb =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: Room.databaseBuilder(
                            context.applicationContext,
                            GithubDb::class.java,
                            "github_user.db"
                        )
                            .build()
                            .also {
                                INSTANCE = it
                            }
                }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}