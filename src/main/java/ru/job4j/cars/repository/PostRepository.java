package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.store.HBmStore;

import java.util.Collection;

public class PostRepository {

    private static final class Lazy {
        private static final PostRepository INST = new PostRepository();
    }

    public static PostRepository instOf() {
        return PostRepository.Lazy.INST;
    }

    public void addPost(Post post, Photo photo) {
        HBmStore.instOf().tx(session -> {
            post.addPhoto(photo);
            session.save(post);
            return true;
        });
    }

    public Collection<Post> findAllPosts() {
        return HBmStore.instOf().tx(session -> session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph where p.isSale=false ")
                .list());
    }

    public Post findPostById(int id) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("select distinct p from Post p"
                            + " join fetch p.photos ph where  p.id=:id")
                            .setParameter("id", id);
                    return (Post) query.uniqueResult();
                }
        );
    }

    public Collection<Post> findPostsForUser(String email) {
        return HBmStore.instOf().tx(session -> session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph "
                        + "join fetch p.user u where email=:email")
                .setParameter("email", email)
                .list());
    }

    public void deletePost(Post post) {
        HBmStore.instOf().tx(session -> {
            session.remove(post);
            return true;
        });
    }

    public void updatePost(Post post) {
        HBmStore.instOf().tx(session -> {
            session.update(post);
            return true;
        });
    }

    public Collection<Post> findPosts(int markId, long startPrice, long endPrice, int startYear,
                                      int endYear, int carBodyId, int transmissionId, String driveUnit, Boolean exist) {
        return HBmStore.instOf().tx(session -> session.createQuery(
                "select distinct p from Post p "
                        + "join fetch p.carBoby cb "
                        + "join fetch p.transmission t "
                        + "join fetch p.model m "
                        + "join fetch m.brand b "
                        + "join fetch p.photos ph "
                        + "where  b.id=:bId "
                        + "and p.price between :pStart and :pEnd "
                        + "and p.productionYear between :pYearStart and :pYearEnd "
                        + "and p.driveUnit=:pUnit and p.isSale=false "
                        + "and cb.id=:cbId "
                        + "and t.id=:tId and ph.exists=:exist ")
                .setParameter("bId", markId)
                .setParameter("pStart", startPrice)
                .setParameter("pEnd", endPrice)
                .setParameter("pYearStart", startYear)
                .setParameter("pYearEnd", endYear)
                .setParameter("pUnit", driveUnit)
                .setParameter("cbId", carBodyId)
                .setParameter("tId", transmissionId)
                .setParameter("exist", exist)
                .list());
    }

}
