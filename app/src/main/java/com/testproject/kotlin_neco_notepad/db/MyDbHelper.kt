package com.testproject.kotlin_neco_notepad.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper(context, MyDbNameClass.database_name, null, MyDbNameClass.database_version) {
//    val writeableDatabase: SQLiteDatabase?
//        get() {
//            TODO()
//        }

    override fun onCreate(db: SQLiteDatabase?) {
//        TODO("Not yet implemented")
        db?.execSQL(MyDbNameClass.create_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        TODO("Not yet implemented")
        db?.execSQL(MyDbNameClass.sql_delete_table)
        onCreate(db)
    }
}