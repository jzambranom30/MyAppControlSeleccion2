package com.example.myappcontrolseleccion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myappcontrolseleccion2.Adaptadores.AdaptadorNoticias;
import com.example.myappcontrolseleccion2.Modelos.Noticia;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATA
        Noticia[] noticias =
                new Noticia[]{
                        new Noticia("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticia("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticia("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticia("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4"),
                        new Noticia("Noticia 5", "SubNoticia Contenido Contenido Contenido Contenido 5"),
                        new Noticia("Noticia 6", "SubNoticia Contenido Contenido Contenido Contenido 6"),
                        new Noticia("Noticia 7", "SubNoticia Contenido Contenido Contenido Contenido 7"),
                        new Noticia("Noticia 8", "SubNoticia Contenido Contenido Contenido Contenido 8"),
                        new Noticia("Noticia 9", "SubNoticia Contenido Contenido Contenido Contenido 9"),
                        new Noticia("Noticia 10", "SubNoticia Contenido Contenido Contenido Contenido 10")};

        //ADAPTADOR
        AdaptadorNoticias adaptadorNoticias= new AdaptadorNoticias(this, noticias);
        //VISTA
        ListView lstOpciones=(ListView) findViewById(R.id.lwItems);
        View header = getLayoutInflater().inflate(R.layout.lyheadernoticias, null);
        lstOpciones.addHeaderView(header);
        lstOpciones.setAdapter(adaptadorNoticias);
        lstOpciones.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Noticia noticiaseleccionada = (Noticia) parent.getItemAtPosition(position);

        Toast.makeText(this,"Ha Seleccionado: " + noticiaseleccionada.getTitulo()
        ,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, VerNoticia.class);
        Bundle bundle= new Bundle();
        bundle.putString("titulo", noticiaseleccionada.getTitulo());
        bundle.putString("subtitulo", noticiaseleccionada.getSubtitulo());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}