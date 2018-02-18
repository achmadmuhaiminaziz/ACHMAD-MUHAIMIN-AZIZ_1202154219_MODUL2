package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class splashScreen extends AppCompatActivity {

    //membuat waktu untuk berapa lama progresbar berjalan / splash interval
    private static int splashInterval = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        //Membuat Splasscreen dengan postdelayed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //membuat intent untuk splasScreen pindah ke MainActivity
                Intent splash = new Intent(splashScreen.this, MainActivity.class);
                startActivity(splash);

                //Membuat Toast
                Toast.makeText(splashScreen.this,"Achmad Muhaimin Aziz_1202154219",Toast.LENGTH_LONG).show();
                this.finish();
            }
            private void finish() {
            }
            //memanggil splash interval selama 2000 / 2 detik
        }, splashInterval);
    };
}
