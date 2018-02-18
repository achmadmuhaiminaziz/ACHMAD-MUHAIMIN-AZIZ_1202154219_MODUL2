package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class TakeAway extends AppCompatActivity {
    //membuat variabel dari component yang ada serta membuat variabel untuk date dan time picker
    Button pilih;
    int hour, minute, mYear, mMonth, mDay;
    static final int TIME_DIALOG_ID = 0;
    static final int DATE_DIALOG_ID = 1;
    public EditText txtDate, txtTime, nama,numPhone, alamat;
    public String [] arrMonth = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Des" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        //membuat variabel untuk spesifik component
        nama = (EditText)findViewById(R.id.nama);
        numPhone =(EditText)findViewById(R.id.numPhone);
        alamat = (EditText)findViewById(R.id.alamat);
        pilih = (Button)findViewById(R.id.pilih);
        txtDate = (EditText)findViewById(R.id.date);
        txtTime = (EditText)findViewById(R.id.time);
        final Calendar c = Calendar.getInstance();
        mYear =c.get(Calendar.YEAR);
        mMonth =c.get(Calendar.MONTH);
        mDay =c.get(Calendar.DAY_OF_MONTH);



        //action pada saat edit Text Date and Time pada saat disentuh akan mengeluarkan date and time picker
        txtDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(DATE_DIALOG_ID);
                return true;
            }
        });

        txtTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(TIME_DIALOG_ID);
                return true;
            }
        });
    }

    //membuat dialog untuk date and time picker
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(
                        this, mTimeSetListener, hour, minute, true);
            case DATE_DIALOG_ID:
                return new DatePickerDialog(
                        this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            String sdate = arrMonth[mMonth] + " " + LPad(mDay + "", "0", 2) + ", " + mYear;
            txtDate.setText(sdate);
        }
    };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
            hour = hourOfDay;
            minute = minuteOfHour;
            String stime = LPad("" + hour, "0", 2) + ":" + LPad("" + hour, "0", 2);
            txtTime.setText(stime);
        }
    };

    private static String LPad(String schar, String spad, int len) {
        String sret = schar;
        for (int i = sret.length(); i < len; i++) {
            sret = spad + sret;
        }
        return new String(sret);
    }
    //pada saat button pilih diklik atau disentuh
    public void pilih(View view) {
        String namaCust = nama.getText().toString();
        String noHp = numPhone.getText().toString();
        String almt = alamat.getText().toString();
        String time = txtTime.getText().toString();
        String date = txtDate.getText().toString();
        //validasi untuk setiap edit text agar diisi kecuali catatan
        if(namaCust.isEmpty() || noHp.isEmpty() || almt.isEmpty() || time.isEmpty() || date.isEmpty()){
            //membuat alert dialog
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Alert Message");
            alert.setMessage("Silahkan Isi Detail Pesanan Anda !")
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
            //jika diisi semua makan akan ke daftar menu activity
            Intent a = new Intent(TakeAway.this, DaftarMenu.class);

            startActivity(a);
        }
    }
}
