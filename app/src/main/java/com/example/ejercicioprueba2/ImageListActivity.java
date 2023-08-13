package com.example.ejercicioprueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ejercicioprueba2.Configuracion.DatabaseHelper;
import com.example.ejercicioprueba2.Configuracion.ImageCursorAdapter;

public class ImageListActivity extends AppCompatActivity {

    private ListView listView;
    private ImageCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        listView = findViewById(R.id.listView);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.query(DatabaseHelper.TABLE_PHOTOS, new String[]{DatabaseHelper.COLUMN_ID + " AS _id", DatabaseHelper.COLUMN_IMAGE_URI}, null, null, null, null, null);
        cursorAdapter = new ImageCursorAdapter(this, cursor);
        listView.setAdapter(cursorAdapter);

    }
}
