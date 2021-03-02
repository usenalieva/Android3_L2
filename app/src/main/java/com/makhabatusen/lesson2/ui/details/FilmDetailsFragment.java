package com.makhabatusen.lesson2.ui.details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.makhabatusen.lesson2.R;
import com.makhabatusen.lesson2.data.FilmStorage;
import com.makhabatusen.lesson2.interfaces.ResultFilm;
import com.makhabatusen.lesson2.model.Film;

public class FilmDetailsFragment extends Fragment {
    private Film retroFilm;
    private TextView tvFilmTitle;
    private TextView tvDescription;
    private TextView tvDirector;
    private TextView tvReleaseDate;
    private NavController navController;

    private MaterialButton btnSpecies;
    private MaterialButton btnLocations;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_film_details, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getFilm(FilmDetailsFragmentArgs.fromBundle(getArguments()).getId());
    }

    private void getFilm(String id) {
        FilmStorage.getFilmByID(id, new ResultFilm() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccessFilm(Film film) {
                retroFilm = film;
                tvFilmTitle.setText(film.getTitle());
                tvDescription.setText(film.getDescription());
                tvDirector.setText("Director: " + film.getDirector());
                tvReleaseDate.setText("Release Date: " + film.getReleaseDate());
            }

            @Override
            public void OnFailure(String errorMsg) {
                Log.e("ololo", "OnFailure: " + errorMsg );
            }
        });
    }

    private void initView(@NonNull View view) {
        tvFilmTitle = view.findViewById(R.id.tv_film_title);
        tvDescription = view.findViewById(R.id.tv_description);
        tvDirector = view.findViewById(R.id.tv_director);
        tvReleaseDate = view.findViewById(R.id.tv_release_date);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        btnSpecies = view.findViewById(R.id.btn_species);
        btnLocations = view.findViewById(R.id.btn_locations);

        view.findViewById(R.id.btn_people).setOnClickListener(v->{
            navController.navigate(FilmDetailsFragmentDirections.actionFilmDetailsFragmentToPeopleFragment(retroFilm));
        });
    }

}