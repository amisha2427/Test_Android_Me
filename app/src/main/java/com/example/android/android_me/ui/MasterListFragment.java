package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterListFragment extends Fragment {

    RecyclerView masterRecyclerView;

    ImageView imageView;
    List<ModalClassMaster> modalClassMasterList = new ArrayList<ModalClassMaster>();
    List<Integer> resID = new ArrayList<Integer>();

    MasterListAdapter masterListAdapter;

    public MasterListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_master,container,false);

        masterRecyclerView = (RecyclerView) rootview.findViewById(R.id.master_recycler_view);

        resID = AndroidImageAssets.getAll();

        for (int i=0;i<resID.size();i++)
        {
            int temp =resID.get(i);
            ModalClassMaster classMaster = new ModalClassMaster(temp);
            modalClassMasterList.add(classMaster);

        }


        int no_of_columns = 3;
        masterRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), no_of_columns));
        masterListAdapter = new MasterListAdapter(getContext(),modalClassMasterList);
        masterRecyclerView.setAdapter(masterListAdapter);

        return rootview;

    }
}
