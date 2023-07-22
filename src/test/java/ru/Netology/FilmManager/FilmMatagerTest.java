package ru.Netology.FilmManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmMatagerTest {

    @Test
    public void filmMissing() {
        FilmManager manager = new FilmManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lowerBoundFilms() {
        FilmManager manager = new FilmManager();
        manager.add("Movie I");

        String[] expected = {"Movie I"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFilmthe() {
        FilmManager manager = new FilmManager();
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");

        String[] expected = {"Movie I", "Movie II", "Movie III"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showtheRecentMovies() {
        FilmManager manager = new FilmManager();
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");

        String[] expected = {"Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showFiveRecentMovies() {
        FilmManager manager = new FilmManager();
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");
        manager.add("Movie IV");
        manager.add("Movie V");

        String[] expected = {"Movie V", "Movie IV", "Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showSevenRecentMovies() {
        FilmManager manager = new FilmManager(7);
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");
        manager.add("Movie IV");
        manager.add("Movie V");
        manager.add("Movie VI");
        manager.add("Movie VII");

        String[] expected = {"Movie VII", "Movie VI", "Movie V", "Movie IV", "Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void lessThanTheLimit() {
        FilmManager manager = new FilmManager(5);
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");

        String[] expected = { "Movie III", "Movie II", "Movie I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void moreThanTheLimit() {
        FilmManager manager = new FilmManager();
        manager.add("Movie I");
        manager.add("Movie II");
        manager.add("Movie III");
        manager.add("Movie IV");
        manager.add("Movie V");
        manager.add("Movie VI");

        String[] expected = {"Movie VI","Movie V","Movie IV", "Movie III", "Movie II"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
