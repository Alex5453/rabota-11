import org.example.MovieManager;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {

    @Test
    public void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        String[] expected = {"Movie 1", "Movie 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindAll() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        String[] expected = {"Movie 3", "Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        String[] expected = {"Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }
}
