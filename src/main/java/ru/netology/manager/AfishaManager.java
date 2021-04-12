package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class AfishaManager {
    private AfishaRepository repository;
    private int amount;

    public AfishaManager(AfishaRepository repository, int amount) {
        this.repository = repository;
        this.amount = amount;
    }

    public MovieItem[] getAll() {
        MovieItem[] items = repository.findAll();
        MovieItem[] result = new MovieItem[items.length];
        // int max = 3;
        if (items.length > amount) {
            MovieItem[] result1 = new MovieItem[amount];
            for (int i = 0; i < amount; i++) {
                int index = items.length - i - 1;
                result1[i] = items[index];
            }
            return result1;
        } else {
            for (int i = 0; i < items.length; i++) {
                int index = items.length - i - 1;
                result[i] = items[index];
            }
        }
        return result;
    }
}
