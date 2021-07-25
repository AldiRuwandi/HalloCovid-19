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
import com.example.hallocovid_19.model.DataModelGejala;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class GelajaActivity extends AppCompatActivity {

    AdapterGejala adapterGejala;
    TabLayout tabLayout;
    ViewPager viewPagerGejala;

    Button nextButton;
    ImageView imageBack;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelaja);

        nextButton = findViewById(R.id.next);
        tabLayout = findViewById(R.id.tabIndicator);

        //now lets add some data in model class
        final List<DataModelGejala> dataModelGejalaList = new ArrayList<>();
        dataModelGejalaList.add(new DataModelGejala("Demam dan Menggigil", "Demam biasanya muncul pada orang yang terinfeksi Covid-19, dengan suhu lebih dari 37,7 derajat celcius, karena ini merupakan cara virus menghasilkan demam.", R.drawable.ic_fever));
        dataModelGejalaList.add(new DataModelGejala("Batuk Kering", "Batuk para seorang yang terpapar corona akan sangat mengganggu, terasa seolah berasal dari sesuatu yang jauh didalam dada. Batuk yang terjadi merupakan batuk kering, yang tidak mengeluarkan lendir atau dahak dari saluran pernafasan.", R.drawable.ic_sneeze));
        dataModelGejalaList.add(new DataModelGejala("Kelelahan", "Kelelahan ekstrim dapa menjadi tanda seseorang terpapar corona. Ini menjadi pertanda imun merespon adanya infeksi, sehingga tubuh terasa lelah. Namun, lelah akibat Covid-19 biasanya disertai gejala lain seperti nyeri otot dan sakit tenggorokan.", R.drawable.ic_worktable));

        setOnboardingViewPagerAdapter(dataModelGejalaList);
        position = viewPagerGejala.getCurrentItem();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < dataModelGejalaList.size()){
                    position++;
                    viewPagerGejala.setCurrentItem(position);
                }
                if (position == dataModelGejalaList.size()){
                    Intent intent = new Intent(GelajaActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (tab.getPosition() == dataModelGejalaList.size() - 1){
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

    private void setOnboardingViewPagerAdapter(List<DataModelGejala>dataModelGejalaList){
        viewPagerGejala = findViewById(R.id.screenPager1);
        adapterGejala = new AdapterGejala(this, dataModelGejalaList);
        viewPagerGejala.setAdapter(adapterGejala);
        tabLayout.setupWithViewPager(viewPagerGejala);
    }
}