package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //membuat variabel nama dari component yang ada serta membuat variabel untuk noMeja
    EditText nama;
    private String noMeja = "";
    private static final String TAG = MainActivity.class.getSimpleName();
    Button pilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);

        //membuat variabel nama dan button pilih
        nama = (EditText)findViewById(R.id.namaCust);
        pilih = (Button) findViewById(R.id.pilih);

        //memberi nama variabel spinner
        Spinner spinner = (Spinner) findViewById(R.id.nomorMeja);
        //jika spinner tidak sama dengan kosong
        if (spinner != null) {
            //akan memilih sesuai yang dipilih (listener)
            spinner.setOnItemSelectedListener(this);
        }
        //membuat array adapter dengan nama adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.noMeja, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //jika spinner tidak sama dengan kosong
        if (spinner != null) {
            //menyetting spinner menjadi adapter
            spinner.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //agar mengetahui no meja yang akan dipilih dan dikonvert menjadi string
        noMeja = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //jika tidak ada yang dipilih akan membuat log
        Log.d(TAG, getString(R.string.nothing_selected));
    }

    public void pilih(View view) {
        //membuat String namaCust (nama Customer)
        String namaCust = nama.getText().toString();

        //Jika nama customer tidak di isi akan muncul alert
        if (namaCust.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Alert Message");
            alert.setMessage("Silahkan Isi Nama Anda !")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }else{
            //membuat intent untuk dine in ke daftar menu
            Intent meja = new Intent(DineIn.this, DaftarMenu.class);
            //membuat Toast message
            Toast.makeText(DineIn.this,  noMeja + " Telah Terpilih", Toast.LENGTH_LONG).show();
            startActivity(meja);
        }

    }
}
