package com.desimeme.jai.desimeme;

import android.app.Activity;
import android.os.Bundle;

import android.widget.GridView;
/**
 * Created by jai on 9/26/2015.
 */
public class GridAct extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapt(this));

    }




}
