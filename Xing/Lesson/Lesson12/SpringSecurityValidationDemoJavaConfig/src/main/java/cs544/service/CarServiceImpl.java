package cs544.service;

import cs544.domain.Car;
import cs544.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> get(Long id) {
        return carRepository.findById(id);
    }

//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }
}
