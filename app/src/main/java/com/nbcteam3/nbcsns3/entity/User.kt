package com.nbcteam3.nbcsns3.entity

data class User(
    val uid: Int,
    val userId: String,
    val password: String,
    val name :Int,
    val title:String,
    val memo: String,
    val profileImageId: Int
)
