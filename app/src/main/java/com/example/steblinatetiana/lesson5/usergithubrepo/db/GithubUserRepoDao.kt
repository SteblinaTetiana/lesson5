package com.example.steblinatetiana.lesson5.usergithubrepo.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.User

@Dao
abstract class GithubUserRepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(repo: Repo)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: User)


    @Transaction
    @Query("SELECT * FROM user WHERE login = :login")
    abstract suspend fun findByLogin(login: String): LiveData<User>

    @Transaction
    @Query("SELECT * FROM user")
    abstract suspend fun getAllSavedUsers(): List<GitUserWithRepo>

    @Query("DELETE FROM user WHERE login = :login")
    abstract suspend fun deleteUser(login: String)

    @Query("DELETE FROM repo WHERE login = :login")
    abstract suspend fun deleteRepos(login: String)

    @Transaction
    suspend fun delete(login: String) {
        deleteUser(login)
        deleteRepos(login)
    }


    data class GitUserWithRepo(
        @Embedded val user: User,
        @Relation(
            parentColumn = "login",
            entity = Repo::class,
            entityColumn = "login"
        )
        val repos: List<Repo>
    ) {
        fun toLiveData() = MutableLiveData<GitUserWithRepo>(this) as LiveData<GitUserWithRepo>
    }
}