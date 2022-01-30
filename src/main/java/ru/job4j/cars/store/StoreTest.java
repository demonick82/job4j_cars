package ru.job4j.cars.store;

import ru.job4j.cars.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;


public class StoreTest {
    public static void main(String[] args) throws IOException {
        Store store = HBmStore.instOf();
        Brand hunday = Brand.of("Hunday");
        Brand kia = Brand.of("Kia");
        Model solaris = Model.of("Solaris", hunday);
        Model rio = Model.of("Рио", kia);
        CarBoby sedan = CarBoby.of("Седан");
        CarBoby hatch = CarBoby.of("Хэтчбэк");
        Transmission auto = Transmission.of("Автомат");
        Photo photo11 = Photo.of("photo1", "C:/imagesCar/1/1.jpg", true);
        Photo photo12 = Photo.of("photo2", "C:/imagesCar/1/2.jpg", true);
        Photo photo13 = Photo.of("photo3", "C:/imagesCar/1/3.jpg", true);

        Photo photo21 = Photo.of("photo1", "C:/imagesCar/2/1.jpg", true);
        Photo photo22 = Photo.of("photo2", "C:/imagesCar/2/2.jpg", true);
        Photo photo23 = Photo.of("photo3", "C:/imagesCar/2/3.jpg", true);


        User user1 = User.of("Дмитрий", "mail@mail.ru", "123456789", "123");
        User user2 = User.of("Сергей", "mail1@mail.ru", "123456799", "123");
        Post post1 = Post.of(800000, 2015, 80000, "Черный", "передний",
                "desc1", false, solaris, sedan, auto, user1);
        Post post2 = Post.of(850000, 2016, 50000, "Белый", "передний",
                "desc2", false, rio, hatch, auto, user2);

        Path path = Paths.get("C:\\imagesCar\\36");


    }
}
