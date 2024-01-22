package dga.example.dialagadbanappfinal2023.data.usersTable;

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
public interface MyUserQuery {
    /**
     * اعادة جميع معطيات جدول المستخدم
     *@return  قائمة من المستحدم
     */
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAll();
    //، يقوم هذا الكود بإرجاع جميع السجلات من جدول `MyUser` حيث تكون قيمة `keyid` متطابقة مع المعرفات التي تم تمريرها في مصفوفة `userIds`.
    @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
    List<MyUser> loadAllByIds(int[] userIds);
//الهدف من هذا الكود هو التحقق من صحة بريد إلكتروني وكلمة مرور في جدول `MyUser` وإرجاع كائن `MyUser` المتطابق إذا كانت المعلومات صحيحة.
    @Query("SELECT * FROM MyUser WHERE email = :myEmail AND " +
            "passw = :myPassw LIMIT 1")
    MyUser checkEmailPassw(String myEmail, String myPassw);
    /**
     * ادخال المستخدم
     * @param  * مجموعة المستخدمين
     */
    @Insert
    void insertAll(MyUser... users);
    /**
     * حذف المستخدم
     * @param  * حذف المستخدم (  حسب المفاتح الرئيسي)
     */
    @Delete
    void delete(MyUser user);

    @Query("Delete From MyUser WHERE keyid=:id ")
    void delete(int id);

    @Insert
    void insert(MyUser myUser);
    /**
     * تعديل المستخدم
     * @param  * مجموعة المستخدم للتعديل
     */
    @Update
    void update(MyUser...values);
    //عملية تعيد جميع الايميلات من جدول MyUser

    @Query("SELECT * FROM MyUser WHERE email = :myEmail ")
    MyUser checkEmail(String myEmail);


}
