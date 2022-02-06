package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.store.HBmStore;

import java.util.Collection;

public class BrandRepository {

    private static final class Lazy {
        private static final BrandRepository INST = new BrandRepository();
    }

    public static BrandRepository instOf() {
        return BrandRepository.Lazy.INST;
    }


    public Collection<Brand> findAllBrands() {
        return HBmStore.instOf().tx(session -> session.createQuery("from Brand").list());
    }

    public Brand findBrandForId(int id) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("from Brand where id=:id")
                            .setParameter("id", id);
                    return (Brand) query.uniqueResult();
                }
        );
    }

    public void saveBrand(Brand brand) {
        HBmStore.instOf().tx(session -> session.save(brand));
    }
}
