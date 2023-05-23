package com.testproject.kotlin_neco_notepad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.testproject.kotlin_neco_notepad.db.MyDbManager
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSave(view: View) {
//        setContentView(R.layout.activity_main)
        var tvTest = findViewById<TextView>(R.id.tvTest)
        tvTest.text = ""
        myDbManager.openDb()
        var edTitle = findViewById<EditText>(R.id.edTitle)
        var edContent = findViewById<EditText>(R.id.edContent)
        myDbManager.insertToDb(edTitle.text.toString(), edContent.text.toString())
        val dataList = myDbManager.readDbData()
        for(item in dataList){
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    override fun onResume(){
        super.onResume()
        myDbManager.openDb()
        var tvTest = findViewById<TextView>(R.id.tvTest)
//        tvTest.text = ""
//        var edTitle = findViewById<EditText>(R.id.edTitle)
//        var edContent = findViewById<EditText>(R.id.edContent)
//        myDbManager.insertToDb(edTitle.text.toString(), edContent.text.toString())
        val dataList = myDbManager.readDbData()
        for(item in dataList){
            tvTest.append(item)
            tvTest.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}