package com.project.cricbuzztask.network

import com.project.cricbuzztask.utils.Constants
import com.project.cricbuzztask.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Sachin Verma on 2020-01-03.
 */
interface APIInterface {

    @GET(Constants.apiNewsList)
    fun doGetNewsList(@QueryMap params: Map<String, String>): Call<Response>

}