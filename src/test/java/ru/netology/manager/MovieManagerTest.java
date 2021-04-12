package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieItem first = new MovieItem(1, "Iron Man", "fantasy", "11@yandex.com");
    MovieItem second = new MovieItem(2, "Iron Man 2", "fantasy", "12@yandex.com");
    MovieItem third = new MovieItem(3, "Iron Man 3", "fantasy", "13@yandex.com");
    MovieItem fourth = new MovieItem(4, "Thor", "fantasy", "14@yandex.com");
    MovieItem fifth = new MovieItem(5, "Captain America", "fantasy", "15@yandex.com");
    MovieItem sixth = new MovieItem(6, "Doctor Strange", "fantasy", "16@yandex.com");
    MovieItem seventh = new MovieItem(7, "Spider-Man", "fantasy", "17@yandex.com");
    MovieItem eighth = new MovieItem(8, "Black Panther", "fantasy", "18@yandex.com");
    MovieItem ninth = new MovieItem(9, "Logan", "action", "111@yandex.com");
    MovieItem tenth = new MovieItem(10, "Sherlock Holmes", "action", "112@yandex.com");
    MovieItem eleventh = new MovieItem(11, "The Da Vinci Code", "thriller", "119@yandex.com");

    @Test
    public void show0from0movies() {
        MovieManager manager = new MovieManager(0);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void show0from10movies() {
        MovieManager manager = new MovieManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void show1from1movies() {
        MovieManager manager = new MovieManager(1);
        manager.add(first);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{first};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void show1from10movies() {
        MovieManager manager = new MovieManager(1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void show10from10movies() {
        MovieManager manager = new MovieManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void show10from11movies() {
        MovieManager manager = new MovieManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void show10from9movies() {
        MovieManager manager = new MovieManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}