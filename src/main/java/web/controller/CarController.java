package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarService carService = new CarServiceImpl();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cars.add(new Car("model" + i, i, "color" + i));
        }

        if (count != null) {
            cars = carService.getCars(cars, count);
        }

        model.addAttribute("cars", cars);
        return "cars";
    }
}
