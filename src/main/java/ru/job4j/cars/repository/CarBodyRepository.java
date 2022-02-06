package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.CarBoby;
import ru.job4j.cars.store.HBmStore;

import java.util.Collection;

public class CarBodyRepository {

    private static final class Lazy {
        private static final CarBodyRepository INST = new CarBodyRepository();
    }

    public static CarBodyRepository instOf() {
        return CarBodyRepository.Lazy.INST;
    }

    public Collection<CarBoby> findAllCarBodies() {
        return HBmStore.instOf().tx(session -> session.createQuery("from CarBoby ").list());
    }

    public CarBoby findCarBodyForId(int id) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("from CarBoby where id=:id")
                            .setParameter("id", id);
                    return (CarBoby) query.uniqueResult();
                }
        );
    }

    public void saveCarBodies(CarBoby carBoby) {
        HBmStore.instOf().tx(session -> session.save(carBoby));
    }

}
