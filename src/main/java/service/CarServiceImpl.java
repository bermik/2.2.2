package service;

import model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService{

    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car("model" + i, i, "color" + i));
        }
    }

    public List<Car> getCars(Integer num) {
        if (num != null && num > 0 && num < cars.size()) {
            return cars.subList(0, num);
        } else {
            return cars;
        }
    }
}
