package com.geektech.relesson52

import android.app.Application
import com.geektech.relesson52.network.LoveApi
import com.geektech.relesson52.network.RetrofitService

class App : Application() {
    companion object {
        lateinit var loveApi: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        loveApi = retrofitService.getApi()
    }
}