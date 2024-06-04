package dga.example.dialagadbanappfinal2023;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyAdudioPlayerService extends Service {
    public MyAdudioPlayerService() {
    }
    public void onCreate(){
        super.onCreate();
        //יצירת נגן אודיו וקביעת קובץ האודיו
        mediaPlayer= MediaPlayer.create(getApplicationContext(),R.raw.music);



    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}