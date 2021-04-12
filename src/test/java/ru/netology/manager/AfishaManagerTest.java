package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
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
    public void showAmountMovie0() {
        AfishaManager manager = new AfishaManager(repository, 0);
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showAmountMovie1() {
        AfishaManager manager = new AfishaManager(repository, 1);
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showAmountMovie10() {
        AfishaManager manager = new AfishaManager(repository, 10);
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showAmountMovie10When9Item() {
        AfishaManager manager = new AfishaManager(repository, 10);
        MovieItem[] returned = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}