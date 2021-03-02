package com.makhabatusen.lesson2.ui.details.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson2.R;
import com.makhabatusen.lesson2.data.PeopleStorage;
import com.makhabatusen.lesson2.interfaces.ResultPeople;
import com.makhabatusen.lesson2.model.Film;
import com.makhabatusen.lesson2.ui.adapter.PersonAdapter;

import java.util.List;

public class PeopleFragment extends Fragment {
    private Film film;
    private PersonAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFilm();
        getPeople();
    }

    private void getPeople() {
        PeopleStorage.getPeople(film.getId(), new ResultPeople() {
            @Override
            public void onSuccessList(List<com.makhabatusen.lesson2.model.Person> films) {
                adapter.addPeople(films);
            }

            @Override
            public void OnFailure(String errorMsg) {

            }
        });

    }

    private void getFilm() {
        film = PeopleFragmentArgs.fromBundle(getArguments()).getFilm();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_people, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    private void init(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_people);
        adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);


    }
}