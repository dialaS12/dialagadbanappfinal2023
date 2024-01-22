package dga.example.dialagadbanappfinal2023.data.TheUpperPartTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/**
 * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البايانات
 */
@Dao//لتحديد ان الواجهه تحوي استعلامات على قاعدة بيانات
@Entity
public interface MyTheUpperPartQuery1
{
    /**
     * اعادة جميع معطيات جدول الجزء العلوي
     *@return  قائمة من الجزء العلوي
     */
    @Query("SELECT * FROM TheUpperPart")
    List<TheUpperPart> getAll();
    /**
     * ادخال الجزء العلوي
     * @param  * مجموعة الجزء العلوي
     */
    @Insert
    void insertAll(TheUpperPart... upperParts);
    /**
     * حذف الجزء العلوي
     * @param  * حذف الجزء العلوي (  حسب المفاتح الرئيسي)
     */
    @Delete
    void delete(TheUpperPart upperPart);

    @Query("Delete From TheUpperPart WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(TheUpperPart myUpperPart);
    /**
     * تعديل الجزء العلوي
     * @param  * مجموعة الجزء العلوي للتعديل
     */
    @Update
    void update(TheUpperPart... values);
}
