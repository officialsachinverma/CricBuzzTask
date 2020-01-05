package com.project100pi.cricbuzztask.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sachin Verma on 2020-01-03.
 */
data class Source(@SerializedName("id")
                  var id: String,
                  @SerializedName("name")
                  var name: String)