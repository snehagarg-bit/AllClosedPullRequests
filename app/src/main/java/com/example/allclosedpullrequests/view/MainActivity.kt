package com.example.allclosedpullrequests.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allclosedpullrequests.R
import com.example.allclosedpullrequests.adapter.ClosedPullRequestAdapter
import com.example.allclosedpullrequests.viewmodel.ClosedPullRequestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClosedPullRequestAdapter
    lateinit var viewModel: ClosedPullRequestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycleView()
        initViewModel()
    }

    private fun initRecycleView(){
        recyclerList.layoutManager = LinearLayoutManager(this)
        adapter = ClosedPullRequestAdapter()
        recyclerList.adapter = adapter
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(ClosedPullRequestViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer { pullRequestList->
            pullRequestList?.let {
                recyclerList.visibility = View.VISIBLE
                adapter.updatePullRequestList(it)

            }
        })

        viewModel.pullRequestLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    recyclerList.visibility = View.GONE
                }
            }
        })
        viewModel.makeApicall()
    }
}