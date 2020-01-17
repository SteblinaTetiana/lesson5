package com.example.steblinatetiana.lesson5.usergithubrepo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.User
import com.example.steblinatetiana.lesson5.usergithubrepo.repository.Repository

class MainViewModel : ViewModel() {


    private val _username: MutableLiveData<String> = MutableLiveData()

    private val repository = Repository()

    val user: LiveData<User> = Transformations.switchMap(_username) { userId ->
        repository.getUser(userId)


    }


    val _name: MutableLiveData<String> = MutableLiveData()

    val name: LiveData<String>
        get() = _name


    private val _website: MutableLiveData<String> = MutableLiveData()

    val website: LiveData<String>
        get() = _website


    private val _bio: MutableLiveData<String> = MutableLiveData()

    val bio: LiveData<String>
        get() = _bio


    private val _image: MutableLiveData<String> = MutableLiveData()

    val image: LiveData<String>
        get() = _image


    private val _login: MutableLiveData<String> = MutableLiveData()

    val login: LiveData<String>
        get() = _login


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
