package com.makhabatusen.lesson2.interfaces;

import com.makhabatusen.lesson2.model.Film;

import java.util.List;

public interface ResultFilms {
    void onSuccessList (List<Film> films);
    void OnFailure(String errorMsg);
}
