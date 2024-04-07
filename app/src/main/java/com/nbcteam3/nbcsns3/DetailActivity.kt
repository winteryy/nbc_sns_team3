package com.nbcteam3.nbcsns3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nbcteam3.nbcsns3.entity.Post
import com.nbcteam3.nbcsns3.entity.User
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val backButton = findViewById<ImageView>(R.id.setMainButton)
        val userimage = findViewById<ImageView>(R.id.setUserimage)
        val userid = findViewById<TextView>(R.id.setUserId)
        val username = findViewById<TextView>(R.id.setUserName)
        val storyImage = findViewById<ImageView>(R.id.setStory)
        val userstory = findViewById<TextView>(R.id.userStory)
        val storytitle = findViewById<TextView>(R.id.title)
        val usermemo = findViewById<TextView>(R.id.memo)
        val moreMemo = findViewById<TextView>(R.id.showMore)
        var isExpanded = false

        val user = intent.getSerializableExtra(MainActivity.USER_DATA) as User
        val post = intent.getSerializableExtra(MainActivity.POST_DATA) as Post


        usermemo.post {
            if (usermemo.layout.lineCount >= 3) {
                moreMemo.visibility = View.VISIBLE
            }
        }

        storyImage.setImageResource(post.imageId)
        userimage.setImageResource(user.profileImageId)
        username.setText(user.name)
        userid.setText(user.userId)
        userstory.setText(post.content)
        storytitle.setText(post.title)
        usermemo.setText(user.memo)


        backButton.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
        }
        moreMemo.setOnClickListener {


            if (isExpanded) {
                isExpanded = false
                usermemo.maxLines = 2
            } else {
                isExpanded = true
                usermemo.maxLines = Int.MAX_VALUE
            }
        }
    }
}