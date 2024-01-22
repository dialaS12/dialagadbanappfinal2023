package dga.example.dialagadbanappfinal2023.data.TheLowerPartTable;
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
public interface MyTheLowerPartQuery1
{
    /**
     * اعادة جميع معطيات جدول للجزء السفلي
     *@return  قائمة من الجزء السفلي
     */
    @Query("SELECT * FROM TheLowerPart")
    List<TheLowerPart> getAll();
    /**
     * ادخال الجزء السفلي
     * @param  * مجموعة المطاعم
     * TheLowerPart
     */
    @Insert
    void insertAll(TheLowerPart... theLowerParts);
    /**
     * حذف الجزء السفلي
     * @param  * حذف الجزء السفلي (  حسب المفاتح الرئيسي)
     * TheLowerPart
     */
    @Delete
    void delete(TheLowerPart lowerPart);
    @Query("Delete From TheLowerPart WHERE keyid=:id ")
    void delete(int id);
    @Insert
    void insert(TheLowerPart myLowerPart);
    /**
     * تعديل الجزء السفلي
     *TheLowerPart
     *  @param  * مجموعة الجزء السفلي للتعديل
     */
    @Update
    void update(TheLowerPart... values);
}
