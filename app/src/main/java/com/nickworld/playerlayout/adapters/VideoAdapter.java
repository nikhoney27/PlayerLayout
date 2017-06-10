package com.nickworld.playerlayout.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nickworld.playerlayout.R;

import static com.nickworld.playerlayout.R.id.parent;


/**
 * Created by HP on 10-06-2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    public VideoAdapter() {
    }

    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VideoAdapter.ViewHolder holder = null;
        View nonEmptyList = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_middle_layout, parent, false);
        holder = new ViewHolder(nonEmptyList);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoAdapter.ViewHolder _holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mtxtDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mtxtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
        }
    }
}
