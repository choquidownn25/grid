package com.prueba.grid;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.prueba.grid.adaptador.GridViewAdapter;
import com.prueba.grid.datos.ImageItem;
import com.prueba.grid.vista.DetailsActivity;
import com.prueba.grid.vista.prueba;

import java.util.ArrayList;

/**
 * Created by choqu_000 on 22/01/2016.
 */
public class GridActiviti extends ActionBarActivity {
    //Atributos
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;

    //Creacion de vista
    protected void onCreate(Bundle savedInstanceState){
        //invoca cuando la actividad se inicia
        super.onCreate(savedInstanceState);
        //defini los recurso XML que contiene el layout
        // de la interfaz de usuario
        setContentView(R.layout.activity_main);

        //Llamado de instacia de la gridview
        gridView = (GridView)findViewById(R.id.gridView);
        gridViewAdapter=new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridViewAdapter);

        //click en la imegen
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                if (position == 4) {
                    Intent intent = new Intent(GridActiviti.this, prueba.class);
                    startActivity(intent);
                }else{

                    //Create intent
                    Intent intent = new Intent(GridActiviti.this, DetailsActivity.class);
                    intent.putExtra("title", item.getTitle());
                    intent.putExtra("image", item.getImage());

                    //Start details activity
                    startActivity(intent);
                }

            }
        });


    }

    //Preparar algunos datos ficticios para gridview
    private ArrayList<ImageItem>getData(){
        final  ArrayList<ImageItem>imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        for(int i=0; i<imgs.length(); i ++){
            //entra al cuadro de la x
            if(i%2 ==0){

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
                if (i==1)
                {
                    imageItems.add(new ImageItem(bitmap, "Orden serv" + i));
                }else{
                    imageItems.add(new ImageItem(bitmap, "Image#" + i));
                }
            }else {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_2);
                imageItems.add(new ImageItem(bitmap, "Image#" + i));
            }


        }

        return  imageItems;
    }


}
