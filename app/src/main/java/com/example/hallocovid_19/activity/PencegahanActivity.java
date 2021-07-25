package com.example.hallocovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hallocovid_19.R;
import com.example.hallocovid_19.adapter.AdapterGejala;
import com.example.hallocovid_19.adapter.AdapterPencegahan;
import com.example.hallocovid_19.model.DataModelPencegahan;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PencegahanActivity extends AppCompatActivity {

    AdapterPencegahan adapterPencegahan;
    TabLayout tabLayout;
    ViewPager viewPagerPencegahan;

    ImageView imageBack;
    Button nextButton;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencegahan);

        nextButton = findViewById(R.id.nextButton);
        tabLayout = findViewById(R.id.tabIndicator);
        imageBack = findViewById(R.id.imageBackPencegahan);

        //now lets add some data in model class
        final List<DataModelPencegahan> dataModelPencegahanList = new ArrayList<>();
        dataModelPencegahanList.add(new DataModelPencegahan("Tinggal di Rumah", "Anda harus membatasi aktifitas diluar rumah, kecuali untuk memperoleh layanan kesehatan. Selain itu, disarankan untuk tidak pergi bekerja, ke sekolah, atau mengunjungi tempat-tempat publik. Hindari menggunakan transportasi publik.", R.drawable.ic_house));
        dataModelPencegahanList.add(new DataModelPencegahan("Menggunakan Masker", "Gunakan masker saat berada di sekitar orang lain, binatang peliharaan atau jika akan ketempat publik. Jika anda tidak dapat menggunakan masker, orang yang tinggal bersama anda tidak diperbolehkan untuk berada dalam ruangan yang sama.", R.drawable.ic_face_mask));
        dataModelPencegahanList.add(new DataModelPencegahan("Sering mencuci Tangan", "Cuci tangan lebih sering dengan menggunakan sabun dan air setidaknya 20 detik. Jika sabun dan air tidak tersedia, cucilah tangan dengan pembersih tangan yang mengandung setidaknya 60 persen alkohol.", R.drawable.ic_wash_your_hands));

        setOnBoardingViewPager(dataModelPencegahanList);
        position = viewPagerPencegahan.getCurrentItem();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < dataModelPencegahanList.size()){
                    position++;
                    viewPagerPencegahan.setCurrentItem(position);
                }
                if (position == dataModelPencegahanList.size()){
                    Intent intent = new Intent(PencegahanActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (tab.getPosition() == dataModelPencegahanList.size() - 1){
                    nextButton.setText("Selesai");
                }else{
                    nextButton.setText("Next");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setOnBoardingViewPager(List<DataModelPencegahan>dataModelPencegahanList){
        viewPagerPencegahan = findViewById(R.id.screenPager2);
        adapterPencegahan = new AdapterPencegahan(this, dataModelPencegahanList);
        viewPagerPencegahan.setAdapter(adapterPencegahan);
        tabLayout.setupWithViewPager(viewPagerPencegahan);
    }
}