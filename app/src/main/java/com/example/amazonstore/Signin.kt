package com.example.amazonstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val login=findViewById<EditText>(R.id.login_in)
        val password=findViewById<EditText>(R.id.password_in)
        val signin_btn=findViewById<Button>(R.id.button_in)
        val link_to_reg=findViewById<TextView>(R.id.reg_page)
        link_to_reg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        signin_btn.setOnClickListener {
            val login_user= login.text.toString().trim()
            val password_user= password.text.toString().trim()
            if (login_user=="" || password_user==""){
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
            else {
                val db=DbHelper(this, null)
                val res = db.getUser(login_user, password_user)
                if (res){
                    Toast.makeText(this, "User $login_user signed in", Toast.LENGTH_LONG).show()
                    login.text.clear()
                    password.text.clear()
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Oooops. Login or password is wrong", Toast.LENGTH_LONG).show()

            }
        }
    }
}