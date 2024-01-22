package dga.example.dialagadbanappfinal2023.data.TheShoesTable;

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
public interface MyShoesQuery1
{
    /**
     * اعادة جميع معطيات جدول الاحذية
     *@return  قائمة من الاحذية
     */
    @Query("SELECT * FROM TheShoes")
    List<TheShoes> getAll();
    /**
     * ادخال الاحذية
     * @param  * مجموعة الاحذية
     */
    @Insert
    void insertAll(TheShoes... shoes);
    /**
     * حذف الاحذية
     * @param  * حذف الاحذية (  حسب المفاتح الرئيسي)
     */
    @Delete
    void delete(TheShoes shoes);
    @Query("Delete From TheShoes WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(TheShoes myshose);
    /**
     * تعديل الاحذية
     * @param  * مجموعة الاحذية للتعديل
     */
    @Update
    void update(TheShoes... values);
}
