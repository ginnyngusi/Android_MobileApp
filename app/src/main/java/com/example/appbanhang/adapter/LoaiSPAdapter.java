package com.example.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appbanhang.R;
import com.example.appbanhang.model.LoaiSP;

import java.util.List;

public class LoaiSPAdapter extends BaseAdapter {

    List <LoaiSP> array;
    Context context;

    public LoaiSPAdapter(Context context, List<LoaiSP> array) {
        this.array = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;

    }

    public class ViewHolder {
        TextView textTenSP;
        ImageView imageSP;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_sampham, null);
            viewHolder.textTenSP = view.findViewById(R.id.item_tensp);
            viewHolder.imageSP = view.findViewById(R.id.item_image);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textTenSP.setText(array.get(i).getProduct_name());
        Glide.with(context).load(array.get(i).getImage()).into(viewHolder.imageSP);
        return view;
    }
}
