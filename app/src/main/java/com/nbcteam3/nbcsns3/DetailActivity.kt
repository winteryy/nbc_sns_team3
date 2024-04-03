package com.nbcteam3.nbcsns3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nbcteam3.nbcsns3.entity.Post
import com.nbcteam3.nbcsns3.entity.User

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val button = findViewById<Button>(R.id.setMainButton)
        val userimage = findViewById<ImageView>(R.id.setUserimage)
        val userid = findViewById<TextView>(R.id.setUserId)
        val username = findViewById<TextView>(R.id.setUserName)
        val storyImage = findViewById<ImageView>(R.id.setStory)
        val userstory = findViewById<TextView>(R.id.userStory)
        val storytitle = findViewById<TextView>(R.id.title)
        val usermemo = findViewById<TextView>(R.id.memo)

        val user = intent.getSerializableExtra(MainActivity.USER_DATA) as User
        val post = intent.getSerializableExtra(MainActivity.POST_DATA) as Post

        //post image id
        storyImage.setImageResource(post.imageId)
        userimage.setImageResource(user.profileImageId)
        username.setText(user.name)
        userid.setText(user.userId)
        userstory.setText(post.content)
        storytitle.setText(post.title)
        usermemo.setText(user.memo)



        button.setOnClickListener {
           val intent = Intent(this, MainActivity::class.java)

           startActivity(intent)


        }




    }
}