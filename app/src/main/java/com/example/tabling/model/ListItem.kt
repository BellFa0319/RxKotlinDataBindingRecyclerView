package com.example.tabling.model

import com.google.gson.annotations.SerializedName

open class ListItem{
    @SerializedName("author")
    public var author : String? = null
    @SerializedName("id")
    public var id : String? = null
    @SerializedName("download_url")
    public var downloadUrl : String? = null
}