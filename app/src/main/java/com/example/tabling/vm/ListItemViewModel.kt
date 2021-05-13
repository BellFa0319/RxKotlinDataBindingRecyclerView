package com.example.tabling.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tabling.model.ListItem
import com.example.tabling.repository.ListItemRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListItemViewModel : ViewModel() {
    val repository = ListItemRepository()
    private val listItem = repository.getListItem()

    fun getListItem(): LiveData<List<ListItem>> {
        return listItem
    }

    fun getListItemRx(): Observable<List<ListItem>> =
        repository.getListItemRx().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}