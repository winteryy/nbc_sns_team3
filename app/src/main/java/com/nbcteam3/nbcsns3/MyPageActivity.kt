package com.nbcteam3.nbcsns3

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MyPageActivity : AppCompatActivity() {
    private val loadPosts = DummyServer.loadPosts()
    private val loadUsers = DummyServer.loadUsers()

    private lateinit var innerLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val memo = findViewById<TextView>(R.id.memo)
        val name = findViewById<TextView>(R.id.name)
        val profile = findViewById<ImageView>(R.id.profile)
        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        val inputID1 = findViewById<TextView>(R.id.inputId)

        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        }

        innerLayout = findViewById(R.id.Post)

        val shared = getSharedPreferences("signInUser", MODE_PRIVATE)
        val userId = shared.getString("userId", "") ?: ""

        if (userId.isNotEmpty()) {
            val findUser = loadUsers.find { it.userId == userId }

            if (findUser != null) {

                inputID1.text = findUser.userId
                memo.text = findUser.memo
                name.text = findUser.name
                profile.setImageResource(findUser.profileImageId)

                val postList = loadPosts.filter { it.uid == findUser.uid }
                postList.forEach { foundPost ->
                    val view = LayoutInflater.from(this).inflate(R.layout.item_mypage, innerLayout, false)

                    view.findViewById<TextView>(R.id.inputId_2).text = foundPost.title
                    view.findViewById<TextView>(R.id.memo).text = foundPost.content
                    view.findViewById<ImageView>(R.id.imageView2).setImageResource(foundPost.imageId)

                    innerLayout.addView(view)
                }
            }
        }
    }
}