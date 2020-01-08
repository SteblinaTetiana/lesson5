package com.example.steblinatetiana.lesson5.usergithubrepo.repository

import androidx.lifecycle.LiveData
import com.example.steblinatetiana.lesson5.usergithubrepo.db.GithubDb
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.User
import com.example.steblinatetiana.lesson5.usergithubrepo.service.ApiManager
import kotlinx.coroutines.*

class Repository /*private constructor(
   *//* private val db: GithubDb,
    private val service: ApiManager.GithubService*//*
   *//* private val netManager: NetworkManager*//*
)*/ {

    var job: CompletableJob? = null

    fun getUser(username: String): LiveData<User> {
        job = Job()

        return object : LiveData<User>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {

                        //fetch data from web service here
                        val user = ApiManager.GithubService().getGithubUser(username)
                        withContext(Dispatchers.Main) {
                            value = user
                            theJob.complete()
                        }

                    }
                }
            }
        }


    }
    fun getRepo(username: String): LiveData<List<Repo>> {
        job = Job()

        return object : LiveData<List<Repo>>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {

                        //fetch data from web service here
                        val repo =  ApiManager.GithubService().getGithubRepo(username)
                        withContext(Dispatchers.Main) {

                            value = repo
                            theJob.complete()
                        }
                    }
                }
            }
        }


    }


    //cancel the job
    fun cancelJob() {
        job?.cancel()
    }

}

