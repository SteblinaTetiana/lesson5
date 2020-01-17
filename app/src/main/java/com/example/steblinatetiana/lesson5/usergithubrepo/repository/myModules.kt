package com.example.steblinatetiana.lesson5.usergithubrepo.repository

import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.MainViewModel
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.RepoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//koin module
val myModule = module {

    viewModel { MainViewModel() }
    viewModel { RepoViewModel() }
}