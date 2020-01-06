package com.project.cricbuzztask.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Sachin Verma on 2020-01-03.
 */

data class News(@SerializedName("source")
                var source: Source,
                @SerializedName("author")
                var author: String,
                @SerializedName("title")
                var title: String,
                @SerializedName("description")
                var description: String,
                @SerializedName("url")
                var url: String,
                @SerializedName("urlToImage")
                var urlToImage: String,
                @SerializedName("publishedAt")
                var publishedAt: String,
                @SerializedName("content")
                var content: String)