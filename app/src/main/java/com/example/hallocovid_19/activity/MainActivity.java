package com.example.hallocovid_19.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hallocovid_19.R;

public class MainActivity extends AppCompatActivity {

    private ImageView imageExit;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageExit = findViewById(R.id.imageExit);

        //create the dialog here
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);//Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;//setting the animation to dialog

        Button cancel = dialog.findViewById(R.id.btn_cancel);
        Button keluar = dialog.findViewById(R.id.btn_keluar);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        imageExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();//show the dialog here
            }
        });
    }

    public void GotoCovid(View view) {
        Intent gotoCovid = new Intent(MainActivity.this, CovidActivity.class);
        startActivity(gotoCovid);
    }

    public void GotoGejala(View view) {
        Intent gotogejala = new Intent(MainActivity.this, GelajaActivity.class);
        startActivity(gotogejala);
    }

    public void GotoPencegahan(View view) {
        Intent gotopencegahan = new Intent(MainActivity.this, PencegahanActivity.class);
        startActivity(gotopencegahan);
    }

    public void GotoRumahSakit(View view) {
        Intent gotorumahsakit = new Intent(MainActivity.this, RumahSakitActivity.class);
        startActivity(gotorumahsakit);
    }
}