package com.desimeme.jai.desimeme;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jai on 9/26/2015.
 */
public class ImageAdapt extends BaseAdapter{

    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.cereal_guy_spitting, R.drawable.cuteness_overload,
            R.drawable.desk_flip, R.drawable.facepalm_picard,
            R.drawable.if_you_know_what_i_mean_mr_bean_blank, R.drawable.fuck_that_yao_ming,
            R.drawable.me_gusta_creepy, R.drawable.lol,
            R.drawable.oh_you_so_cute, R.drawable.no,
            R.drawable.troll_face, R.drawable.okay_guy,
            R.drawable.you_dont_say, R.drawable.forever_alone_happy,
            R.drawable.fuck_yeah_close_enough, R.drawable.im_watching_u,
            R.drawable.obama_not_bad, R.drawable.pokerface_2_clean,
            R.drawable.true_story, R.drawable.rainbow_puke,
            R.drawable.y_u_no
    };

    // Constructor
    public ImageAdapt (Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(165, 165));
        return imageView;
    }


}
