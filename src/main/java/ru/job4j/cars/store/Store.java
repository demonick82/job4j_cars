package ru.job4j.cars.store;

import ru.job4j.cars.model.*;

import java.util.Collection;

public interface Store {

    void addPost(Post post, Photo photo);

    Collection<Post> findAllPosts();

    Post findPostById(int id);

    User findUserByEmail(String email);

    Collection<Post> findPostsForUser(String email);

    Collection<Brand> findAllBrands();

    Collection<Model> findModelsByMark(String brand);

    Collection<Transmission> findAllTransmissions();

    Collection<CarBoby> findAllCarBodies();

    Brand findBrandForId(int id);

    Model findModelForId(int id, int modelId);

    Transmission findTransmissionForId(int id);

    CarBoby findCarBodyForId(int id);

    void deletePost(Post post);

    void addPhoto(Post post, Photo photo);

    void deleteAllNotExistPhotos(Post post);

    void updatePost(Post post);

    Collection<Post> findPosts(int markId, long startPrice, long endPrice, int startYear,
                               int endYear, int carBodyId, int transmissionId, String driveUnit, Boolean exist);

    void saveUser(User user);

    void saveModel(Model model);

    void saveBrand(Brand brand);

    void saveCarBodies(CarBoby carBoby);

    void saveTransmissions(Transmission transmission);

}
