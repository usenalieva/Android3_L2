package com.makhabatusen.lesson2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson2.R;
import com.makhabatusen.lesson2.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {
    private final List<Person> list;


    public PersonAdapter() {
        list = new ArrayList<>();
    }

    public void addPeople(List<Person> personList) {
        list.addAll(personList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PersonHolder extends RecyclerView.ViewHolder {
        private final TextView tvPerson;

        public PersonHolder(@NonNull View itemView) {
            super(itemView);
            tvPerson = itemView.findViewById(R.id.tv_person);
        }

        public void bind(Person person) {
            tvPerson.setText(person.toString());

        }
    }
}
