package com.sg.banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner mBanner;
    private List<ImageBean> mList = new ArrayList<>();

    private void initView(){
        mBanner = (Banner) findViewById(R.id.banner);
        mBanner.setAdapter(new ImageAdapter(MainActivity.this, mList));

        /*
        Banner banner = mBanner.setAdapter(new BannerImageAdapter<Integer>(mList) {
            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }

        });

         */
        mBanner.isAutoLoop(true);
        mBanner.setIndicator(new CircleIndicator(this));
        mBanner.start();
    }

    private void initData(){
        mList.add(new ImageBean(R.drawable.a));
        mList.add(new ImageBean(R.drawable.b));
        mList.add(new ImageBean(R.drawable.c));
        mList.add(new ImageBean(R.drawable.d));
        mList.add(new ImageBean(R.drawable.e));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();

    }

}
