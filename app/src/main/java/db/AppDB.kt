package db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Question::class], version = 1)
abstract class AppDB : RoomDatabase(){
    abstract fun getQuestionDAO():QuestionDAO       //tạo PT trả về interface DAO, có thể gọi đến các PT của interface
}