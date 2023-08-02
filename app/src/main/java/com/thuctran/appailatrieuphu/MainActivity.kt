package com.thuctran.appailatrieuphu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import db.Question
import db.QuestionDAO

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG:String = MainActivity::class.java.name
    }

    private var listDB: List<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        Thread{
            listDB = App.INSTANCE.DB.getQuestionDAO().getAllQuestion()
            runOnUiThread {
                loadDBSucess()  //chạy trên MainThread
            }
        }.start()
    }

    private fun loadDBSucess() {
        Toast.makeText(this,"Size+${listDB!!.size}",Toast.LENGTH_SHORT).show()
        Log.i(TAG,"danh sách câu hỏi: ${listDB.toString()}")
    }
}