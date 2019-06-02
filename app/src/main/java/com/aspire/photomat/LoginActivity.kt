package com.aspire.photomat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when(view?.getId()) {
            R.id.buttonLoginLogin -> {
                ParseUser.logInInBackground(
                        textUsernameLogin.text.toString(),
                        textPasswordLogin.text.toString(),
                        ({user, e ->
                            if (user != null) {
                                Toast.makeText(this, "logged in", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(this, "not logged in", Toast.LENGTH_LONG).show()
                            }
                            textPasswordLogin.text.clear()
                        })
                )
            }

            R.id.buttonSignUpLogin -> {
                intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle(R.string.log_in)

        var editEmail: EditText = findViewById(R.id.textUsernameLogin)
        var editPassword: EditText = findViewById(R.id.textPasswordLogin)
        var signUpButton: Button = findViewById(R.id.buttonSignUpLogin)
        var loginButton: Button = findViewById(R.id.buttonLoginLogin)

        signUpButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)
    }

}
