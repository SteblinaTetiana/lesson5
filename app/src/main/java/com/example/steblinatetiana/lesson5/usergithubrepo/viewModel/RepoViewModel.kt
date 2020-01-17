package com.example.steblinatetiana.lesson5.usergithubrepo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.repository.Repository

class RepoViewModel : ViewModel() {

    private val repository = Repository()

    private val _username: MutableLiveData<String> = MutableLiveData()

    val repos: LiveData<List<Repo>> = Transformations.switchMap(_username) { userId ->
        repository.getRepo(userId)


    }


    fun setUsername(userId: String) {
        if (_username.value == userId) {
            return
        }
        _username.value = userId

    }


    fun cancelJob() {
        repository.cancelJob()
    }


}
