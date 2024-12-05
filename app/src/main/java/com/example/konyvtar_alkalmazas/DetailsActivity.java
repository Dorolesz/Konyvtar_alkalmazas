package com.example.konyvtar_alkalmazas;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailsKonyvCimeTextView;
    private TextView detailsSzerzoNeveTextView;
    private TextView detailsOldalakSzamaTextView;
    private TextView detailsRandomEvszamTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        detailsKonyvCimeTextView = findViewById(R.id.detailsKonyvCimeTextView);
        detailsSzerzoNeveTextView = findViewById(R.id.detailsSzerzoNeveTextView);
        detailsOldalakSzamaTextView = findViewById(R.id.detailsOldalakSzamaTextView);
        detailsRandomEvszamTextView = findViewById(R.id.detailsRandomEvszam);

        String konyvNeve = getIntent().getStringExtra("konyvNeve");
        String szerzoNeve = getIntent().getStringExtra("szerzoNeve");
        int oldalszam = getIntent().getIntExtra("oldalszam", 0);

        detailsKonyvCimeTextView.setText(konyvNeve);
        detailsSzerzoNeveTextView.setText(szerzoNeve);
        detailsOldalakSzamaTextView.setText(String.valueOf(oldalszam));


        Random random = new Random();
        int randomEvszam = random.nextInt(125) + 1900;
        detailsRandomEvszamTextView.setText(String.valueOf(randomEvszam));
    }
}
