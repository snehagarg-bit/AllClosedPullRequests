package com.example.allclosedpullrequests.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.allclosedpullrequests.R
import com.example.allclosedpullrequests.models.ClosedPullRequest
import com.example.allclosedpullrequests.utils.getProgressDrawable
import com.example.allclosedpullrequests.utils.loadImage
import kotlinx.android.synthetic.main.list_item.view.*

class ClosedPullRequestAdapter :
    RecyclerView.Adapter<ClosedPullRequestAdapter.PullRequestViewHolder>() {

    private var pullRequest: List<ClosedPullRequest>? = null

    fun updatePullRequestList(pullRequest: List<ClosedPullRequest>) {
         this.pullRequest = pullRequest
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = PullRequestViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    )

    override fun getItemCount() :Int{
        if(pullRequest == null)return 0
        else return pullRequest?.size!!
    }

    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bind(pullRequest?.get(position)!!)
    }

    class PullRequestViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title = view.title
        private val created_date = view.created_date
        private val closed_date = view.closed_date
        private val imageView = view.imageView
        private val username = view.user
        private val progressDrawable = getProgressDrawable(view.context)



        fun bind(pullRequest: ClosedPullRequest) {
            title.text = pullRequest.title
            created_date.text = pullRequest.created_date
            closed_date.text = pullRequest.closed_date
            username.text = pullRequest.user.name
            imageView.loadImage(pullRequest.user.avatar_url, progressDrawable)
        }
    }
}