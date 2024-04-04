package com.nbcteam3.nbcsns3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.helper.widget.Flow
import com.nbcteam3.nbcsns3.entity.Post
import com.nbcteam3.nbcsns3.entity.User
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity: AppCompatActivity() {
    private lateinit var innerLayout: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        innerLayout = findViewById(R.id.contentLayout)
        val posts = DummyServer.loadPosts()
        val users = DummyServer.loadUsers()
        val uidMap = users.associateBy { it.uid }

        setListener()

        posts.forEach {
            val writer = uidMap[it.uid]!!
            innerLayout.addView(
                cardBinder(it, writer)
            )
        }
    }

    private fun setListener() {
        findViewById<Flow>(R.id.myPageFlow).setOnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
    }

    private fun cardBinder(post: Post, writer: User): View {
        val itemCard = LayoutInflater.from(this).inflate(
            R.layout.item_post, null
        )
        itemCard.findViewById<TextView>(R.id.nameTextView).text = writer.userId
        itemCard.findViewById<CircleImageView>(R.id.profileImageView).setImageResource(writer.profileImageId)
        itemCard.findViewById<ImageView>(R.id.contentImageView).setImageResource(post.imageId)
        itemCard.findViewById<TextView>(R.id.titleTextView).text = post.title

        itemCard.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra(USER_DATA, writer)
                putExtra(POST_DATA, post)
            }
            )
        }
        return itemCard
    }

    companion object {
        const val USER_DATA = "userData"
        const val POST_DATA = "postData"
    }
}