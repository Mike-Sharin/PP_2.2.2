package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private static List<Car> cars;
    private static int COUNT_CAR;

    static
    {
        cars = new ArrayList<>();

        while (COUNT_CAR < 5) {
            cars.add(new Car(++COUNT_CAR, "model"+ COUNT_CAR, (100 + COUNT_CAR), "color" + COUNT_CAR ));
        }
    }

    public List<Car> listCountCars(int count) {
        if (count <= 0 ) {
            return cars.stream().sorted(Comparator.comparing(Car::getId)).collect(Collectors.toList());
        } else {
            return cars.stream().sorted(Comparator.comparing(Car::getId)).limit(count).collect(Collectors.toList());
        }
    }
}
