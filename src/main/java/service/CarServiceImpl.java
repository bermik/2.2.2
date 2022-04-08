package service;

import model.Car;

import java.util.List;

public class CarServiceImpl implements CarService{

    public List<Car> getCars(List<Car> cars, int num) {
        if (num >= cars.size()) {
            return cars;
        } else if (num < 0) {
            return null;
        }
        return cars.subList(0, num);
    }
}
