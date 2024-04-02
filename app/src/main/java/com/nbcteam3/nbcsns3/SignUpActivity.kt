package com.nbcteam3.nbcsns3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpPwText: TextView
    private lateinit var signUpPw: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signUpName = findViewById<EditText>(R.id.signUpName)
        val inputUserName = signUpName.text.toString()
        val signUpId = findViewById<EditText>(R.id.signUpID)
        val inputUserId = signUpId.text.toString()
        val inputUserPw = signUpPw.text.toString()


        signUpPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                ragularPw()
            }
        })

        signUpButton.setOnClickListener {

//            val isName = inputUserName.isEmpty()
//            val isId = inputUserId.isEmpty()
//            val isPw = inputUserPw.isEmpty()

            if (inputUserName.isEmpty() || inputUserId.isEmpty() || inputUserPw.isEmpty()) {
                showToast(getString(R.string.toastnotenter))
                return@setOnClickListener
            }
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun ragularPw() {

        val pwd = signUpPw.text.toString().trim()
        val pwdPattern =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&.])[A-Za-z[0-9]\$@\$!%*#?&.]{5,10}\$"
        val pattern = Pattern.matches(pwdPattern, pwd)
        Log.d("패턴", "$pattern")

        if (pattern) {
            signUpPwText.isVisible = false
        } else {
            signUpPwText.isVisible = true
            signUpPwText.text = getString(R.string.signUpPwmatch)
        }
    }
}
