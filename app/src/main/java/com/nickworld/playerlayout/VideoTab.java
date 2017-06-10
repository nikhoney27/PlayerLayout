package com.nickworld.playerlayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nickworld.playerlayout.adapters.VideoAdapter;

/**
 * Created by Nikhil Sharma on 6/9/2017.
 */

public class VideoTab extends Fragment {

    private RecyclerView mVideoRecyclerView;
    VideoAdapter mVideoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View videoView = inflater.inflate(R.layout.video_tab_layout, container, false);

        //initializing recycler and setting up the adapter with linearLayout
        mVideoRecyclerView = (RecyclerView) videoView.findViewById(R.id.videoRecyclerView);
        mVideoRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mVideoAdapter = new VideoAdapter();
        mVideoRecyclerView.setAdapter(mVideoAdapter);


        return videoView;
    }
}
