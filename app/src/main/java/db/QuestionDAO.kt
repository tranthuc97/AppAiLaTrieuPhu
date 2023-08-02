package db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface QuestionDAO {

    companion object{
        const val SELECT_15_Q:String = "SELECT * FROM (SELECT * FROM question WHERE level = 1 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 2 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 3 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 4 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 5 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 6 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 7 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 8 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 9 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 10 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 11 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 12 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 13 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 14 ORDER BY RANDOM() LIMIT 1)\n" +
                "UNION SELECT * FROM (SELECT * FROM question WHERE level = 15 ORDER BY RANDOM() LIMIT 1)"

    }   //để companion object thì mới khởi tạo được thuộc tính trong interface, và TT phải là hằng (const val)

    @Query(SELECT_15_Q)
    fun getAllQuestion():List<Question>         //Class Question đã khai báo đầy đủ thuộc tính. PT SELECT cũng đã truy vấn tất cả các Question
    //giờ chỉ cần khớp 2 cái lại với nhau dựa trên PT getAllQuestion trả về List<Question>. Hiểu đơn giản là gọi đến PT này sẽ trả về ds 15 câu hỏi đã SELECT

    //PT lấy 1 câu hỏi theo level
    @Query("SELECT * FROM question WHERE level = :level ORDER BY RANDOM() LIMIT 1")
    fun getQuestionByLevel(level:Int)       //level = :level,

}