package dga.example.dialagadbanappfinal2023.data.clothesTable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dga.example.dialagadbanappfinal2023.MainActivity;
import dga.example.dialagadbanappfinal2023.R;

public class MyAdapterRecLst
        extends RecyclerView.Adapter<MyAdapterRecLst.ViewHolder>

    {

        // ... فئة ViewHolder ومنشئها كما هو موضح أعلاه


        ArrayList<MyClothes> list;
        MainActivity contexct;

        public MainActivity getContexct() {
        return contexct;
    }

        public ArrayList<MyClothes> getList() {
        return list;
    }

        // Constructor         منشئ
    public MyAdapterRecLst(ArrayList < MyClothes > list, MainActivity contexct) {
        this.contexct = contexct;
        this.list = list;
    }

        // Creating a viewHolder
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        // Inflate the layout         تضخيم التخطيط
        View contactView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.clothes_item_layout, parent, false);

        // Return a new holder instance         إرجاع ViewHolder جديد
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

        // Assigning respective data for the views based on the position of the current item         تعيين البيانات ذات الصلة للآراء استنادا إلى موضع البند الحالي
        @Override
        public void onBindViewHolder (@NonNull MyAdapterRecLst.ViewHolder holder,int position){
        // Get the Subject based on the current position        احصل على الموضوع بناء على الوظيفة الحالية
        MyClothes currentItem = list.get(position);
        //   الهدف من هذا يستخدم مكتبة Picasso لتحميل صورة من عنوان URL ووضعها في عنصر ImageView في واجهة المستخدم.
        downloadImageUsingPicasso(currentItem.getThePic(), holder.imageView);
        // Setting views with the corresponding data        تعيين طرق العرض مع البيانات المقابلة
        ImageView imageView = holder.imageView;

       downloadImageUsingPicasso(currentItem.thePic, imageView);
    }

        // Indicating how long your data is        الإشارة إلى المدة التي تستغرقها بياناتك
        @Override
        public int getItemCount () {
        return list.size();
    }
        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            // Constructor - accepts entire row item            المنشئ - يقبل عنصر الصف بأكمله
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                // //קבלת הפניות לרכיבים בקובץ העיצוב                الحصول على مراجع للعناصر في ملف التصميم
                imageView = itemView.findViewById(R.id.imageVitm);


            }
        }
        /**
         * הצגת תמונה ישירות מהענן בעזרת המחלקה ״פיקאסו״
         * @param imageUrL כתובת התמונה בענן/שרת
         * @param toView רכיב תמונה המיועד להצגת התמונה אחרי ההורדה
         */
        private void downloadImageUsingPicasso (String imageUrL, ImageView toView)
        {
            // אם אין תמונה= כתובת ריקה אז לא עושים כלום מפסיקים את הפעולה            إذا لم يكن هناك صورة = عنوان فارغ ، فلا تفعل شيئا ، أوقف العملية
            if (imageUrL == null) return;
            //todo: add dependency to module gradle:
            Picasso.with(getContexct())
                    .load(imageUrL)//הורדת התמונה לפי כתובת قم بتنزيل الصورة حسب العنوان
                    .centerCrop()
                    .error(R.drawable.logodiala_background)//התמונה שמוצגת אם יש בעיה בהורדת התמונה الصورة المعروضة إذا كانت هناك مشكلة في تنزيل الصورة
                    .resize(100, 100)//שינוי גודל התמונה تغيير حجم الصورة
                    .into(toView);// להציג בריכיב התמונה המיועד לתמונה זו العرض في كرسي الصورة المخصص لهذه الصورة
        }

}
