package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;

public class MovieManager {
    private String[] movies;
    private int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new String[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
    }

    public void addMovie(String movie) {
        String[] newMovies = new String[movies.length + 1];
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        newMovies[movies.length] = movie;
        movies = newMovies;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
