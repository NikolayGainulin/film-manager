import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerAdditionalTest {

    @Test
    void testConstructorWithCustomLimit() {
        MovieManager manager = new MovieManager(10);
        // Добавляем фильмы, чтобы проверить лимит
        manager.addMovie("Фильм1");
        manager.addMovie("Фильм2");
        manager.addMovie("Фильм3");
        manager.addMovie("Фильм4");
        manager.addMovie("Фильм5");
        manager.addMovie("Фильм6");
        manager.addMovie("Фильм7");
        manager.addMovie("Фильм8");
        manager.addMovie("Фильм9");
        manager.addMovie("Фильм10");
        manager.addMovie("Фильм11"); // На один больше лимита

        assertEquals(10, manager.findLast().length);
    }

    @Test
    void testConstructorWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        // Добавляем фильмы, чтобы проверить лимит
        manager.addMovie("Фильм1");
        manager.addMovie("Фильм2");
        manager.addMovie("Фильм3");
        manager.addMovie("Фильм4");
        manager.addMovie("Фильм5");
        manager.addMovie("Фильм6"); // На один больше лимита

        assertEquals(5, manager.findLast().length);
    }

    @Test
    void testAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        String[] testMovies = {
                "Блекшот", "Вперед", "Отель «Белград»", "Джентельмены",
                "Человек-невидимка", "Тролли. Мировой тур", "Номер один"
        };

        for (String movie : testMovies) {
            manager.addMovie(movie);
        }

        assertArrayEquals(testMovies, manager.findAll());
    }

    @Test
    void testFindLastWithExactLimit() {
        MovieManager manager = new MovieManager(4);
        manager.addMovie("Фильм1");
        manager.addMovie("Фильм2");
        manager.addMovie("Фильм3");
        manager.addMovie("Фильм4");

        String[] expected = {"Фильм4", "Фильм3", "Фильм2", "Фильм1"};
        assertArrayEquals(expected, manager.findLast());
    }
}