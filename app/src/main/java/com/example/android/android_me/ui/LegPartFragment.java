package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class LegPartFragment extends Fragment {

    ImageView imageView;
    private List<Integer> mLImageIds;
    private int mLindex;
    public  String CurrImageIds = "images";
     public String CurrIndex = "index";

    public LegPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_leg_part,container,false);
        imageView = (ImageView) rootview.findViewById(R.id.leg_part_imageview);
        if( savedInstanceState!=null)
        {
            mLImageIds = savedInstanceState.getIntegerArrayList(CurrImageIds);
            mLindex = savedInstanceState.getInt(CurrIndex);
        }

        if(mLImageIds!=null)
        {
            imageView.setImageResource(mLImageIds.get(mLindex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mLindex < mLImageIds.size()-1)
                    {
                        mLindex++;
                    }
                    else
                    {
                        mLindex =0;
                    }
                    imageView.setImageResource(mLImageIds.get(mLindex));

                }
            });

        } else {
            Toast.makeText(getActivity(),"The Leg Image List is null",Toast.LENGTH_LONG).show();

        }
        return rootview;

    }


    public void setmLImageIds(List<Integer> mLImageIds) {
        this.mLImageIds = mLImageIds;
    }

    public void setmLindex(int mLindex) {
        this.mLindex = mLindex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putIntegerArrayList(CurrImageIds, (ArrayList<Integer>) mLImageIds);
        outState.putInt(CurrIndex,mLindex);

    }
}
