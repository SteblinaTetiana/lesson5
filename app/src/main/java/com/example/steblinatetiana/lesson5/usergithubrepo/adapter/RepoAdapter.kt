package com.example.steblinatetiana.lesson5.usergithubrepo.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.steblinatetiana.lesson5.usergithubrepo.R
import com.example.steblinatetiana.lesson5.usergithubrepo.entities.Repo
import kotlinx.android.synthetic.main.repo_list_item.view.*

class RepoAdapter(var repoList: List<Repo>/*, private val clickListener: OnItemClickListener*/) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {


/*    interface OnItemClickListener {
        fun onClick(repo: Repo)
    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repo_list_item, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = this.repoList[position]
        /*holder.bind(repo)*/

        holder.txtRepoName.text = repo.name
        holder.txtRepoDesc.text = repo.description

        holder.btnReposUrl.setOnClickListener {
            val browser =
                Intent(Intent.ACTION_VIEW, Uri.parse(repo.htmlUrl))
            it.context.startActivity(browser)

        }
    }

    inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)/*,
    View.OnClickListener*/ {

        /* init {
             itemView.btn_repos_url.setOnClickListener(this)
         }

         fun bind(repo: Repo) {
             itemView.txt_repo_name.text = repo.name
             itemView.txt_repo_desc.text = repo.description
         }

             btn_repos_url.setOnClickListener
             override fun onClick(v: View?) {
                 val browser =
                     Intent(Intent.ACTION_VIEW, Uri.parse(repo.htmlUrl))
                 it.context.startActivity(browser)

             }
     */
        val txtRepoName: TextView = itemView.txt_repo_name
        val txtRepoDesc: TextView = itemView.txt_repo_desc
        val btnReposUrl: Button = itemView.btn_repos_url


    }
}


