package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.User;
import ru.job4j.cars.store.HBmStore;

public class UserRepository {

    private static final class Lazy {
        private static final UserRepository INST = new UserRepository();
    }

    public static UserRepository instOf() {
        return UserRepository.Lazy.INST;
    }

    public User findUserByEmail(String email) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("from User where email=:email")
                            .setParameter("email", email);
                    return (User) query.uniqueResult();
                }
        );
    }

    public void saveUser(User user) {
        HBmStore.instOf().tx(session -> session.save(user));
    }

}
