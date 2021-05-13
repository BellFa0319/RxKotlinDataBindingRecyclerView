package com.example.tabling.api

import com.example.tabling.model.ListItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


//https://picsum.photos/v2/list
interface ItemApi {
    @GET("/v2/list")
    fun getItemList(): Call<List<ListItem>>

    @GET("/v2/list")
    fun getItemListRx(): Observable<List<ListItem>>
}