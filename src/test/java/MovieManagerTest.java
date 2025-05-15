import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Блекшот");
        manager.addMovie("Вперед");

        String[] expected = {"Блекшот", "Вперед"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Блекшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель «Белград»");

        String[] expected = {"Блекшот", "Вперед", "Отель «Белград»"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Блекшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель «Белград»");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель «Белград»"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Блекшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель «Белград»");
        manager.addMovie("Джентельмены");

        String[] expected = {"Джентельмены", "Отель «Белград»", "Вперед"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Блекшот");
        manager.addMovie("Вперед");

        String[] expected = {"Вперед", "Блекшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastWhenEmpty() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }
}
