package ru.job4j.cars.store;

import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;

import java.util.List;

public interface Store {

    void addPost(Post post, List<Photo> photos);
}
