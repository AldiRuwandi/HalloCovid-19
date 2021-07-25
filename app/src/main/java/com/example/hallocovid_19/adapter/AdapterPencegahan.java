package com.example.hallocovid_19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hallocovid_19.R;
import com.example.hallocovid_19.model.DataModelPencegahan;

import java.util.List;

public class AdapterPencegahan extends PagerAdapter {

    Context context;
    List<DataModelPencegahan> dataModelPencegahanList;

    public AdapterPencegahan(Context context, List<DataModelPencegahan> dataModelPencegahanList) {
        this.context = context;
        this.dataModelPencegahanList = dataModelPencegahanList;
    }

    @Override
    public int getCount() {
        return dataModelPencegahanList.size();
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
        View view = LayoutInflater.from(context).inflate(R.layout.onboardingpencegahan, null);
        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.imageViewPencegahan);
        title = view.findViewById(R.id.titlePencegahan);
        desc = view.findViewById(R.id.descPencegahan);

        imageView.setImageResource(dataModelPencegahanList.get(position).getImageUrl());
        title.setText(dataModelPencegahanList.get(position).getTitle());
        desc.setText(dataModelPencegahanList.get(position).getDesc());


        container.addView(view);

        return view;
    }
}
