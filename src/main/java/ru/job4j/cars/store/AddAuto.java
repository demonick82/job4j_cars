package ru.job4j.cars.store;

import ru.job4j.cars.model.Brand;
import ru.job4j.cars.model.CarBoby;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.model.Transmission;
import ru.job4j.cars.repository.CarBodyRepository;
import ru.job4j.cars.repository.ModelRepository;
import ru.job4j.cars.repository.TransmissionRepository;

public class AddAuto {

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
        ModelRepository.instOf().saveModel(a80);
        ModelRepository.instOf().saveModel(a100);
        ModelRepository.instOf().saveModel(a3);
        ModelRepository.instOf().saveModel(a4);
        ModelRepository.instOf().saveModel(a5);
        ModelRepository.instOf().saveModel(a6);
        ModelRepository.instOf().saveModel(a8);
        ModelRepository.instOf().saveModel(q3);
        ModelRepository.instOf().saveModel(q5);
        ModelRepository.instOf().saveModel(q7);
    }

    public void addCarsBMW() {
        Brand bmw = Brand.of("BMW");
        ModelRepository.instOf().saveModel(Model.of("1 серии", bmw));
        ModelRepository.instOf().saveModel(Model.of("3 серии", bmw));
        ModelRepository.instOf().saveModel(Model.of("5 серии", bmw));
        ModelRepository.instOf().saveModel(Model.of("7 серии", bmw));
        ModelRepository.instOf().saveModel(Model.of("X1", bmw));
        ModelRepository.instOf().saveModel(Model.of("X3", bmw));
        ModelRepository.instOf().saveModel(Model.of("X4", bmw));
        ModelRepository.instOf().saveModel(Model.of("X5", bmw));
        ModelRepository.instOf().saveModel(Model.of("X6", bmw));
    }

    public void addCarsHyundai() {
        Brand hyundai = Brand.of("Hyundai");
        ModelRepository.instOf().saveModel(Model.of("Accent", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Creta", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Elantra", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Getz", hyundai));
        ModelRepository.instOf().saveModel(Model.of("i40", hyundai));
        ModelRepository.instOf().saveModel(Model.of("ix35", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Santa Fe", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Solaris", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Sonata", hyundai));
        ModelRepository.instOf().saveModel(Model.of("Tucson", hyundai));

    }

    public void addCarsKia() {
        Brand kia = Brand.of("Kia");
        ModelRepository.instOf().saveModel(Model.of("Ceed", kia));
        ModelRepository.instOf().saveModel(Model.of("Cerato", kia));
        ModelRepository.instOf().saveModel(Model.of("K5", kia));
        ModelRepository.instOf().saveModel(Model.of("Mohave", kia));
        ModelRepository.instOf().saveModel(Model.of("Optima", kia));
        ModelRepository.instOf().saveModel(Model.of("Picanto", kia));
        ModelRepository.instOf().saveModel(Model.of("Rio", kia));
        ModelRepository.instOf().saveModel(Model.of("Sorento", kia));
        ModelRepository.instOf().saveModel(Model.of("Soul", kia));
        ModelRepository.instOf().saveModel(Model.of("Sportage", kia));
    }

    public void addCarsVaz() {
        Brand vaz = Brand.of("LADA (ВАЗ)");
        ModelRepository.instOf().saveModel(Model.of("2101", vaz));
        ModelRepository.instOf().saveModel(Model.of("2102", vaz));
        ModelRepository.instOf().saveModel(Model.of("2103", vaz));
        ModelRepository.instOf().saveModel(Model.of("2104", vaz));
        ModelRepository.instOf().saveModel(Model.of("2105", vaz));
        ModelRepository.instOf().saveModel(Model.of("2106", vaz));
        ModelRepository.instOf().saveModel(Model.of("2107", vaz));
        ModelRepository.instOf().saveModel(Model.of("2108", vaz));
        ModelRepository.instOf().saveModel(Model.of("2109", vaz));
        ModelRepository.instOf().saveModel(Model.of("2110", vaz));
        ModelRepository.instOf().saveModel(Model.of("2111", vaz));
        ModelRepository.instOf().saveModel(Model.of("2112", vaz));
        ModelRepository.instOf().saveModel(Model.of("2113", vaz));
        ModelRepository.instOf().saveModel(Model.of("2114", vaz));
        ModelRepository.instOf().saveModel(Model.of("2115", vaz));
        ModelRepository.instOf().saveModel(Model.of("Нива", vaz));
        ModelRepository.instOf().saveModel(Model.of("Granta", vaz));
        ModelRepository.instOf().saveModel(Model.of("Kalina", vaz));
        ModelRepository.instOf().saveModel(Model.of("Largus", vaz));
        ModelRepository.instOf().saveModel(Model.of("Priora", vaz));
        ModelRepository.instOf().saveModel(Model.of("Vesta", vaz));
        ModelRepository.instOf().saveModel(Model.of("XRAY", vaz));
    }

    public void addCarBodies() {
        CarBodyRepository.instOf().saveCarBodies(CarBoby.of("Седан"));
        CarBodyRepository.instOf().saveCarBodies(CarBoby.of("Хэтчбек"));
        CarBodyRepository.instOf().saveCarBodies(CarBoby.of("Универсал"));
        CarBodyRepository.instOf().saveCarBodies(CarBoby.of("Внедорожник"));
        CarBodyRepository.instOf().saveCarBodies(CarBoby.of("Купе"));
    }

    public void addTransmissions() {
        TransmissionRepository.instOf().saveTransmissions(Transmission.of("Механика"));
        TransmissionRepository.instOf().saveTransmissions(Transmission.of("Автоматическая"));
        TransmissionRepository.instOf().saveTransmissions(Transmission.of("Робот"));
        TransmissionRepository.instOf().saveTransmissions(Transmission.of("Вариатор"));
        TransmissionRepository.instOf().saveTransmissions(Transmission.of("Вариатор"));
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
