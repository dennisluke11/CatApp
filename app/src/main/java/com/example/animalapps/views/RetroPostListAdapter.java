package com.example.animalapps.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.animalapps.R;
import com.example.animalapps.model.Cat;

import java.util.List;

public class RetroPostListAdapter extends RecyclerView.Adapter<RetroPostListAdapter.PostViewHolder> {





    class PostViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private  final TextView id,body;

        private PostViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.retro_id);
            imageView = itemView.findViewById(R.id.image);
            body = itemView.findViewById(R.id.retro_body);
        }
    }

    private final LayoutInflater mInflater;
    private List<Cat> mCats;
    private Context context;
    Cat  current;
    Bundle bundle;


    RetroPostListAdapter(Context context)
    {
        this.context=context;
        mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_cat_item, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, final int position) {
        if (mCats != null) {
            current = mCats.get(position);
            holder.id.setText("Image "+current.getCatId());
            Glide.with(context)
                    .load(current.getUrl())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageView);
            holder.body.setText("This is the description for Image"+current.getCatId()+". It's a really cool image  bask in it's gloriousness");


            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    current = mCats.get(position);
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    DisplayFragment myFragment = new DisplayFragment();
                     bundle=new Bundle();
                    bundle.putParcelable("obj",current);
                    myFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_retro_room, myFragment).addToBackStack(null).commit();
                }
            });
        }



        else {

        }


    }
    void setWords(List<Cat> users){
        mCats = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCats != null) {
            return mCats.size();
        }else{
            return  0;
        }
    }




}
