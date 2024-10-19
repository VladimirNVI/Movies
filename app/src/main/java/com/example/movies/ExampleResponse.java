package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleResponse {
    @SerializedName("docs")
       private List<TrailerResponse> trailerResponse;

    public ExampleResponse(List<TrailerResponse> trailerResponse) {
        this.trailerResponse = trailerResponse;
    }

    public List<TrailerResponse> getTrailerResponse() {
        return trailerResponse;
    }

    @Override
    public String toString() {
        return "Example{" +
                "trailerResponse=" + trailerResponse +
                '}';
    }
}
