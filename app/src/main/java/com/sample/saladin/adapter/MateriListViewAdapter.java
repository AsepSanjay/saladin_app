package com.sample.saladin.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.saladin.R;
import com.sample.saladin.model.Materi;

import java.util.ArrayList;

public class MateriListViewAdapter extends RecyclerView.Adapter<MateriListViewAdapter.MateriViewHolder> {
    private ArrayList<Materi> mData = new ArrayList<>();

    public void setData(ArrayList<Materi> items) {
        mData.clear();
        mData.addAll(items);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_materi, parent, false);
        return new MateriViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MateriViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle, tvDate, tvVideo;

        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_tema_materi);
            tvDate = itemView.findViewById(R.id.tv_date_materi);
            tvVideo = itemView.findViewById(R.id.tv_url_video);

            itemView.setOnClickListener(this);
        }

        void bind(Materi materi) {
            tvTitle.setText(materi.getTema());
            tvDate.setText(materi.getTanggal());
            tvVideo.setText(materi.getVideo());
        }
        @Override
        public void onClick(View v) {
            Log.d("CLick Detail Materi!!1", "true");
        }
    }
}