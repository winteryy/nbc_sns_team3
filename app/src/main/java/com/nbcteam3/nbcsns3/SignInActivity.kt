package com.nbcteam3.nbcsns3

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signInButton = findViewById<Button>(R.id.signInButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val userId = findViewById<EditText>(R.id.userId)
        val inputUserId = userId.text.toString()
        val userPw = findViewById<EditText>(R.id.userPw)
        val inputUserPw = userPw.text.toString()

        val isId = inputUserId.isEmpty()
        val isPw = inputUserPw.isEmpty()

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        signInButton.setOnClickListener {

            if(isId){
                showToast("아이디를 입력해주세요")
                return@setOnClickListener
            }
            if (isPw){
                showToast("비밀번호를 입력해주세요")
                return@setOnClickListener
            }

            val sharedPreference = getSharedPreferences("signInUser", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("userId",userId.toString())
            editor.putString("userPw",userPw.toString())
//                    val intent = Intent(this, 메인엑티비티::class.java)
//                    startActivity(intent)
                }
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}