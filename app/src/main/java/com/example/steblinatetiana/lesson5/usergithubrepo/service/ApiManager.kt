package com.example.steblinatetiana.lesson5.usergithubrepo.service

import com.example.steblinatetiana.lesson5.usergithubrepo.BuildConfig
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class ApiManager  {


    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val okHttpClient = OkHttpClient.Builder()
        .protocols(listOf(Protocol.HTTP_1_1))
        .build()


    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()


    private val service: GithubService = retrofit.create(GithubService::class.java)

    fun getGithubRepo(username: String): List<Repo> {
        return service.getRepo(username)
    }

    fun getGithubUser(username: String): User {
        return service.getUser(username)
    }



    interface GithubService {
        @GET("/users/{username}")
        fun getRepo(
            @Path("username") username: String
        ): List<Repo>

        @GET("/users/{username}/repos")
        fun getUser(
            @Path("username") username:String
        ): User

    }
}


