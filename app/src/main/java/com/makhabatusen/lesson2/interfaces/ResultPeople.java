package com.makhabatusen.lesson2.interfaces;

import com.makhabatusen.lesson2.model.Person;

import java.util.List;

public interface ResultPeople {
    void onSuccessList (List<Person> films);
    void OnFailure(String errorMsg);
}
