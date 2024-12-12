package com.example.ejercicioschatgpt.todoList

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TaskDAO(private var context:Context) {
    private val tableName = "task_db"
    private val helper = DBHelper(context, "tasks.db", null, 1)
    private val writeDb:SQLiteDatabase = helper.writableDatabase
    private val readDb:SQLiteDatabase = helper.readableDatabase

    fun insertItem(task:Task) {
        val content = ContentValues()
        content.put("name", task.name)
        writeDb.insert(tableName, null, content)
    }

    fun deleteItem(name:String) = writeDb.delete(tableName, "name=?", arrayOf(name))

    fun getItems():List<Task> {
        val taskList:ArrayList<Task> = arrayListOf()
        val res:Cursor = readDb.query(tableName, arrayOf("id", "name"), null, null, null, null, null)
        while (res.moveToNext()) {
            taskList.add(Task(
                res.getInt(res.getColumnIndexOrThrow("id")),
                res.getString(res.getColumnIndexOrThrow("name"))
            ))
        }
        res.close()
        return taskList
    }
}