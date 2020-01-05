package com.project100pi.cricbuzztask.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sachin Verma on 2020-01-03.
 */

object APIClient {

    private var retrofit: Retrofit? = null

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getClient() = retrofit

}