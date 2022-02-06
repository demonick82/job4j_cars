package ru.job4j.cars.repository;

import org.hibernate.query.Query;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.store.HBmStore;

import java.util.Collection;

public class ModelRepository {

    private static final class Lazy {
        private static final ModelRepository INST = new ModelRepository();
    }

    public static ModelRepository instOf() {
        return ModelRepository.Lazy.INST;
    }

    public Collection<Model> findModelsByMark(String brand) {
        return HBmStore.instOf().tx(session -> session.createQuery("select distinct m from Model m "
                + "join fetch m.brand b  where b.name =:brand ")
                .setParameter("brand", brand)
                .list());
    }

    public Model findModelForId(int brandId, int modelId) {
        return HBmStore.instOf().tx(
                session -> {
                    final Query query = session.createQuery("select distinct m from Model m "
                            + "join fetch m.brand b where b.id =:brandId and m.id=:modelId")
                            .setParameter("brandId", brandId)
                            .setParameter("modelId", modelId);
                    return (Model) query.uniqueResult();
                }
        );
    }

    public void saveModel(Model model) {
        HBmStore.instOf().tx(session -> session.save(model));
    }
}
