package com.example.admin.achmadmuhaiminaziz_1202154219_modul2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

//Class Adapter ini Digunakan menampilkan data pada Recyclerview
public class DaftarMenuAdapter extends RecyclerView.Adapter<DaftarMenuAdapter.ViewHolder> {

    //membuat arraylist
    private ArrayList<String> arrayListMenu; //Digunakan untuk Judul
    private ArrayList<String> arrayListsPrice; //Digunakan untuk Menu
    private ArrayList<Integer> gambar; //Digunakan untuk Gambar

    //Membuat Konstruktor pada Class RecyclerViewAdapter
    DaftarMenuAdapter(ArrayList<String> arrayListMenu, ArrayList<String> arrayListsPrice, ArrayList<Integer> Gambar){
        this.arrayListMenu = arrayListMenu;
        this.arrayListsPrice = arrayListsPrice;
        this.gambar = Gambar;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View yang akan dibuat
    class ViewHolder extends RecyclerView.ViewHolder{
        //membuat variabel untuk component
        private TextView menu, harga;
        private ImageView gambar;
        private LinearLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //inisialisasi View-View untuk kita gunakan pada RecyclerView
            menu = itemView.findViewById(R.id.txtMenu);
            harga = itemView.findViewById(R.id.txtHarga);
            gambar = itemView.findViewById(R.id.imageMenu);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    public DaftarMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_daftar_menu_adapter, parent, false);
        ViewHolder VH = new ViewHolder(V);
        return VH;
    }


    public void onBindViewHolder(final DaftarMenuAdapter.ViewHolder holder, final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat sesuai pada Posisi Tertentu
        //Mengambil data sesuai dengan posisi yang telah ditentukan
        final String menu = arrayListMenu.get(position);
        final String harga = arrayListsPrice.get(position);
        final Integer image = gambar.get(position);
        //menyeting menu harga dan gambar
        holder.menu.setText(menu);
        holder.harga.setText("Harga Rp. "+harga);
        holder.gambar.setImageResource(image); // Mengambil gambar sesuai posisi yang telah ditentukan
        //Membuat Aksi Saat Judul Pada List ditekan
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Membuat Aksi Saat List Ditekan
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailMenu.class);
                String komposisi;
                //membuat switch pada posisi
                switch (position){
                    //menentukan detail menu sesuai dengan menu harga image komposisi pada array yang dibuat pada daftar menu
                    //membuat intent putExtra agar dapat diambil pada detail menu
                    case 0:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "Nasi, Kecap, Telur, Cabe, Garam, Daun Bawang";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "500g daging sapi, 2 buah kentang, 2 batang serai, 3 lembar daun salam, 1 liter santan sedang kentalnya";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "beras ketan putih, telur ayam, ebi, bawang merah goreng, serundeng, cabai , kencur, jahe, merica butiran, garam dan gula pasir.";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "2 butir cengkeh, 2 batang serai, 2 cm kayu manis, merica secukupnya, pala bubuk secukupnya, garam secukupnya";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "mentimun, taoge, kol, kacang panjang, daun kemangi, dan terong, Bumbu Kacang";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("menu", arrayListMenu.get(position));
                        intent.putExtra("harga", arrayListsPrice.get(position));
                        intent.putExtra("image", gambar.get(position));
                        komposisi = "mentimun, taoge, kol, kacang panjang, Sayur, Lontong, Bumbu Kacang";
                        intent.putExtra("komposisi", komposisi);
                        view.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }

    //memanggil agar disesuaikan dengan banyaknya item
    public int getItemCount() {
        return arrayListMenu.size();
    }
}