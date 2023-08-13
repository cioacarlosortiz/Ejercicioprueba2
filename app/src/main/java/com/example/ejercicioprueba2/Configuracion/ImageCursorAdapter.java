package com.example.ejercicioprueba2.Configuracion;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ejercicioprueba2.R;

public class ImageCursorAdapter extends CursorAdapter {

    public ImageCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_image, parent, false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = view.findViewById(R.id.ImagePerson);
        EditText nombre = view.findViewById(R.id.PersonName);
        EditText descripcion = view.findViewById(R.id.PersonDescrip);
        String imageUri = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_IMAGE_URI));

        Glide.with(context)
                .load(imageUri)
                .into(imageView);
    }
}
