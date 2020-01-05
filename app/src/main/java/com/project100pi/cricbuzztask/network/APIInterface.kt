package com.project100pi.cricbuzztask.network

import com.project100pi.cricbuzztask.Utils.Constants
import com.project100pi.cricbuzztask.model.Response
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Sachin Verma on 2020-01-03.
 */
interface APIInterface {

    @GET(Constants.apiNewsList)
    fun doGetNewsList(): Call<Response>

}