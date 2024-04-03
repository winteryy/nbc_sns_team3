package com.nbcteam3.nbcsns3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val memo = findViewById<TextView>(R.id.memo)
        val name = findViewById<TextView>(R.id.name)
        val proFile = findViewById<ImageView>(R.id.profile)
        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        val edit = findViewById<Button>(R.id.edit)
        val inputID1 = findViewById<TextView>(R.id.inputId)


        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val inflater : LayoutInflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.item_mypage,null)
        val layout = findViewById<LinearLayout>(R.id.Post)

        val shared = getSharedPreferences("signInUser", MODE_PRIVATE)
        val userId = shared.getString("userId", "") ?: ""
        shared.getString("userPw", "")

        if (userId.isNotEmpty()) {

            inputID1.text = userId

            val findUser = loadUsers.find { it.userId == userId }
            memo.text = findUser?.memo
            name.text = findUser?.name
            if (findUser != null) {
                proFile.setImageDrawable(AppCompatResources.getDrawable(this,findUser.profileImageId))
            }


            if (findUser != null) {

                val findPost = loadPosts.filter { it.uid == findUser.uid }
                findPost.forEach{foundPost ->
                    view.findViewById<TextView>(R.id.inputID_2).text = findUser.userId
                    view.findViewById<TextView>(R.id.input).text = foundPost.content
                    view.findViewById<ImageView>(R.id.profile2).setImageDrawable(AppCompatResources.getDrawable(this,foundPost.imageId))
                    view.findViewById<ImageView>(R.id.imageView2).setImageDrawable(AppCompatResources.getDrawable(this,foundPost.imageId))
                }
                layout.addView(view)
            }
        }
    }
}