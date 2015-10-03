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
            R.drawable.y_u_no, R.drawable.new1,
            R.drawable.new2, R.drawable.new3,
            R.drawable.new4, R.drawable.new5,
            R.drawable.new6, R.drawable.new7,
            R.drawable.new8, R.drawable.new11,
            R.drawable.new10, R.drawable.new13,
            R.drawable.new12, R.drawable.new15,
            R.drawable.new14, R.drawable.new17,
            R.drawable.new16, R.drawable.new19,
            R.drawable.new18, R.drawable.new21,
            R.drawable.new20, R.drawable.new23,
            R.drawable.new22, R.drawable.new25,
            R.drawable.new24, R.drawable.new27,
            R.drawable.new26, R.drawable.new29,
            R.drawable.new28, R.drawable.new31,
            R.drawable.new30, R.drawable.new33,
            R.drawable.new32, R.drawable.new35,
            R.drawable.new34, R.drawable.new37,
            R.drawable.new36, R.drawable.new39,
            R.drawable.new38, R.drawable.new41,
            R.drawable.new40, R.drawable.new43,
            R.drawable.new42, R.drawable.new45,
            R.drawable.new44, R.drawable.new9,
            R.drawable.new46, R.drawable.new47,
            R.drawable.new48, R.drawable.new49,
            R.drawable.new50, R.drawable.new51,
            R.drawable.new52, R.drawable.new53,
            R.drawable.new54, R.drawable.new55,
            R.drawable.new56, R.drawable.new57,
            R.drawable.new58, R.drawable.new59,
            R.drawable.new60,
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
        imageView.setLayoutParams(new GridView.LayoutParams(160, 160));
        return imageView;
    }


}
