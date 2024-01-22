package dga.example.dialagadbanappfinal2023.data.MySeasonTable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/**
 * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البايانات
 */
@Dao//لتحديد ان الواجهه تحوي استعلامات على قاعدة بيانات
public interface MySeasonQuery1
{
    /**
     * اعادة جميع معطيات جدول الفصول
     *@return  قائمة من الفصول
     */
    @Query("SELECT * FROM MySeason")
    List<MySeason> getAll();
    /**
     * ادخال الفصول
     * @param  * seasons مجموعة الفصول
     */
    @Insert
    void insertAll(MySeason... seasons);
    /**
     * حذف الفصول
     * @param  * حذف الفصول (  حسب المفاتح الرئيسي)
     * seasons
     */
    @Delete
    void delete(MySeason user);

    @Query("Delete From myseason WHERE key_id=:id ")
    void delete(int id);

    @Insert
    void insert(MySeason myUser);
    /**
     * تعديل الفصول
     * @param  * مجموعة الفصول للتعديل
     * season
     */
    @Update
    void update(MySeason... values);
    //الهدف من هذا الكود هو التحقق من وجود (Season) في جدول `MySeason` باستخدام اسم الموسم المحدد، وإرجاع السجل المتطابق إذا كان موجودًا.
    @Query("SELECT * FROM MySeason WHERE SeasonName=:checkSubject")
    MySeason checkSeason(String checkSubject);

}
