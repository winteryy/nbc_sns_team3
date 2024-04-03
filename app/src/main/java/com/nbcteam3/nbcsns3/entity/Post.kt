package com.nbcteam3.nbcsns3.entity

import java.io.Serializable

data class Post(
    val postId: String,
    val uid: String,
    val imageId: Int,
    val title: String,
    val content: String,
    val dateTime: Long
): Serializable
