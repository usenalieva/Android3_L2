package com.makhabatusen.lesson2.data;

import com.makhabatusen.lesson2.interfaces.ResultPeople;
import com.makhabatusen.lesson2.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleStorage {

    public static void getPeople(String id, ResultPeople resultPeople) {
        RetrofitBuilder.getInstance().getPeople(id).enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.isSuccessful() && response.body() != null)
                    resultPeople.onSuccessList(response.body());
                else resultPeople.OnFailure(String.valueOf(response.code()));

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                resultPeople.OnFailure(t.getLocalizedMessage());

            }
        });
    }
}
