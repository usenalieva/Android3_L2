package com.makhabatusen.lesson2.interfaces;

import com.makhabatusen.lesson2.model.Film;

public interface ResultFilm {
    void onSuccessFilm(Film film);
    void OnFailure(String errorMsg);
}
