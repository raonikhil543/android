package com.scrapper.subbu.newsscrolling;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class IndianAdapter extends RecyclerView.Adapter<MyHolder> {

//    private Context mCtx;
//    private List<Indian> productList;
//
//    public IndianAdapter(Context mCtx, List<Indian> productList) {
//        this.mCtx = mCtx;
//        this.productList = productList;
//    }
//
//
//    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        View view = inflater.inflate(R.layout.activity_detail, null);
//        return new ProductViewHolder(view);
//    }
//
//
//    public void onBindViewHolder(ProductViewHolder holder, int position) {
//        Indian indian = productList.get(position);
//
//        //loading the image
////        Glide.with(mCtx)
////                .load(product.getImage())
////                .into(holder.imageView);
//
//        holder.textViewTitle.setText(indian.getNoti());
//        holder.textViewShortDesc.setText(indian.getDescp());
//
//    }
//
//
//    public int getItemCount() {
//        return productList.size();
//    }
//
//    class ProductViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
//       // ImageView imageView;
//
//        public ProductViewHolder(View itemView) {
//            super(itemView);
//
//            textViewTitle = itemView.findViewById(R.id.noti);
//            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
////            textViewRating = itemView.findViewById(R.id.textViewRating);
////            textViewPrice = itemView.findViewById(R.id.textViewPrice);
////            imageView = itemView.findViewById(R.id.imageView);
//        }
//    }

    Context c;
    ArrayList<Indian> indian;

    public IndianAdapter(Context c, ArrayList<Indian> indian) {
        this.c = c;
        this.indian = indian;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
     View view = inflater.inflate(R.layout.model, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final String name=indian.get(position).getNoti();
        //final int image=indian.get(position).getImage();
        final String desc=indian.get(position).getDescp();
       // final String desc1=spaceCrafts.get(position).getDesc1();

        //BIND DATA
        holder.nameTxt.setText(name);
        //holder.img.setImageResource(image);
//        holder.descTxt.setText(desc);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name,desc);
                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return indian.size();
    }

    private void openDetailActivity(String name,String desc)
    {
        Intent i=new Intent(c, DetailActivity.class);

        //PACK DATA TO SEND
        i.putExtra("NAME_KEY",name);
       // i.putExtra("IMAGE_KEY",image);
        i.putExtra("DESC_KEY",desc);
        //i.putExtra("DESC1_KEY",desc1);

        //open activity
        c.startActivity(i);

    }
}
