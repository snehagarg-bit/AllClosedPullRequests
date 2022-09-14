package com.example.allclosedpullrequests.di

import com.example.allclosedpullrequests.api.ClosedPullRequestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {
    private val BASE_URL = "https://api.github.com/"

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun getPullRequestService(retrofit : Retrofit): ClosedPullRequestService {
        return retrofit.create(ClosedPullRequestService::class.java)
    }



}