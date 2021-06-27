package com.example.finastra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finastra.helper.ImageData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.NasaViewHolder> {
    private Context mContext;
    private List<ImageData> imageData;
    final int VIEW_TYPE_LOADING = 0;
    final int VIEW_TYPE_ITEM = 1;

    public NasaAdapter(Context mContext, List<ImageData>imageData){
        this.mContext = mContext;
        this.imageData = imageData;
    }

    @NonNull
    @Override
    public NasaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.imagecard, null);
            return new NasaViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull NasaViewHolder holder, int position) {
        final ImageData imageDatas = imageData.get(position);
        holder.name.setText(imageDatas.getRoverName());
        holder.launch.setText(imageDatas.getRoverLaunch());
        holder.land.setText(imageDatas.getRoverLand());
        Picasso.with(mContext).load(imageDatas.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return imageData.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }

    public void addItems(List<ImageData> matchLisrt) {
        imageData.addAll(matchLisrt);
        notifyDataSetChanged();
    }

    class NasaViewHolder extends RecyclerView.ViewHolder{
        TextView name, launch, land;
        ImageView imageView;

        public NasaViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.roverName);
            launch = itemView.findViewById(R.id.launchDate);
            land = itemView.findViewById(R.id.landDate);
            imageView = itemView.findViewById(R.id.astra_image);
        }

    }

    private class LoadingHolder extends NasaViewHolder {
        public LoadingHolder(View view) {
            super(view);
        }
    }
}
