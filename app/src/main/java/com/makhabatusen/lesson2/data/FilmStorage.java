package com.makhabatusen.lesson2.data;

import com.makhabatusen.lesson2.model.Film;
import com.makhabatusen.lesson2.interfaces.ResultFilm;
import com.makhabatusen.lesson2.interfaces.ResultListFilms;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  FilmStorage {

    public static void getFilmByID( String id, ResultFilm result) {
        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() !=null)
                result.onSuccessFilm(response.body());
                else result.OnFailure(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            result.OnFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void getFilms (ResultListFilms result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() !=null)
                    result.onSuccessList(response.body());
                else result.OnFailure(String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                result.OnFailure(t.getLocalizedMessage());
            }
        });

    }



}
