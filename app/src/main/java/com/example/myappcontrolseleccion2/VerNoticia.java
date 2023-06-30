package com.example.myappcontrolseleccion2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VerNoticia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_noticia);

        Bundle bundle = this.getIntent().getExtras();

        TextView titnoticia=(TextView) findViewById(R.id.twTituloNoticia);
        titnoticia.setText(bundle.getString("titulo"));
        TextView subnoticia=(TextView) findViewById(R.id.twSubtituloNoticia);
        subnoticia.setText(bundle.getString("subtitulo"));
    }
}