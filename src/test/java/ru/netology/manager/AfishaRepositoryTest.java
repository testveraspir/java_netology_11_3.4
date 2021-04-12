package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.domain.PurchaseItem;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
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
    public void findAllIfMovie0() {
        AfishaRepository repository = new AfishaRepository();

        MovieItem[] actual = repository.findAll();
        MovieItem[] expected = new MovieItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllIfMovie() {
        AfishaRepository afishaRepository = new AfishaRepository();

        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(fourth);
        afishaRepository.save(fifth);
        afishaRepository.save(sixth);
        afishaRepository.save(seventh);
        afishaRepository.save(eighth);
        afishaRepository.save(ninth);
        afishaRepository.save(tenth);
        afishaRepository.save(eleventh);

        MovieItem[] actual = afishaRepository.findAll();
        MovieItem[] expected = new MovieItem[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIfFirstItem() {
        AfishaRepository afishaRepository = new AfishaRepository();

        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(fourth);
        afishaRepository.save(fifth);
        afishaRepository.save(sixth);
        afishaRepository.save(seventh);
        afishaRepository.save(eighth);
        afishaRepository.save(ninth);
        afishaRepository.save(tenth);
        afishaRepository.save(eleventh);

        MovieItem[] actual = afishaRepository.findById(1);
        MovieItem[] expected = new MovieItem[]{first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void findByIfLastItem() {
        AfishaRepository afishaRepository = new AfishaRepository();

        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(fourth);
        afishaRepository.save(fifth);
        afishaRepository.save(sixth);
        afishaRepository.save(seventh);
        afishaRepository.save(eighth);
        afishaRepository.save(ninth);
        afishaRepository.save(tenth);
        afishaRepository.save(eleventh);

        MovieItem[] actual = afishaRepository.findById(11);
        MovieItem[] expected = new MovieItem[]{eleventh};
        assertArrayEquals(expected, actual);

    }

    /**
     * @Test public void findByIfNoExists(){
     * AfishaRepository afishaRepository=new AfishaRepository();
     * <p>
     * afishaRepository.save(first);
     * afishaRepository.save(second);
     * afishaRepository.save(third);
     * afishaRepository.save(fourth);
     * afishaRepository.save(fifth);
     * afishaRepository.save(sixth);
     * afishaRepository.save(seventh);
     * afishaRepository.save(eighth);
     * afishaRepository.save(ninth);
     * afishaRepository.save(tenth);
     * afishaRepository.save(eleventh);
     * <p>
     * MovieItem[]actual=afishaRepository.findById(12);
     * MovieItem[]expected=new MovieItem[]{};
     * assertArrayEquals(expected,actual);
     * }
     */

    @Test
    public void removeExistsItem() {
        AfishaRepository afishaRepository = new AfishaRepository();

        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.removeById(1);
        MovieItem[] actual = afishaRepository.findAll();
        MovieItem[] expected = new MovieItem[]{second};
        assertArrayEquals(expected, actual);
    }

    /**
     * @Test public void removeNoExistsItem(){
     * AfishaRepository afishaRepository=new AfishaRepository();
     * <p>
     * afishaRepository.save(first);
     * afishaRepository.save(second);
     * afishaRepository.removeById(5);
     * MovieItem[]actual=afishaRepository.findAll();
     * MovieItem[]expected=new MovieItem[]{second};
     * assertArrayEquals(expected,actual);
     * }
     */

    @Test
    public void removeAllItem() {
        AfishaRepository afishaRepository = new AfishaRepository();
        afishaRepository.save(first);
        afishaRepository.save(second);
        afishaRepository.save(third);
        afishaRepository.save(fourth);
        afishaRepository.save(fifth);
        MovieItem[] actual = afishaRepository.removeAll();
        MovieItem[] expected = new MovieItem[]{};

        assertArrayEquals(expected, actual);
    }


}