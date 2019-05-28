package com.aspire.photomat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when(view?.getId()) {
            R.id.buttonSignUp -> println(R.string.sign_up)
            R.id.buttonLogin -> println(R.string.log_in)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setTitle(R.string.sign_up)

        var editEmail: EditText = findViewById(R.id.textEmail)
        var editUsername: EditText = findViewById(R.id.textUsername)
        var editPassword: EditText = findViewById(R.id.textPassword)
        var signUpButton: Button = findViewById(R.id.buttonSignUp)
        var loginButton: Button = findViewById(R.id.buttonLogin)

        signUpButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)
    }
}
