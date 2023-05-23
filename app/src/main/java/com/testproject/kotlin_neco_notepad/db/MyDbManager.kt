package com.testproject.kotlin_neco_notepad.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(val context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
        }

        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        var cursor = db?.query(MyDbNameClass.TABLE_NAME, null, null, null, null,
        null, null)

        with(cursor){
            while(this?.moveToNext()!!){
                var dataText = cursor?.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()

        return dataList

    }

    fun closeDb(){
        myDbHelper.close()
    }

}