package ru.netology.manager;


import ru.netology.domain.MovieItem;

public class AfishaRepository {
    private MovieItem[] items = new MovieItem[0];

    public MovieItem[] findAll() {
        return items;
    }

    public void save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] findById(int id) {
        MovieItem result[] = new MovieItem[1];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() == id) {
                result[index] = item;
                index++;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public MovieItem[] removeAll() {
        MovieItem[] result = new MovieItem[0];
        items = result;
        return items;
    }
}
