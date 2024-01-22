package dga.example.dialagadbanappfinal2023.data.MyAccessories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import dga.example.dialagadbanappfinal2023.data.TheLowerPartTable.TheLowerPart;
import dga.example.dialagadbanappfinal2023.data.clothesTable.myClothes;
/**
 * واجهه تحوي عمليات /دوال/استعمالات على قاعدة البايانات
 */
@Dao//لتحديد ان الواجهه تحوي استعلامات على قاعدة بيانات
public interface MyAccessoriesQuery1
{
    /**
     * اعادة جميع معطيات جدول الاكسسوارات
     *@return قائمة-من-الاكسسورات
     */
    @Query("SELECT * FROM MyAccessories")
    List<MyAccessoriesQuery1> getAll();
    /**
     * ادخال الاكسسوارات
     * @param accessories * مجموعة الاكسسوارات
     */
    @Insert
    void insertAll(myAccessories... accessories);
    /**
     * حذف الاكسسوارات
     * @param accessories * حذف الاكسسوارات (  حسب المفاتح الرئيسي)
     */
    @Delete
    void delete(myAccessories accessories);

    @Query("Delete From myAccessories  WHERE keyid=:id ")
    void delete(int id);
    /**
     * تعديل الاكسسوارات
     * @param  * مجموعة الاكسسوارات للتعديل accessories
     *
     */
    @Update
    void update(myAccessories... values);
    @Insert
    void insert(myAccessories accessories);


}

