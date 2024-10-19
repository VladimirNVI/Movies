package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class MovieFavouriteActivity extends AppCompatActivity {
    private MovieFavouriteViewModel viewModel;

    private RecyclerView recyclerViewFavourite;
    private MovieAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_favourite);
        initViews();
        moviesAdapter = new MovieAdapter();
        recyclerViewFavourite.setAdapter(moviesAdapter);
        recyclerViewFavourite.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel = new ViewModelProvider(this).get(MovieFavouriteViewModel.class);
        viewModel.getAllFavouriteMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        });

        moviesAdapter.setOnMovieClickListener(new MovieAdapter.OnMovieClickListener() {
            @Override
            public void OnMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        MovieFavouriteActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        recyclerViewFavourite = findViewById(R.id.recyclerViewFavourite);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, MovieFavouriteActivity.class);

    }
}