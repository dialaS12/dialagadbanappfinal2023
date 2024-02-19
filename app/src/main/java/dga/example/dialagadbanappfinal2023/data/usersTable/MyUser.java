package dga.example.dialagadbanappfinal2023.data.usersTable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//جدول=Entity=Table
//عندما نريد ان نتعامل مع هذه الفئة كجدول معطيات
@Entity
public class MyUser
{
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي ينتج بشكل اوتماتي
    public long keyid;
    @ColumnInfo(name = "full-Name")//اعطاء اسم جديد للعامود -الصفة في الجدول
    public String fullName;//اسم المستخدم كامل
    public String email;// بحاله لم يتم اعطاء اسم للعامود يكون اسم الصفه هو اسم العامود
    public String phone;//رقم هاتف الشخصي للمسخدم
    public String passw;//كلمة مرور
    public String id;//رقم مميز
    public long getKeyid() {
        return keyid;
    }
    // ALT -Insert
    @Override
    public String toString() {
        return "MyUser{" +
                "keyid=" + keyid +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passw='" + passw + '\'' +
                '}';

    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setId(String id) {
        this.id = id;
    }
}


