import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        Movie movie = new Movie("Test Movie");
        manager.add(movie);
        Movie[] returned = manager.findAll();
        Movie[] expected = {movie};

        assertArrayEquals(expected, returned);
    }

    @Test
    void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        manager.add(new Movie("Movie 3"));
        Movie[] returned = manager.findAll();
        Movie[] expected = {
            new Movie("Movie 1"),
            new Movie("Movie 2"),
            new Movie("Movie 3")
        };

        assertArrayEquals(expected, returned);
    }

    @Test
    void shouldFindLastMovies() {
        MovieManager manager = new MovieManager(2);
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        manager.add(new Movie("Movie 3"));
        Movie[] returned = manager.findLast();
        Movie[] expected = {
            new Movie("Movie 3"),
            new Movie("Movie 2")
        };

        assertArrayEquals(expected, returned);
    }

    @Test
    void shouldRespectDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add(new Movie("Movie 1"));
        manager.add(new Movie("Movie 2"));
        manager.add(new Movie("Movie 3"));
        manager.add(new Movie("Movie 4"));
        manager.add(new Movie("Movie 5"));
        manager.add(new Movie("Movie 6"));
        Movie[] returned = manager.findLast();
        Movie[] expected = {
            new Movie("Movie 6"),
            new Movie("Movie 5"),
            new Movie("Movie 4"),
            new Movie("Movie 3"),
            new Movie("Movie 2")
        };

        assertArrayEquals(expected, returned);
    }
}

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

