package com.nbcteam3.nbcsns3

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signInButton = findViewById<Button>(R.id.signInButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val userId = findViewById<EditText>(R.id.userId)
        val userPw = findViewById<EditText>(R.id.userPw)

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        signInButton.setOnClickListener {

            if (userId.text.isEmpty()) {
                showToast(getString(R.string.input_id))
                return@setOnClickListener
            }
            if (userPw.text.isEmpty()) {
                showToast(getString(R.string.input_pw))
                return@setOnClickListener
            }

            val sharedPreference = getSharedPreferences("signInUser", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("userId", userId.toString())
            editor.putString("userPw", userPw.toString())
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}