package web.dao;

import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1,"Volga", 200));
        cars.add(new Car(2,"Toyota", 275));
        cars.add(new Car(3,"Moskvich", 2000));
        cars.add(new Car(4,"BMW", 320));
        cars.add(new Car(5,"Nissan", 230));

    }

    @Override
    public List<Car> getCars(int count) {
        return cars.stream().limit(count).toList();
    }

    public List<Car> getCars() {
        return cars;
    }


}
