package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarMenu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaftarMenuAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> Menu;
    private ArrayList<String> Harga;
    private ArrayList<Integer> Gambar;

    //membuat array string Daftar Menu
    private String[] menu = {"Nasi Goreng", "Soto Betawie", "Kerak Telor", "Nasi Uduk", "Karedok Betawie", "Gado - Gado Betawie"};
    //membuat array string Daftar Harga
    private String[] harga = {"15.000", "30.000", "20.000", "15.000", "15.000", "15.000"};
    //membuat array int Daftar Gambar
    private int[] image = {R.drawable.nasigoreng, R.drawable.soto, R.drawable.keraktelor, R.drawable.nasiuduk, R.drawable.karedok,
            R.drawable.gadogado};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);
        //membuat array list pada Menu Harga Gambar
        Menu = new ArrayList<>();
        Harga = new ArrayList<>();
        Gambar = new ArrayList<>();

        //inisiasi recycle view dengan nama recyclerView
        recyclerView= findViewById(R.id.recyclerview);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new DaftarMenuAdapter(Menu, Harga, Gambar);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }

    //membuat method looping DaftarItem untuk mengisi recycler view
    private void DaftarItem() {
        for (int w=0; w<menu.length; w++){
            Gambar.add(image[w]);
            Menu.add(menu[w]);
            Harga.add(harga[w]);
        }
    }


}
