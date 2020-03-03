package com.ims_hr.latihan10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LuasActivity extends AppCompatActivity {

    TextView TV_Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);
        Inisial();
        Set_Object();
    }

    private void Inisial() {
        TV_Hasil = findViewById(R.id.textView_Luas_Hasil);
    }


    private void Set_Object() {
        Intent intent = getIntent();
        int Nilai_Luas = intent.getIntExtra("luas",0);
        TV_Hasil.setText("Luas Persegi adalah: " + Nilai_Luas);
    }

}
