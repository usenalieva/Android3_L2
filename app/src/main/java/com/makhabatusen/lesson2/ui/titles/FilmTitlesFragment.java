package com.makhabatusen.lesson2.ui.titles;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson2.R;
import com.makhabatusen.lesson2.data.FilmStorage;
import com.makhabatusen.lesson2.interfaces.ResultFilms;
import com.makhabatusen.lesson2.model.Film;
import com.makhabatusen.lesson2.ui.adapter.FilmAdapter;

import java.util.List;


public class FilmTitlesFragment extends Fragment {
    private FilmAdapter adapter;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAdapter();
        getFilms();

    }

    private void initAdapter() {
        adapter = new FilmAdapter(id -> navController.navigate(FilmTitlesFragmentDirections.actionTitlesFragmentToFilmDetailsFragment(id)));
    }

    private void getFilms() {
        FilmStorage.getFilms(new ResultFilms() {
            @Override
            public void onSuccessList(List<Film> films) {
                adapter.addFilms(films);
                Log.e("ololo", films.toString());
            }

            @Override
            public void OnFailure(String errorMsg) {
                Log.e("ololo", errorMsg);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_titles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    private void init(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_films);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        recyclerView.setAdapter(adapter);
    }

}