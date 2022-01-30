package ru.job4j.cars.store;

import ru.job4j.cars.model.Brand;
import ru.job4j.cars.model.CarBoby;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.model.Transmission;

public class AddAuto {
    private Store store = HBmStore.instOf();

    public void addCarsAudy() {
        Brand audi = Brand.of("Audi");
        Model a80 = Model.of("80", audi);
        Model a100 = Model.of("100", audi);
        Model a3 = Model.of("A3", audi);
        Model a4 = Model.of("A4", audi);
        Model a5 = Model.of("A5", audi);
        Model a6 = Model.of("A6", audi);
        Model a8 = Model.of("A8", audi);
        Model q3 = Model.of("Q3", audi);
        Model q5 = Model.of("Q5", audi);
        Model q7 = Model.of("Q7", audi);
        store.saveModel(a80);
        store.saveModel(a100);
        store.saveModel(a3);
        store.saveModel(a4);
        store.saveModel(a5);
        store.saveModel(a6);
        store.saveModel(a8);
        store.saveModel(q3);
        store.saveModel(q5);
        store.saveModel(q7);
    }

    public void addCarsBMW() {
        Brand bmw = Brand.of("BMW");
        store.saveModel(Model.of("1 серии", bmw));
        store.saveModel(Model.of("3 серии", bmw));
        store.saveModel(Model.of("5 серии", bmw));
        store.saveModel(Model.of("7 серии", bmw));
        store.saveModel(Model.of("X1", bmw));
        store.saveModel(Model.of("X3", bmw));
        store.saveModel(Model.of("X4", bmw));
        store.saveModel(Model.of("X5", bmw));
        store.saveModel(Model.of("X6", bmw));
    }

    public void addCarsHyundai() {
        Brand hyundai = Brand.of("Hyundai");
        store.saveModel(Model.of("Accent", hyundai));
        store.saveModel(Model.of("Creta", hyundai));
        store.saveModel(Model.of("Elantra", hyundai));
        store.saveModel(Model.of("Getz", hyundai));
        store.saveModel(Model.of("i40", hyundai));
        store.saveModel(Model.of("ix35", hyundai));
        store.saveModel(Model.of("Santa Fe", hyundai));
        store.saveModel(Model.of("Solaris", hyundai));
        store.saveModel(Model.of("Sonata", hyundai));
        store.saveModel(Model.of("Tucson", hyundai));

    }

    public void addCarsKia() {
        Brand kia = Brand.of("Kia");
        store.saveModel(Model.of("Ceed", kia));
        store.saveModel(Model.of("Cerato", kia));
        store.saveModel(Model.of("K5", kia));
        store.saveModel(Model.of("Mohave", kia));
        store.saveModel(Model.of("Optima", kia));
        store.saveModel(Model.of("Picanto", kia));
        store.saveModel(Model.of("Rio", kia));
        store.saveModel(Model.of("Sorento", kia));
        store.saveModel(Model.of("Soul", kia));
        store.saveModel(Model.of("Sportage", kia));
    }

    public void addCarsVaz() {
        Brand vaz = Brand.of("LADA (ВАЗ)");
        store.saveModel(Model.of("2101", vaz));
        store.saveModel(Model.of("2102", vaz));
        store.saveModel(Model.of("2103", vaz));
        store.saveModel(Model.of("2104", vaz));
        store.saveModel(Model.of("2105", vaz));
        store.saveModel(Model.of("2106", vaz));
        store.saveModel(Model.of("2107", vaz));
        store.saveModel(Model.of("2108", vaz));
        store.saveModel(Model.of("2109", vaz));
        store.saveModel(Model.of("2110", vaz));
        store.saveModel(Model.of("2111", vaz));
        store.saveModel(Model.of("2112", vaz));
        store.saveModel(Model.of("2113", vaz));
        store.saveModel(Model.of("2114", vaz));
        store.saveModel(Model.of("2115", vaz));
        store.saveModel(Model.of("Нива", vaz));
        store.saveModel(Model.of("Granta", vaz));
        store.saveModel(Model.of("Kalina", vaz));
        store.saveModel(Model.of("Largus", vaz));
        store.saveModel(Model.of("Priora", vaz));
        store.saveModel(Model.of("Vesta", vaz));
        store.saveModel(Model.of("XRAY", vaz));
    }

    public void addCarBodies() {
        store.saveCarBodies(CarBoby.of("Седан"));
        store.saveCarBodies(CarBoby.of("Хэтчбек"));
        store.saveCarBodies(CarBoby.of("Универсал"));
        store.saveCarBodies(CarBoby.of("Внедорожник"));
        store.saveCarBodies(CarBoby.of("Купе"));
    }

    public void addTransmissions() {
        store.saveTransmissions(Transmission.of("Механика"));
        store.saveTransmissions(Transmission.of("Автоматическая"));
        store.saveTransmissions(Transmission.of("Робот"));
        store.saveTransmissions(Transmission.of("Вариатор"));
        store.saveTransmissions(Transmission.of("Вариатор"));
    }


    public static void main(String[] args) {
        new AddAuto().addCarsAudy();
        new AddAuto().addCarsBMW();
        new AddAuto().addCarsHyundai();
        new AddAuto().addCarsKia();
        new AddAuto().addCarsVaz();
        new AddAuto().addCarBodies();
        new AddAuto().addTransmissions();


    }
}
