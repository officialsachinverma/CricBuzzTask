package com.project100pi.cricbuzztask.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.project100pi.cricbuzztask.model.Response
import com.project100pi.cricbuzztask.network.APIClient
import com.project100pi.cricbuzztask.network.APIInterface
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Sachin Verma on 2020-01-03.
 */

class MainViewModel : ViewModel() {

    var apiInterface: APIInterface? = null

    private val callback = object : Callback<Response> {

        override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {

        }

        override fun onFailure(call: Call<Response>, t: Throwable) {

        }
    }

    init {
        loadData()
    }

    fun loadData () {
        apiInterface = APIClient.getClient()!!.create(APIInterface::class.java)

        val call: Call<Response> = apiInterface!!.doGetNewsList()
        call.enqueue(callback)
    }



}