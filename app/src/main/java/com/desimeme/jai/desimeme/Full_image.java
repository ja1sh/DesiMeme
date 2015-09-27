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

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_share) {
         //   return true;
        //}

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_share:
                // Handle item selection
                ImageView image = (ImageView) findViewById(R.id.full_image_view);
                Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap(); //file to be saved as per user selection
                if (isExternalStorageWritable()) {
                    String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
                    File ssd = new File(sd, "share");
                    if (!ssd.exists())
                        ssd.mkdirs();
                    String fileName = "temp"; //saved as png file
                    File dest = new File(ssd, fileName + ".jpg");
                    FileOutputStream out = null;
                    if (dest.canWrite()) {
                        dest.setWritable(true);
                    }
                    try {
                        out = new FileOutputStream(dest);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out); // bmp is your Bitmap instance
                        // PNG is a lossless format, the compression factor (100) is ignored
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (out != null) {
                                out.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    Uri uri = Uri.fromFile(dest);
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.setType("*/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.action_share))); //shared via Intent
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

