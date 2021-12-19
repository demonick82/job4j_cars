package ru.job4j.cars.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cars.model.Photo;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.function.Function;

public class HBmStore implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private static final Logger LOG = LoggerFactory.getLogger(HBmStore.class.getName());

    private static final class Lazy {
        private static final Store INST = new HBmStore();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    @Override
    public void addPost(Post post, List<Photo> photos) {
        this.tx(session -> {
            for (Photo photo : photos) {
                post.addPhoto(photo);
                session.save(post);
            }
            return true;
        });
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            LOG.error("Error", e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void close()  {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
