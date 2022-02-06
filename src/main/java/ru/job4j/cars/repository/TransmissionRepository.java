package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.Transmission;
import ru.job4j.cars.store.HBmStore;

import java.util.Collection;

public class TransmissionRepository {

    private static final class Lazy {
        private static final TransmissionRepository INST = new TransmissionRepository();
    }

    public static TransmissionRepository instOf() {
        return TransmissionRepository.Lazy.INST;
    }


    public Collection<Transmission> findAllTransmissions() {
        return HBmStore.instOf().tx(session -> session.createQuery("from Transmission ").list());
    }

    public Transmission findTransmissionForId(int id) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("from Transmission where id=:id")
                            .setParameter("id", id);
                    return (Transmission) query.uniqueResult();
                }
        );
    }

    public void saveTransmissions(Transmission transmission) {
        HBmStore.instOf().tx(session -> session.save(transmission));
    }

}
