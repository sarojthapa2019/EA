package cs544.service;

import cs544.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAll();

    Optional<Car> get(Long id);

    void add(Car car);

    void delete(Long id);

    void update(Car car);
}
