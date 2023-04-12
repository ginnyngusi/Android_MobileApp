package com.example.appbanhang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appbanhang.Interface.ItemClickListener;
import com.example.appbanhang.R;
import com.example.appbanhang.activity.ChitietActivity;
import com.example.appbanhang.model.SanPhamMoi;

import java.text.DecimalFormat;
import java.util.List;

public class BackWoodAdapter extends RecyclerView.Adapter<BackWoodAdapter.MyViewHolder> {
    Context context;
    List<SanPhamMoi> array;


    public BackWoodAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_backwoods, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         SanPhamMoi sanPham = array.get(position);
         holder.tensp.setText(sanPham.getProduct_name());
         DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
         holder.giasp.setText("Price: "+decimalFormat.format(Double.parseDouble(sanPham.getPrice()))+ "Đ");
         holder.mota.setText(sanPham.getMota());
         Glide.with(context).load(sanPham.getImage()).into(holder.hinhanh);
         holder.setItemClickListener(new ItemClickListener() {
             @Override
             public void onClick(View view, int pos, boolean isLongClick) {
                 if(!isLongClick){
                     //click
                     Intent intent = new Intent(context, ChitietActivity.class);
                     intent.putExtra("chitiet", sanPham);
                     intent.addFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
                     context.startActivity(intent);
                 }
             }
         });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tensp, giasp, mota;
        ImageView hinhanh;
        private ItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            tensp = itemView.findViewById(R.id.itembw_name);
            giasp = itemView.findViewById(R.id.itembw_price);
            mota = itemView.findViewById(R.id.itembw_mota);
            hinhanh = itemView.findViewById(R.id.itembw_image);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view){
           itemClickListener.onClick(view, getAdapterPosition(), false);

        }
    }
}
