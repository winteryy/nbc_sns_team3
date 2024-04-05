package com.nbcteam3.nbcsns3


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private val loadUsers = DummyServer.loadUsers()
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
            val userId2 = userId.text.toString()
            val userPw2 = userPw.text.toString()

            if (userId.text.isEmpty()) {
                showToast(getString(R.string.input_id))
                return@setOnClickListener
            }

            if (userPw.text.isEmpty()) {
                showToast(getString(R.string.input_pw))
                return@setOnClickListener
            }

            val findUser = loadUsers.find { it.userId == userId2 }
            if (findUser == null) {

                showToast(getString(R.string.log_in_failure))
                return@setOnClickListener

            } else if (userPw2 == findUser.password ) {

                val sharedPreference = getSharedPreferences("signInUser", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreference.edit()
                editor.putString("userId", userId.text.toString())
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                showToast(getString(R.string.log_in_failure))
                return@setOnClickListener
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}