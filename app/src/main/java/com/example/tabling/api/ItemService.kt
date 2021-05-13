package com.example.tabling.api

object ItemService {
    private const val BASEURL = "https://picsum.photos"

    val client = ApiService().getCl(BASEURL).create(ItemApi::class.java)

}