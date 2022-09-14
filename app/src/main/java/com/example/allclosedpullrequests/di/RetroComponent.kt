package com.example.allclosedpullrequests.di

import com.example.allclosedpullrequests.viewmodel.ClosedPullRequestViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(viewModel: ClosedPullRequestViewModel)
}