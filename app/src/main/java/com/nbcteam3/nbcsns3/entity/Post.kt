package com.nbcteam3.nbcsns3.entity

data class Post(
    val postId: String,
    val uid: String,
    val imageId: Int,
    val title: String,
    val content: String,
    val dateTime: Long
)
