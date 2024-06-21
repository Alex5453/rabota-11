package org.example;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public MovieManager() {
        this.limit = 5; // Лимит по умолчанию
    }

    public MovieManager(int limit) {
        this.limit = limit; // Установка пользовательского лимита
    }

    public void add(Movie movie) {
        // Создаем новый массив размером на один больше
        Movie[] newMovies = new Movie[movies.length + 1];
        // Копируем все элементы в новый массив
        System.arraycopy(movies, 0, newMovies, 0, movies.length);
        // Добавляем новый фильм в конец массива
        newMovies[movies.length] = movie;
        // Обновляем массив фильмов
        movies = newMovies;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        // Вычисляем размер результирующего массива
        int resultLength = Math.min(movies.length, limit);
        Movie[] result = new Movie[resultLength];
        // Заполняем result из массива movies в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}

class Movie {
    private String name;

    // Конструктор и геттеры/сеттеры
}
