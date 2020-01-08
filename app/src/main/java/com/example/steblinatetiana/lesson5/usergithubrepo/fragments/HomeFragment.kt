package com.example.steblinatetiana.lesson5.usergithubrepo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.example.steblinatetiana.lesson5.usergithubrepo.R
import com.example.steblinatetiana.lesson5.usergithubrepo.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    private var name: String? = null
    private var bio: String? = null
    private var image: String? = null
    private var blog: String? = null
    private var login: String? = null
   /* private var listener: OnFragmentInteractionListener? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1)
            bio = it.getString(ARG_PARAM2)
            image = it.getString(ARG_PARAM2)
            blog = it.getString(ARG_PARAM2)
            login = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            println("DEBUG : ${user}")
            name = user.name
            bio = user.bio
            image = user.avatarUrl
            blog = user.blog
            login = user.login

            progressbar.visibility = View.GONE

            if (name != null && bio != null && image != null && blog != null && login != null) {
                val bundle = bundleOf(
                    "name" to name,
                    "bio" to bio,
                    "image" to image, "website" to blog, "login" to login
                )

                println("LOGIN ${user.login}")
                println("LOGIN $bundle")
                //navigate to details fragment with bundle




            }
        })



        btn_generate.setOnClickListener {

            if (edt_user_name.text.toString().trim().isNotEmpty()) {

                progressbar.visibility = View.VISIBLE

                viewModel.setUsername(edt_user_name.text.toString())


            } else {
                Toast.makeText(
                    activity,
                    getString(R.string.error_fill_username),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }


}




