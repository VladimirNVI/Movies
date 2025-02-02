package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Poster implements Serializable {
    @SerializedName("url")
    private String url;

    public Poster(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }
}
