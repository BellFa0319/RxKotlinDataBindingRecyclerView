package com.example.tabling.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tabling.api.ItemService
import com.example.tabling.model.ListItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListItemRepository {
    private val itemClient = ItemService.client

    fun getListItem(): LiveData<List<ListItem>> {
        val data = MutableLiveData<List<ListItem>>()
        itemClient.getItemList().enqueue(object : Callback<List<ListItem>> {
            override fun onFailure(call: Call<List<ListItem>>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(
                call: Call<List<ListItem>>,
                response: Response<List<ListItem>>
            ) {
                data.value = response.body()!!
            }

        })

        return data
    }

    fun getListItemRx() : Observable<List<ListItem>> =
        itemClient.getItemListRx()

}