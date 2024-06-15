package web.service;

import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.models.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    private final CarDao userDao = new CarDaoImpl();

    @Override
    public List<Car> getCars(int count) {
        return userDao.getCars(count);
    }
    public  List<Car> getCars(){
        return userDao.getCars();
    }
}
