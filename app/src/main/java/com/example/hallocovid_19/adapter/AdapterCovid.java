package com.example.hallocovid_19.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hallocovid_19.R;
import com.example.hallocovid_19.model.DataModelCovid;

import java.util.List;

public class AdapterCovid extends PagerAdapter {

    Context context;
    List<DataModelCovid> dataModelCovidList;

    public AdapterCovid(Context context, List<DataModelCovid> dataModelCovidList) {
        this.context = context;
        this.dataModelCovidList = dataModelCovidList;
    }

    @Override
    public int getCount() {
        return dataModelCovidList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //now we will create a viewpager layout file
        View view = LayoutInflater.from(context).inflate(R.layout.onboardingcovid, null);
        ImageView imageView;
        TextView title, desc;
        ImageView imageBack;

        imageView = view.findViewById(R.id.imageView);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);
        imageBack = view.findViewById(R.id.imageBack);


        imageView.setImageResource(dataModelCovidList.get(position).getImageUrl());
        title.setText(dataModelCovidList.get(position).getTitle());
        desc.setText(dataModelCovidList.get(position).getDesc());

        container.addView(view);

        return view;
    }
}
