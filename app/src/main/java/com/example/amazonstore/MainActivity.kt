package com.example.amazonstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login=findViewById<EditText>(R.id.login)
        val email=findViewById<EditText>(R.id.email)
        val password=findViewById<EditText>(R.id.password)
        val reg_btn=findViewById<Button>(R.id.button_in)
        reg_btn.setOnClickListener {
            val user_login= login.text.toString().trim()
            val user_email= email.text.toString().trim()
            val user_password= password.text.toString().trim()
            if (user_email=="" || user_login=="" || user_password==""){
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }else{
                val user=User(user_login, user_email, user_password)

                val db=DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $user_login added", Toast.LENGTH_SHORT).show()
                email.text.clear()
                login.text.clear()
                password.text.clear()

            }
        }
        val link_to_signin=findViewById<TextView>(R.id.sign_page)
        link_to_signin.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }
    }
}