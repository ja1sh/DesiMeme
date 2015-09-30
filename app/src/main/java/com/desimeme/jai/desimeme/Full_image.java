package com.desimeme.jai.desimeme;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Full_image extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapt imageAdapter = new ImageAdapt(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection


        OutputStream output;


        // Retrieve the image from the res folder
        ImageView image = (ImageView) findViewById(R.id.full_image_view);
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        // Find the SD Card path

        // Create a new folder in SD Card
        File dir = new File(Environment.getExternalStorageDirectory() + "/desiCache");

        dir.mkdirs();

        // Create a name for the saved image
        File file = new File(dir, "temp.png");


        try {

            output = new FileOutputStream(file);

            // Compress into png format image from 0% - 100%
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        switch (item.getItemId()) {
            case R.id.action_share:
                Uri uri = Uri.fromFile(file);

                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.setType("image/png");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.action_share)));
                }
        return true;

        }
    }