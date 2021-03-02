package com.makhabatusen.lesson2.data;

import com.makhabatusen.lesson2.model.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("films/{id}")
    Call <Film> getFilmById(@Path("id") String id);

    @GET ("films")
    Call <List<Film>> getFilms();

}
