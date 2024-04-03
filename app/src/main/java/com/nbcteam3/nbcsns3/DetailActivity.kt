package com.nbcteam3.nbcsns3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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


        //user.setImageDrawable(AppCompatResources.getDrawable(this, id))


        button.setOnClickListener {

           // val intent = Intent(this, MyPageActivity::class.Java)

          //  startActivity(intent)


        }



    }
}