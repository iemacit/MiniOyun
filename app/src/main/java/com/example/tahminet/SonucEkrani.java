package com.example.tahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucEkrani extends AppCompatActivity {
    ImageView resim;
    TextView textSonucu,texttBilgi;
    Button tekrarDene;

    Boolean sonuc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_ekrani);
        resim=findViewById(R.id.rsm);
        textSonucu=findViewById(R.id.bilgi);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.yazi);
        textSonucu.startAnimation(animation);
        Animation snim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.dondur);
        resim.startAnimation(snim);
        sonuc=getIntent().getBooleanExtra("sonuc",false);
        tekrarDene=findViewById(R.id.tekrar);
        texttBilgi=findViewById(R.id.zekaBilgis);
        if(sonuc){
            resim.setImageResource(R.drawable.baseline_emoji_events_24);
            Intent intten=getIntent();
            String sayi=intten.getStringExtra("say");
            textSonucu.setText("TEBRİKLER KAZANDINIZ ");
            int sayac=Integer.valueOf(sayi);
            if(sayac<=10 && sayac>8){
                texttBilgi.setText("Tahmin Yeteneğin Çok İyi\n "+"BAŞARI ORANI ½"+(10*(sayac+1)));
            } else if (sayac<=8 && sayac>=6) {
                texttBilgi.setText("Tahmin Yeteneğin İyi\n"+"BAŞARI ORANI ½"+(10*(sayac+1)));
            }
            else if (sayac<=5 && sayac>3) {
                texttBilgi.setText("Tahmin Yeteneğin Normal\n"+"BAŞARI ORANI ½"+(10*(sayac+1)));
            }
            else if (sayac<=3 && sayac>0) {
                texttBilgi.setText("Tahmin Yeteneğin Kötü\n"+"BAŞARI ORANI ½"+(10*(sayac+1)));
            }
            else{
                 texttBilgi.setText("Tahmin Yeteneğin Berbat Gelişmelisin\n"+"BAŞARI ORANI ½0");
                }



        }
        else {
            resim.setImageResource(R.drawable.kaybettin);
            textSonucu.setText("AHHH BEEEE  KAYBETTİNİZ");
            texttBilgi.setText("Tahmin Yeteneğin Berbat Gelişmelisin\n"+"BAŞARI ORANI ½0");

        }




        tekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(SonucEkrani.this,Tahmin.class);
                startActivity(a);
                finish();
            }
        });
    }

}