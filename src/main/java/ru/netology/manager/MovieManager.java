package ru.netology.manager;

import lombok.Getter;
import lombok.Setter;
import ru.netology.domain.MovieItem;
import ru.netology.domain.PurchaseItem;

@Getter
@Setter

public class MovieManager {

    private MovieItem[] items = new MovieItem[0];
    private int amount;

    public MovieManager(int amount) {
        this.amount = amount;
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        MovieItem[] result = new MovieItem[items.length];
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
