package com.example.allclosedpullrequests.view

import android.app.Application
import com.example.allclosedpullrequests.di.DaggerRetroComponent
import com.example.allclosedpullrequests.di.RetroComponent
import com.example.allclosedpullrequests.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder().retroModule(RetroModule()).build()
    }

     fun getRetroComponent() :RetroComponent{
         return retroComponent
     }
}