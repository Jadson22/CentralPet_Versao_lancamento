package appcentralpet.com.newcentralpet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class Ebook extends AppCompatActivity {

    RelativeLayout adBrasil;
    RelativeLayout adGuia;
    RelativeLayout adCachorrro;
    RelativeLayout manCachorro;
    RelativeLayout monetize;
    RelativeLayout monetize2;
    RelativeLayout monetize3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Ebook's");


        adBrasil = (RelativeLayout) findViewById(R.id.adBrasil);
        adBrasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://go.hotmart.com/S8721748V"));
                startActivity(ava);
            }
        });

        adGuia = (RelativeLayout) findViewById(R.id.adguia);
        adGuia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://go.hotmart.com/J8707936D"));
                startActivity(ava);
            }
        });

        adCachorrro = (RelativeLayout) findViewById(R.id.adcachorro);
        adCachorrro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://go.hotmart.com/S8707944F"));
                startActivity(ava);
            }
        });

        manCachorro = (RelativeLayout) findViewById(R.id.manCachorro);
        manCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://go.hotmart.com/G8764212L"));
                startActivity(ava);
            }
        });

        monetize = (RelativeLayout) findViewById(R.id.Monetize);
        monetize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.monetizze.com.br/checkout/KQZ27452"));
                startActivity(ava);
            }
        });

        monetize2 = (RelativeLayout) findViewById(R.id.Monetize2);
        monetize2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.monetizze.com.br/r/AFL1498768"));
                startActivity(ava);
            }
        });

        monetize3 = (RelativeLayout) findViewById(R.id.Monetize3);
        monetize3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.monetizze.com.br/r/ADS1498847"));
                startActivity(ava);
            }
        });
    }
}
