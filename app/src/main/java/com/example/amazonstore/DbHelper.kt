package com.example.amazonstore

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

//create Database
class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, "shop", factory, 2) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }
//upgrade
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values= ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)

        val db=this.writableDatabase //записать в базу
        db.insert("users", null, values)  //добаление в таблицу

        db.close()

    }

    fun getUser(login: String, password: String): Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND password = '$password'", null)
        return result.moveToFirst()   //true or false
        result.close()
    }

}