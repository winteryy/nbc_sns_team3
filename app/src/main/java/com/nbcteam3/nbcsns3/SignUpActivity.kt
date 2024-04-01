package com.nbcteam3.nbcsns3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpPwText :TextView
    private lateinit var signUpPw :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signUpName = findViewById<EditText>(R.id.signUpName)
        val inputUserName = signUpName.text.toString()
        val signUpId = findViewById<EditText>(R.id.signUpID)
        val inputUserId = signUpId.text.toString()
        signUpPw = findViewById<EditText>(R.id.signUpPw)
        val inputUserPw = signUpPw.text.toString()
        signUpPwText = findViewById<TextView>(R.id.signUpPwText)

        val isName = inputUserName.isEmpty()
        val isId = inputUserId.isEmpty()
        val isPw = inputUserPw.isEmpty()

        signUpPw.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                ragularPw()
            }
        })

        signUpButton.setOnClickListener {

            if (isName || isId || isPw){
                showToast("입력되지 않은 정보가 있습니다")
            }
            finish()
        }
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
//enum class
    private fun ragularPw() {

        val pwd = signUpPw.text.toString().trim()
        val pwdPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&.])[A-Za-z[0-9]\$@\$!%*#?&.]{8,20}\$"
        val pattern = Pattern.matches(pwdPattern, pwd)
        Log.d("패턴","$pattern")

        if(pattern){
            signUpPwText.isVisible = false //실행
            //패턴 검증 > 식=if자체가 변수 취급  > 위에 실행 하고 마지막 리턴
        }else{
            signUpPwText.isVisible = true
            signUpPwText.text = getString(R.string.signUpPwmatch)
        }
    }
}

//숫자 : ^[0-9]*$
//영문자 : ^[a-zA-Z]*$
//한글 : ^[가-힣]*$
//이메일 : \w+@\w+\.\w+(\.\w+)?
//전화번호 : ^\d{2,3}-\d{3,4}-\d{4}$
//휴대전화번호 : ^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$
//주민등록번호 : \d{6} - [1-4]\d{6}
//우편번호 : ^\d{3}-\d{2}$


//"^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&.])[A-Za-z[0-9]\$@\$!%*#?&.]{4,10}\$"