package com.makhabatusen.lesson2.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson2.R;
import com.makhabatusen.lesson2.interfaces.AdapterInterface;
import com.makhabatusen.lesson2.model.Film;

import java.util.ArrayList;
import java.util.List;


public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {
    private final List<Film> list;
    public AdapterInterface adapterInterface;


    public FilmAdapter(AdapterInterface adapterInterface) {

        list = new ArrayList<>();
        this.adapterInterface = adapterInterface;
    }


    public void addFilms(List<Film> films) {
        list.addAll(films);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;


        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(v -> {
                Log.e("ololo", "FilmHolder: " + list.get(getAdapterPosition()).getId());
                adapterInterface.showDetails(list.get(getAdapterPosition()).getId());
            });

        }

        public void bind(Film film) {
            tvTitle.setText(film.getTitle());
            Log.e("ololo", "bind: " + tvTitle.getText().toString());
        }
    }


}
