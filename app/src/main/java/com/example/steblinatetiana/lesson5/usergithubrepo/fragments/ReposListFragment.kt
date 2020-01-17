package com.example.steblinatetiana.lesson5.usergithubrepo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.steblinatetiana.lesson5.usergithubrepo.R
import com.example.steblinatetiana.lesson5.usergithubrepo.adapter.RepoAdapter
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.RepoViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ReposListFragment : Fragment() {

    private lateinit var repoAdapter: RepoAdapter
    private var repoList: List<Repo>? = null
    private val viewModel: RepoViewModel by viewModel()


    private var login: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        login = arguments!!.getString("login")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val progressbar = view.findViewById<ProgressBar>(R.id.progressbar)

        progressbar.visibility = View.VISIBLE
        viewModel.repos.observe(this, Observer<List<Repo>> { repos ->

            repoAdapter = RepoAdapter(repoList)
            recyclerView.apply {
                adapter = repoAdapter
                layoutManager = LinearLayoutManager(activity)
            }
            progressbar.visibility = View.GONE
        })

        viewModel.setUsername(login!!)
}

/*override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    *//*viewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)*//*
    viewModel.repos.observe(this, Observer<List<Repo>> { repos ->
        // update UI
    })
}*/
override fun onDestroy() {
    super.onDestroy()
    viewModel.cancelJob()
}

companion object {
    fun newInstance() = ReposListFragment()
}
}
