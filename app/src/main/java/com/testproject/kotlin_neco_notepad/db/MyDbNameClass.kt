package com.testproject.kotlin_neco_notepad.db

import android.provider.BaseColumns

object MyDbNameClass {
    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "subtitle"

    const val database_version = 1
    const val database_name = "MyLessonDb.db"

    const val create_table = "create table if not exists $TABLE_NAME (" +
            "${BaseColumns._ID} integer primary key, $COLUMN_NAME_TITLE text, $COLUMN_NAME_CONTENT text)"

    const val sql_delete_table = "drop table if exists $TABLE_NAME"
}