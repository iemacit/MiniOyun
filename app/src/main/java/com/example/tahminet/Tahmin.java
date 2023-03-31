package com.example.tahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Tahmin extends AppCompatActivity {
    TextView hakSayisi,ipucu;
    EditText tahmin;
    Button onay;

    int rasgeleSayi;
    public int sayac=10;
    public int getSayac(){
        return sayac;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        hakSayisi=findViewById(R.id.kalanHak);
        ipucu=findViewById(R.id.ipucu);
        tahmin=findViewById(R.id.tahminEt);
        onay=findViewById(R.id.onayla);

        Random r=new Random();
        rasgeleSayi=r.nextInt(101);
        Log.e("Rasgele Sayi",String.valueOf(rasgeleSayi));
        System.out.println(rasgeleSayi);
        tahmin.setShowSoftInputOnFocus(false);
        tahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.app_name).equals(tahmin.getText().toString())) {
                    tahmin.setText("");
                }
            }
        });

        onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tahminim = Integer.parseInt(tahmin.getText().toString());
                if (tahminim > 100) {
                    ipucu.setText("100 den Kücük Değer giriniz");
                }
                else{
                    sayac -= 1;


                    if (sayac != 0) {

                        if (tahminim == rasgeleSayi) {


                            Intent a = new Intent(Tahmin.this, SonucEkrani.class);
                            String as = String.valueOf(sayac);
                            a.putExtra("say", as);
                            a.putExtra("sonuc", true);

                            startActivity(a);
                            finish();
                        }
                        if (tahminim < rasgeleSayi) {
                            ipucu.setText("Hoppp sayıyı artır");
                        }
                        if (tahminim > rasgeleSayi) {
                            ipucu.setText("Çok uçtun Reis Sayıyı Azalt");
                        }
                        hakSayisi.setText("Kalan Hakkınız : " + sayac);
                    } else {
                        Intent a = new Intent(Tahmin.this, SonucEkrani.class);
                        a.putExtra("sonuc", false);
                        startActivity(a);
                        finish();
                    }
                    tahmin.setText("");
                }
            }
        });

    }
    public void onClickbutton(View view) {
        switch (view.getId()) {
            case R.id.button0:
                updateDisplay("0");
                break;
            case R.id.button1:
                updateDisplay("1");
                break;
            case R.id.button2:
                updateDisplay("2");
                break;
            case R.id.button3:
                updateDisplay("3");
                break;
            case R.id.button4:
                updateDisplay("4");
                break;
            case R.id.button5:
                updateDisplay("5");
                break;
            case R.id.button6:
                updateDisplay("6");
                break;
            case R.id.button7:
                updateDisplay("7");
                break;
            case R.id.button8:
                updateDisplay("8");
                break;
            case R.id.button9:
                updateDisplay("9");
                break;
            case R.id.temizle:
                tahmin.setText("");
                break;


        }

    }

    private void updateDisplay(String addChar) {
        int cursurPos = tahmin.getSelectionStart();
        if (getString(R.string.app_name).equals(tahmin.getText().toString())) {
            tahmin.setText(addChar);
        } else {
            String oldTest = tahmin.getText().toString();
            String leftSideofText = oldTest.substring(0, cursurPos);
            String rightSideText = oldTest.substring(cursurPos);
            String newTest = leftSideofText + addChar + rightSideText;
            tahmin.setText(newTest);
            ;
        }
        tahmin.setSelection(cursurPos + 1);
    }
}