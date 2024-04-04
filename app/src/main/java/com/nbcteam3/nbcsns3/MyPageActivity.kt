package com.nbcteam3.nbcsns3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.widget.LinearLayout


class MyPageActivity : AppCompatActivity() {
    private val loadPosts = DummyServer.loadPosts()
    private val loadUsers = DummyServer.loadUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        val memo = findViewById<TextView>(R.id.memo)
        val name = findViewById<TextView>(R.id.name)
        val proFile = findViewById<ImageView>(R.id.profile)
        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        val inputID1 = findViewById<TextView>(R.id.inputId)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val inflater: LayoutInflater = LayoutInflater.from(this)
        val layout = findViewById<LinearLayout>(R.id.Post)

        val shared = getSharedPreferences("signInUser", MODE_PRIVATE)
        val userId = shared.getString("userId", "") ?: ""
        shared.getString("userPw", "")

        if (userId.isNotEmpty()) {

            val findUser = loadUsers.find { it.userId == userId }

            if (findUser != null) {

                inputID1.text = findUser.userId
                memo.text = findUser.memo
                name.text = findUser.name
                proFile.setImageResource(findUser.profileImageId)

                val findPost = loadPosts.filter { it.uid == findUser.uid }
                Log.d("MyPage",findPost.toString())
                findPost.forEach { foundPost ->

                    val view = inflater.inflate(R.layout.item_mypage, null)

                    view.findViewById<TextView>(R.id.inputId_2).text = foundPost.title
                    view.findViewById<TextView>(R.id.memo).text = foundPost.content
                    view.findViewById<ImageView>(R.id.imageView2)
                        .setImageDrawable(AppCompatResources.getDrawable(this, foundPost.imageId))

                    layout.addView(view)

                }


            }

        }

    }
}