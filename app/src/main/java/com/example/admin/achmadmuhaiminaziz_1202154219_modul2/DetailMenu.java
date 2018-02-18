package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        //setting agar button back muncul di view
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //menerima value yang dikirimkan dari activity DaftarMenuAdapter berupa sebuah key value dari intent dengan getSting Extra
        String menu = getIntent().getStringExtra("menu");
        String harga = getIntent().getStringExtra("harga");
        String komposisi = getIntent().getStringExtra("komposisi");
        Integer image = getIntent().getIntExtra("image", 0);

        //mendefinisikan TextView dan ImageView dengan id
        TextView txtMenu = findViewById(R.id.namaMenu);
        TextView txtPrice = findViewById(R.id.harga);
        TextView txtkomposisi = findViewById(R.id.detailkomposisi);
        ImageView images = findViewById(R.id.imageMenu);

        //setting value untuk detail menu
        txtMenu.setText(menu);
        txtPrice.setText("RP." + " " + harga);
        txtkomposisi.setText(komposisi);
        images.setImageResource(image);
    }

    //membuat method boolean ketika button back diklik
    @Override
    public boolean onSupportNavigateUp() {
        //function ketika button back di klik maka akan kembali ke view sebelumnya
        onBackPressed();
        return true;
    }
}
