package com.prueba.grid.vista;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.prueba.grid.R;

/**
 * Created by choqu_000 on 22/01/2016.
 */
public class DetailsActivity extends ActionBarActivity {

    //Atributos
    TextView titleTextView;
    ImageView imageView;


    //Crear la actividad
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.details_activity);

        String title = getIntent().getStringExtra("title");
        Bitmap bitmap = getIntent().getParcelableExtra("image");

        //intancia de objeto de la Actividad
        titleTextView = (TextView)findViewById(R.id.title);
        titleTextView.setText(title);
        //Imagen
        imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);

    }
}
