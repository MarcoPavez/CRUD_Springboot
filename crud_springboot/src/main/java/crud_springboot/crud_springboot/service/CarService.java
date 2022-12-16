package crud_springboot.crud_springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import crud_springboot.crud_springboot.model.Car;
import crud_springboot.crud_springboot.repository.CarRepository;

@Service
@Transactional
public class CarService {
    
    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public void updateCar(Car car){
        carRepository.save(car);
    }

    public List<Car> findAllCar(){
        return carRepository.findAll();
    }// por esta funcion se cambia crudrepository por jparepositorio

    public List<Car> buscarPorMarca(String marca){
        return carRepository.findAllAutoMarca(marca);
    }

    public List<Car> buscarPorColor(String color){
        return carRepository.findAllAutoColor(color);
    }

    public List<Car> buscarPorColorMarca(String color,String marca){
        return carRepository.findAllAutoColorMarca(color, marca);
    }

    public void eliminarAuto(Integer id){
        carRepository.deleteById(id);
    }
}
