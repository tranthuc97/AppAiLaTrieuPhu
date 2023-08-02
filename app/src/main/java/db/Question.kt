package db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
class Question {

    @ColumnInfo(name = "_id")       //tên cột
    @PrimaryKey                     //khai báo cột này làm khóa chính
    @NotNull
    var id:Int = 0

    @ColumnInfo(name = "question")
    var question:String? = null         //khai báo thuộc tính có thể null
    @ColumnInfo(name = "level")
    var level:String? = null
    @ColumnInfo(name = "casea")
    var caseA:String? = null
    @ColumnInfo(name = "caseb")
    var caseB:String? = null
    @ColumnInfo(name = "casec")
    var caseC:String? = null
    @ColumnInfo(name = "cased")
    var caseD:String? = null
    @ColumnInfo(name = "truecase")
    var trueCase:String? = null

    override fun toString(): String {
        return question.toString()
    }
}