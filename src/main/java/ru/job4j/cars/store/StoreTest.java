package ru.job4j.cars.store;

import ru.job4j.cars.model.*;

import java.util.List;

public class StoreTest {
    public static void main(String[] args) {
        Store store = HBmStore.instOf();
        AdRepostiroty repostiroty = new AdRepostiroty();
        Brand hunday = Brand.of("Hunday");
        Brand kia = Brand.of("Kia");
        Model solaris = Model.of("Solaris", hunday);
        Model rio = Model.of("Рио", kia);
        CarBoby sedan = CarBoby.of("Седан");
        CarBoby hatch = CarBoby.of("Хэтчбэк");
        Photo photo1 = Photo.of("", "", false);
        Photo photo2 = Photo.of("photo2", "path2", true);
        Photo photo3 = Photo.of("photo3", "path3", true);

        User user1 = User.of("Дмитрий", "mail@mail.ru", "123456789", "123");
        User user2 = User.of("Сергей", "mail1@mail.ru", "123456799", "123");
        Post post1 = Post.of("post1", 2015, "desc1", false, solaris, sedan, user1);
        Post post2 = Post.of("post2", 2016, "desc2", false, rio, hatch, user2);
        store.addPost(post1, List.of(photo1));
        store.addPost(post2, List.of(photo2, photo3));
        System.out.println(repostiroty.findPostWithPhoto());
        System.out.println(repostiroty.findPostByModel(rio));
        System.out.println(repostiroty.findPostToday());
    }
}
