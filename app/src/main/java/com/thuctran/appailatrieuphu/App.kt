package com.thuctran.appailatrieuphu

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import db.AppDB

class App : Application() {
    private var db:AppDB? = null
    val DB:AppDB
        get() = db!!

    companion object {
        private var instance:App? = null
        val INSTANCE:App
            get() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //khởi tạo 1 CSDL lưu trong data bộ nhớ
        db = Room.databaseBuilder(
            this,
            AppDB::class.java, "question-db").createFromAsset("db/Question")   //copy CSDL trong thư mục assets có sẵn, ko cần tạo mới hoàn toàn
            .build()    //khởi tạo database để có thể truy vấn ở tất cả mọi nơi trong project
    }
}
