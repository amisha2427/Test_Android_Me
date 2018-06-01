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

public class BodyPartFragment extends Fragment {

    ImageView imageView;
    private List<Integer> mImageIDs;
    private int mindex;
    public String CurrImage = "images ",CurrId="indices";

    public BodyPartFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_body_part,container,false);
        imageView = (ImageView) rootview.findViewById(R.id.body_part_imageview);
        if(savedInstanceState != null)
        {
            mImageIDs = savedInstanceState.getIntegerArrayList(CurrImage);
            mindex =savedInstanceState.getInt(CurrId);
        }

        if(mImageIDs!=null)
        {
            imageView.setImageResource(mImageIDs.get(mindex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mindex<mImageIDs.size()-1)
                    {
                        mindex++;
                    } else {
                        mindex =0;
                    }
                    imageView.setImageResource(mImageIDs.get(mindex));

                }
            });



        } else {
            Toast.makeText(getActivity(),"Imagelist is null",Toast.LENGTH_LONG).show();
        }


        return rootview;

    }

public void setmImageIDs(List<Integer> images)
{

    mImageIDs = images;
}
public void setMindex(int index)
{
    mindex=index;
}

    @Override
    public void onSaveInstanceState(Bundle currstate) {
        currstate.putIntegerArrayList(CurrImage, (ArrayList<Integer>) mImageIDs);
        currstate.putInt(CurrId,mindex);

    }
}
