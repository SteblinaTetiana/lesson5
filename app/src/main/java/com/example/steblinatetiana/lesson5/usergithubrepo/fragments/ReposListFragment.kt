package com.example.steblinatetiana.lesson5.usergithubrepo.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.steblinatetiana.lesson5.usergithubrepo.R
import com.example.steblinatetiana.lesson5.usergithubrepo.adapter.RepoAdapter
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.MainViewModel
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.RepoViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ReposListFragment : Fragment() {

    lateinit var repoAdapter: RepoAdapter

    private val viewModel: RepoViewModel by viewModel()


    private var login: String? = null





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        viewModel.getRepo().observe(this, Observer<List<Repo>>{ repos ->
            // update UI
        })
    }

    companion object {
        fun newInstance() = ReposListFragment()
    }
}
