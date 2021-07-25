package com.example.hallocovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hallocovid_19.R;
import com.example.hallocovid_19.adapter.AdapterCovid;
import com.example.hallocovid_19.model.DataModelCovid;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class CovidActivity extends AppCompatActivity {

    AdapterCovid adapterCovid;
    TabLayout tabLayout;
    ViewPager viewPagerCovid;

    Button nextButton;
    ImageView imageBack;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_covid);

        nextButton = findViewById(R.id.next);
        tabLayout = findViewById(R.id.tabIndicator);
        imageBack = findViewById(R.id.imageBack);

        //now lets add some data in model class
        final List<DataModelCovid> dataModelCovidList = new ArrayList<>();
        dataModelCovidList.add(new DataModelCovid("Apa itu Virus Covid-19", "Virus Cororna adalah virus yang menular kepada manusia. Virus ini bisa menyerang siapa saja, seperti lansia(golongan lanjut usia), orang dewasa, anak-anak, dan bayi, termasuk ibu hamil dan menyusui.",R.drawable.ic_covid_19));
        dataModelCovidList.add(new DataModelCovid("Asal Mula Covid-19 ditemukan", "Pertama kali ditemukan di kota Wuhan, China pada akhir Desember 2019. Virus ini menular dengan sangat cepat dan telah menyebar ke hampir semua negara, ternasuk Indonesia, hanya dalam waktu beberapa bulan.",R.drawable.ic_wuhan));
        dataModelCovidList.add(new DataModelCovid("Tingkat Kematian akibat Virus Corona", "Menurut data yang dirilis Gugus Tugas Covid jumlah kasus terconfirmasi positif hingga 03 Mei 2021 adalah 1.677.274 orang dengan jumlah kematian 45.796 orang. Tingkat kematian akibat Covid-19 adalah sekitar 2,7%.",R.drawable.ic_dead_body));

        setOnBoardingViewPagerAdapter(dataModelCovidList);
        position = viewPagerCovid.getCurrentItem();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < dataModelCovidList.size()){
                    position++;
                    viewPagerCovid.setCurrentItem(position);
                }
                if (position == dataModelCovidList.size()){
                    Intent intent = new Intent(CovidActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (tab.getPosition() == dataModelCovidList.size() - 1 ){
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

    private void setOnBoardingViewPagerAdapter(List<DataModelCovid> dataModelCovidList){
        viewPagerCovid = findViewById(R.id.screenPager);
        adapterCovid = new AdapterCovid(this, dataModelCovidList);
        viewPagerCovid.setAdapter(adapterCovid);
        tabLayout.setupWithViewPager(viewPagerCovid);
    }
}