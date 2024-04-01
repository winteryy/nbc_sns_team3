package com.nbcteam3.nbcsns3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signUpName = findViewById<EditText>(R.id.signUpName)
        val inputUserName = signUpName.text.toString()
        val signUpId = findViewById<EditText>(R.id.signUpID)
        val inputUserId = signUpId.text.toString()
        val signUpPw = findViewById<EditText>(R.id.signUpPw)
        val inputUserPw = signUpPw.text.toString()

        val isName = inputUserName.isEmpty()
        val isId = inputUserId.isEmpty()
        val isPw = inputUserPw.isEmpty()

        signUpButton.setOnClickListener {

            if (isName || isId || isPw){
                showToast("입력되지 않은 정보가 있습니다")
                return@setOnClickListener
            }
            finish()
        }
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}