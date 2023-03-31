package com.example.tahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button basla;
    TextView bilgiVer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basla=findViewById(R.id.basla);
        bilgiVer=findViewById(R.id.bilgilendir);
        bilgiVer.setText("KALAN TAHMİN HAKKINIZ :\n"+"8-10 Arasında ise Tahmin Yeteneğiniz ÇOK İYİ\n"+"5-8 Arasında ise Tahmin Yeteneğiniz İYİ\n"+"3-5 Arasında ise Tahmin   NORMAL\n"+"1-3 Arasında ise Tahmin Yeteneğiniz KÖTÜ\n"+"0 ise Tahmin Yeteneğiniz BERBAT\n");
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.yazi2);
        bilgiVer.startAnimation(animation);
        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this,Tahmin.class);
                startActivity(a);
            }
        });
    }
}