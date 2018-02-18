package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //inisiasi untuk component / variabel
    Button pesan ;
    RadioGroup group;
    RadioButton dine, take;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat variable untuk component yang ada
            group = findViewById(R.id.rGroup);
            dine = findViewById(R.id.dineIn);
            take = findViewById(R.id.takeAway);
            pesan = findViewById(R.id.pesan);

        }

    //Action ketika button pesan di click / disentuh
    public void pesan(View view) {
        //membuat kondisi jika radio button dine in di pilih
        if (dine.isChecked()){
            Intent a = new Intent(MainActivity.this,DineIn.class);
            startActivity(a);
            Toast.makeText(MainActivity.this, "Dine In", Toast.LENGTH_LONG).show();
        //jika TakeAway yang dipilih maka akan membuka Take Away Activity
        }else if (take.isChecked()){
            Intent a = new Intent(MainActivity.this,TakeAway.class);
            startActivity(a);
            Toast.makeText(MainActivity.this, "Take Away", Toast.LENGTH_LONG).show();
        //jika tidak ada yang dipilih maka akan muncul pesan Alert Dialog untuk memilih tipe pesanan
        }else if (!dine.isChecked() || !take.isChecked()){

            //membuat Alert Dialog Builder
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            //membuat tittle dari alert
            alert.setTitle("Alert Message");
            //isi pesan alert dialog
            alert.setMessage("Silahkan Pilih Pesanan Anda !")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            //membuat alert dialog
            AlertDialog alertDialog = alert.create();
            //memunculkan alert dialog
            alertDialog.show();
        }
    }
}
