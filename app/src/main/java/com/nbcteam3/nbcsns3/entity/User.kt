package com.nbcteam3.nbcsns3.entity

import java.io.Serializable

data class User(
    val uid: String,
    val userId: String,
    val password: String,
    val name: String,
    val memo: String,
    val profileImageId: Int
): Serializable
