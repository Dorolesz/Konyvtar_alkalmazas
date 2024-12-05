package com.example.konyvtar_alkalmazas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextKonyvCime;
    private EditText editTextSzerzoNeve;
    private EditText editTextOldalakSzama;
    private Button addButton;
    private ListView konyvekListaView;
    private List<Konyv> konyvekLista;
    private KonyvekListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addKonyv();
            }
        });

        konyvekListaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Konyv selectedKonyv = konyvekLista.get(position);
                // Navigálás a részletes oldalra
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("konyvNeve", selectedKonyv.getKonyvCime());
                intent.putExtra("szerzoNeve", selectedKonyv.getSzerzoNeve());
                intent.putExtra("oldalszam", selectedKonyv.getOldalakSzama());
                startActivity(intent);
            }
        });
    }

        private void addKonyv() {
            String konyvCime = editTextKonyvCime.getText().toString().trim();
            String szerzoNeve = editTextSzerzoNeve.getText().toString().trim();
            String oldalszamStr = editTextOldalakSzama.getText().toString().trim();

            // Ellenőrzés
            if (konyvCime.isEmpty() || szerzoNeve.isEmpty() || oldalszamStr.isEmpty()) {
                Toast.makeText(this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                return;
            }

            int oldalszam;
            try {
                oldalszam = Integer.parseInt(oldalszamStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Az oldalszámnak számnak kell lennie!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (oldalszam < 50) {
                Toast.makeText(this, "Az oldalszámnak legalább 50-nek kell lennie!", Toast.LENGTH_SHORT).show();
                return;
            }

            Konyv konyv = new Konyv(konyvCime, szerzoNeve, oldalszam);
            konyvekLista.add(konyv);
            adapter.notifyDataSetChanged();

            editTextKonyvCime.setText("");
            editTextSzerzoNeve.setText("");
            editTextOldalakSzama.setText("");
        }
    public void init(){
        editTextKonyvCime = findViewById(R.id.editTextKonyvCime);
        editTextSzerzoNeve = findViewById(R.id.editTextSzerzoNeve);
        editTextOldalakSzama = findViewById(R.id.editTextOldalakSzama);
        addButton = findViewById(R.id.addButton);

        konyvekListaView = findViewById(R.id.konyvekListaView);
        konyvekLista = new ArrayList<>();
        adapter = new KonyvekListaAdapter(this, konyvekLista);
        konyvekListaView.setAdapter(adapter);
    }
}