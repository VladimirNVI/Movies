package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1.4/movie?token=TCXNAW7-FW5M4M3-M7DEGQX-V9Q34YB&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=30&type=anime")
    Single<MoiveResponse> loadMovies(@Query ("page") int page);

    @GET("v1.4/movie?token=TCXNAW7-FW5M4M3-M7DEGQX-V9Q34YB&selectFields=videos")
    Single<ExampleResponse> loadTrailers(@Query("id") int id);

    @GET("https://api.kinopoisk.dev/v1.4/review?token=TCXNAW7-FW5M4M3-M7DEGQX-V9Q34YB")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);

}
