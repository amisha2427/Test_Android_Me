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

public class MiddleBodyPart extends Fragment {

    ImageView imageView;

    private List<Integer> mBImageIds;
    private int mBindex;
    public String CurrImage = "images" , CurrIndex = "index";

    public MiddleBodyPart() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_middle_body_part,container,false);
        imageView = (ImageView) rootview.findViewById(R.id.middle_body_part);

        if(savedInstanceState != null)
        {

            mBImageIds = savedInstanceState.getIntegerArrayList(CurrImage);
            mBindex = savedInstanceState.getInt(CurrIndex);
        }

        if(mBImageIds!= null)
        {
            imageView.setImageResource(mBImageIds.get(mBindex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mBindex<mBImageIds.size()-1)
                        mBindex++;
                    else
                        mBindex = 0;

                    imageView.setImageResource(mBImageIds.get(mBindex));

                }
            });

        } else {

            Toast.makeText(getActivity(),"The Body Image List is null",Toast.LENGTH_LONG).show();
        }
        return rootview;
    }

    public void setmBImageIds(List<Integer> bImageIds) {

        mBImageIds = bImageIds;
    }

    public void setmBindex(int bIndex) {
        mBindex = bIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currState) {

        currState.putIntegerArrayList(CurrImage, (ArrayList<Integer>) mBImageIds);
        currState.putInt(CurrIndex , mBindex);
    }
}
