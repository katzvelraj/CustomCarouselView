package com.msf.mycarousellayout.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.msf.mycarousellayout.R;
import com.msf.mycarousellayout.carousellayout.FeatureCoverFlow;

import java.util.ArrayList;



public class MainActivity extends ActionBarActivity {

    String nameArray[] = {"1","2","3","4","5"};


    private FeatureCoverFlow mCoverFlow;
    private MyCustomAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private TextSwitcher mTitle;
    View view ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverflow);
        view = (View)findViewById(R.id.view1);

       int id1 = getResources().getIdentifier("title1" + nameArray[0], "string",
                getPackageName());

       int id2 =  getResources().getIdentifier("title2" + nameArray[1], "string",
                getPackageName());

        getResources().getIdentifier("title3" + nameArray[2], "string",
                getPackageName());

        getResources().getIdentifier("title4" + nameArray[2], "string",
                getPackageName());


        mData.add(new GameEntity(R.drawable.circle_btn_bg,nameArray[0]));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, nameArray[1]));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, nameArray[2]));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, nameArray[3]));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, nameArray[4]));

        /*mData.add(new GameEntity(R.drawable.circle_btn_bg, R.string.title2));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, R.string.title2));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, R.string.title2));
        mData.add(new GameEntity(R.drawable.circle_btn_bg, R.string.title2));*/

        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_title, null);
                return textView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        mAdapter = new MyCustomAdapter(this);
        mAdapter.setData(mData);
        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mCoverFlow.setAdapter(mAdapter);
        //mAdapter.notifyAll();

        GameEntity vel = mData.get(0);
        String velraj = vel.titleRes;
        String raj = vel.titleRes;

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {

            }

            @Override
            public void onScrolling() {

            }
        });


        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               //  pos = position;
             /*   Toast.makeText(MainActivity.this,
                        getResources().getString(mData.get(position).titleResId),
                        Toast.LENGTH_SHORT).show();*/


            }
        });
        mCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                //  mTitle.setText(getResources().getString(mData.get(position).titleResId));
                //view.setVisibility(View.VISIBLE);
                pos = position;
            }

            @Override
            public void onScrolling() {
                mTitle.setText("");
                view.setVisibility(View.GONE);
            }
        });

    }


    public static int pos;



}
