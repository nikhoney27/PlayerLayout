package com.nickworld.playerlayout.adapters;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nickworld.playerlayout.R;
import com.nickworld.playerlayout.models.HeaderModel;

import java.util.ArrayList;


/**
 * Created by Nikhil Sharma on 6/9/2017.
 */

public class SlidingAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<HeaderModel> modelArrayList;
    private LayoutInflater layoutInflater;

    public SlidingAdapter(Context context, ArrayList<HeaderModel> modelArrayList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.top_header_layout, container, false);

        TextView imageText = (TextView) view.findViewById(R.id.head_title);
        imageText.setText(modelArrayList.get(position).getImagetitle());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
