package com.example.allclosedpullrequests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.allclosedpullrequests.view.MyApplication
import com.example.allclosedpullrequests.api.ClosedPullRequestService
import com.example.allclosedpullrequests.models.ClosedPullRequest
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

class ClosedPullRequestViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var service: ClosedPullRequestService

    val  pullRequestLoadError = MutableLiveData<Boolean>()
    var closedpullRequestList = MutableLiveData<List<ClosedPullRequest>?>()
    val loading = MutableLiveData<Boolean>()

    init{
        (application as MyApplication).getRetroComponent().inject(this)
        closedpullRequestList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<ClosedPullRequest>?> {
        return closedpullRequestList
    }

    fun makeApicall() {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<List<ClosedPullRequest>> = service.getPullRequest()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    closedpullRequestList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }
    private fun onError(message: String) {
        pullRequestLoadError.value = true
        loading.value = false
    }




}