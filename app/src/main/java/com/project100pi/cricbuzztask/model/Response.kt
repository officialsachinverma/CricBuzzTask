package com.project100pi.cricbuzztask.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sachin Verma on 2020-01-03.
 */
data class Response(@SerializedName("status")
                    var status: String,
                    @SerializedName("totalResults")
                    var totalResults: Int,
                    @SerializedName("articles")
                    var articles: List<News>)