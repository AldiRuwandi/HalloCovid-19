package com.example.hallocovid_19.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hallocovid_19.R;
import com.example.hallocovid_19.model.DataModelGejala;

import java.util.List;

public class AdapterGejala extends PagerAdapter {

    Context context;
    List<DataModelGejala> dataModelGejalaList;

    public AdapterGejala(Context context, List<DataModelGejala> dataModelGejalaList) {
        this.context = context;
        this.dataModelGejalaList = dataModelGejalaList;
    }

    @Override
    public int getCount() {
        return dataModelGejalaList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //now we will create a viewpager layout file
        View view = LayoutInflater.from(context).inflate(R.layout.onboardinggejala, null);
        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.imageViewGejala);
        title = view.findViewById(R.id.titleGejala);
        desc = view.findViewById(R.id.descGejala);

        imageView.setImageResource(dataModelGejalaList.get(position).getImageUrl());
        title.setText(dataModelGejalaList.get(position).getTitle());
        desc.setText(dataModelGejalaList.get(position).getDesc());

        container.addView(view);

        return view;
    }
}
