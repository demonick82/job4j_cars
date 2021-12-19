package ru.job4j.cars.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.model.Post;

import java.util.Collection;
import java.util.List;

public class AdRepostiroty {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();


    public Collection<Post> findPostToday() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Post> result = session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph "
                        + " where p.created between current_date and current_date +1")
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Collection<Post> findPostWithPhoto() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Post> result = session.createQuery(
                "select distinct p from Post p  "
                        + "join fetch p.photos ph "
                        + "where ph.exists=true ")
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Collection<Post> findPostByModel(Model model) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Post> result = session.createQuery("select distinct p from Post p "
                + "join fetch p.model m "
                + "join fetch p.photos ph "
                + "where m.name=:mName ")
                .setParameter("mName", model.getName())
                .list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
