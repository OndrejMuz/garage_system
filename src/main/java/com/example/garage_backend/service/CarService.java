package com.example.garage_backend.service;

import com.example.garage_backend.model.Car;
import com.example.garage_backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> updateCar(Long id, Car updatedCar) {
        return carRepository.findById(id).map(existingCar -> {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setYearMade(updatedCar.getYearMade());
            existingCar.setColor(updatedCar.getColor());
            existingCar.setLicensePlate(updatedCar.getLicensePlate());
            existingCar.setOwnerName(updatedCar.getOwnerName());
            return carRepository.save(existingCar);
        });
    }

    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
