package com.sample.saladin.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.saladin.R;
import com.sample.saladin.adapter.MateriListViewAdapter;
import com.sample.saladin.model.Materi;
import com.sample.saladin.viewModel.MateriViewModel;

import java.util.ArrayList;

public class MateriFragment extends AppCompatActivity {
    private MateriListViewAdapter adapter;
    private MateriViewModel materiViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_fragment);

        adapter = new MateriListViewAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MateriFragment.this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.list_item_materi);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        materiViewModel = ViewModelProviders.of(this).get(MateriViewModel.class);

        materiViewModel.getMateri().observe(this, getMateri);
        materiViewModel.setMateri();

    }

    private Observer<ArrayList<Materi>> getMateri = new Observer<ArrayList<Materi>>() {
        @Override
        public void onChanged(ArrayList<Materi> materi) {
            if (materi != null) {
                adapter.setData(materi);
            }
        }
    };
}