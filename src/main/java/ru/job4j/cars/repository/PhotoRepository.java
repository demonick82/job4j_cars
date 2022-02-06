package ru.job4j.cars.repository;

import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.store.HBmStore;

public class PhotoRepository {

    private static final class Lazy {
        private static final PhotoRepository INST = new PhotoRepository();
    }

    public static PhotoRepository instOf() {
        return PhotoRepository.Lazy.INST;
    }

    public void addPhoto(Post post, Photo photo) {
        HBmStore.instOf().tx(session -> {
            post.addPhoto(photo);
            session.update(post);
            return true;
        });
    }

    public void deleteAllNotExistPhotos(Post post) {
        HBmStore.instOf().tx(session -> {
            post.getPhotos().removeIf(photo -> !photo.isExists());
            return true;
        });
    }
}
