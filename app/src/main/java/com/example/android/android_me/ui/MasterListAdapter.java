package com.example.android.android_me.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;

public class MasterListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public Context mcontext;
    public  List<ModalClassMaster> bodyImageIds;
    LayoutInflater inflater;

    public MasterListAdapter(Context mcontext, List<ModalClassMaster> bodyImageIds) {
        this.mcontext = mcontext;
        this.bodyImageIds = bodyImageIds;
        inflater = LayoutInflater.from(mcontext);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mview = inflater.inflate(R.layout.master_singe_item_list,parent,false);
        MyViewHolder holder = new MyViewHolder(mview);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ModalClassMaster current =  bodyImageIds.get(position);
        holder.imageView.setImageResource(current.getImageId());

    }

    @Override
    public int getItemCount() {
        return bodyImageIds.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder
{
    ImageView imageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.recycler_Imageview);
    }
}
