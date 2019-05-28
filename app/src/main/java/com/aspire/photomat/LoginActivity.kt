package com.aspire.photomat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when(view?.getId()) {
            R.id.buttonLoginLogin -> println(R.string.log_in)
            R.id.buttonSignUpLogin -> println(R.string.sign_up)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle(R.string.log_in)

        var editEmail: EditText = findViewById(R.id.textEmailLogin)
        var editPassword: EditText = findViewById(R.id.textPasswordLogin)
        var signUpButton: Button = findViewById(R.id.buttonSignUpLogin)
        var loginButton: Button = findViewById(R.id.buttonLoginLogin)

        signUpButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)
    }

}
