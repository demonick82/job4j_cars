package ru.job4j.cars.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.cars.model.*;

import java.util.Collection;
import java.util.function.Function;

public class HBmStore implements AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private static final class Lazy {
        private static final HBmStore INST = new HBmStore();
    }

    public static HBmStore instOf() {
        return Lazy.INST;
    }

  /*  public void addPost(Post post, Photo photo) {
        this.tx(session -> {
            post.addPhoto(photo);
            session.save(post);
            return true;
        });
    }

    public Collection<Post> findAllPosts() {
        return this.tx(session -> session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph where p.isSale=false ")
                .list());
    }

    public Post findPostById(int id) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("select distinct p from Post p"
                            + " join fetch p.photos ph where  p.id=:id")
                            .setParameter("id", id);
                    return (Post) query.uniqueResult();
                }
        );
    }

    public User findUserByEmail(String email) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("from User where email=:email")
                            .setParameter("email", email);
                    return (User) query.uniqueResult();
                }
        );
    }

    public Collection<Post> findPostsForUser(String email) {
        return this.tx(session -> session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph "
                        + "join fetch p.user u where email=:email")
                .setParameter("email", email)
                .list());
    }

    public Collection<Brand> findAllBrands() {
        return this.tx(session -> session.createQuery("from Brand").list());
    }

    public Collection<Model> findModelsByMark(String brand) {
        return this.tx(session -> session.createQuery("select distinct m from Model m "
                + "join fetch m.brand b  where b.name =:brand ")
                .setParameter("brand", brand)
                .list());
    }

    public Collection<Transmission> findAllTransmissions() {
        return this.tx(session -> session.createQuery("from Transmission ").list());
    }

    public Collection<CarBoby> findAllCarBodies() {
        return this.tx(session -> session.createQuery("from CarBoby ").list());
    }

    public Brand findBrandForId(int id) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("from Brand where id=:id")
                            .setParameter("id", id);
                    return (Brand) query.uniqueResult();
                }
        );
    }

    public Model findModelForId(int brandId, int modelId) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("select distinct m from Model m "
                            + "join fetch m.brand b where b.id =:brandId and m.id=:modelId")
                            .setParameter("brandId", brandId)
                            .setParameter("modelId", modelId);
                    return (Model) query.uniqueResult();
                }
        );
    }

    public Transmission findTransmissionForId(int id) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("from Transmission where id=:id")
                            .setParameter("id", id);
                    return (Transmission) query.uniqueResult();
                }
        );
    }

    public CarBoby findCarBodyForId(int id) {
        return this.tx(
                session -> {
                    final Query query = session.createQuery("from CarBoby where id=:id")
                            .setParameter("id", id);
                    return (CarBoby) query.uniqueResult();
                }
        );
    }

    public void deletePost(Post post) {
        this.tx(session -> {
            session.remove(post);
            return true;
        });
    }

    public void addPhoto(Post post, Photo photo) {
        this.tx(session -> {
            post.addPhoto(photo);
            session.update(post);
            return true;
        });
    }

    public void deleteAllNotExistPhotos(Post post) {
        this.tx(session -> {
            post.getPhotos().removeIf(photo -> !photo.isExists());
            return true;
        });
    }

    public void updatePost(Post post) {
        this.tx(session -> {
            session.update(post);
            return true;
        });
    }

    public Collection<Post> findPosts(int markId, long startPrice, long endPrice, int startYear,
                                      int endYear, int carBodyId, int transmissionId, String driveUnit, Boolean exist) {
        return this.tx(session -> session.createQuery(
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

    public void saveUser(User user) {
        this.tx(session -> session.save(user));
    }

    public void saveModel(Model model) {
        this.tx(session -> session.save(model));

    }

    public void saveBrand(Brand brand) {
        this.tx(session -> session.save(brand));

    }

    public void saveCarBodies(CarBoby carBoby) {
        this.tx(session -> session.save(carBoby));

    }

    public void saveTransmissions(Transmission transmission) {
        this.tx(session -> session.save(transmission));
    }*/


    public <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
