package com.example.steblinatetiana.lesson5.usergithubrepo.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.steblinatetiana.lesson5.usergithubrepo.R
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.RepoViewModel

class RepoInfoFragment : Fragment() {

    companion object {
        fun newInstance() = RepoInfoFragment()
    }

    private lateinit var infoViewModel: RepoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repo_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        infoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
