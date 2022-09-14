package com.example.allclosedpullrequests.api

import com.example.allclosedpullrequests.models.ClosedPullRequest
import retrofit2.Response
import retrofit2.http.GET


interface ClosedPullRequestService {

    @GET("repos/snehagarg-bit/AllClosedPullRequests/pulls?state=closed")
     suspend fun getPullRequest(): Response<List<ClosedPullRequest>>

}