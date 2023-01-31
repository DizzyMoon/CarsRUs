package dat3.car.repository;

import dat3.car.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {
}
