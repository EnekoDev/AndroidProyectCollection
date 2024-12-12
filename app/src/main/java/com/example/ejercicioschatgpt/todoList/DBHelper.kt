package com.example.ejercicioschatgpt.todoList

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context:Context?,
    name:String?,
    factory: CursorFactory?,
    version:Int
): SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db:SQLiteDatabase?) {
        val query = "CREATE TABLE task_db (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS task_db")
            onCreate(db)
        }
    }
}