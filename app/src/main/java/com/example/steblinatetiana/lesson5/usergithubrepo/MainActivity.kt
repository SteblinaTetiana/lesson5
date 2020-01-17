package com.example.steblinatetiana.lesson5.usergithubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.steblinatetiana.lesson5.usergithubrepo.fragments.RepoInfoFragment
import com.example.steblinatetiana.lesson5.usergithubrepo.fragments.ReposListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isLandscapeMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isLandscapeMode = container_info_fragment != null

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragment_container,
                    ReposListFragment.newInstance()
                )
                .commit()
        }


        if (container_info_fragment != null) {
            if (supportFragmentManager.backStackEntryCount > 0)
                supportFragmentManager.popBackStack()
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.container_info_fragment,
                    RepoInfoFragment.newInstance()
                )
                .commit()
        }

    }
}
