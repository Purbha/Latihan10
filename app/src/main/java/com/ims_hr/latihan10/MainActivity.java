package com.ims_hr.latihan10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView IV_Header;
    Button B_Switch, B_Submit;
    private int Indeks = 1, Nilai_Panjang = 0, Nilai_Lebar = 0;
    SeekBar SB_Panjang, SB_Lebar;
    TextView TV_Panjang, TV_Lebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_Switch();
        Listen_B_Submit();
        Listen_SeekBar();
    }

    private void Inisial() {
        IV_Header = findViewById(R.id.imageView_Main_Header);
        B_Switch = findViewById(R.id.button_Main_Switch);
        B_Submit = findViewById(R.id.button_Main_Submit);
        SB_Panjang = findViewById(R.id.seekBar_Main_Panjang);
        SB_Lebar = findViewById(R.id.seekBar_Lebar);
        TV_Panjang = findViewById(R.id.textView_Main_PanjangVal);
        TV_Lebar = findViewById(R.id.textView_Main_LebarVal);
    }

    private void Listen_B_Switch() {
        B_Switch.setOnClickListener(v -> {
            if (Indeks == 1){
                IV_Header.setImageResource(R.drawable.bg2);
                Indeks++;
            } else {
                IV_Header.setImageResource(R.drawable.bg1);
                Indeks--;
            }
        });
    }

    private void Listen_B_Submit() {
        B_Submit.setOnClickListener(v -> {
            final int Nilai_Luas = Nilai_Panjang * Nilai_Lebar;
            final int Nilai_Kell = 2 * (Nilai_Panjang + Nilai_Lebar);
            AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Silakan pilih menghitung Luas atau Keliling:")
                    .setCancelable(false)
                    .setPositiveButton("Luas", (dialog, which) -> {
                        Intent intent = new Intent(MainActivity.this,LuasActivity.class);
                        intent.putExtra("luas",Nilai_Luas);
                        startActivity(intent);
                    })
                    .setNegativeButton("Keliling", (dialog, which) -> {
                        Intent intent = new Intent(MainActivity.this,KellActivity.class);
                        intent.putExtra(KellActivity.KUNCI_KELL,Nilai_Kell);
                        startActivity(intent);
                    });
            AlertDialog alert = a_builder.create();
            alert.setTitle("Konfirmasi");
            alert.show();
        });
    }

    private void Listen_SeekBar() {
        String Teks_Panjang = String.valueOf(SB_Panjang.getProgress());
        TV_Panjang.setText(Teks_Panjang);
        SB_Panjang.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Nilai_Panjang = progress;
                TV_Panjang.setText(String.valueOf(Nilai_Panjang));
                //TV_Panjang.setText(String.valueOf(SB_Panjang.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        String Teks_Lebar = String.valueOf(SB_Lebar.getProgress());
        TV_Lebar.setText(Teks_Lebar);
        SB_Lebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Nilai_Lebar = progress;
                TV_Lebar.setText(String.valueOf(progress));
                //TV_Lebar.setText(String.valueOf(SB_Lebar.getProgress()));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

}
