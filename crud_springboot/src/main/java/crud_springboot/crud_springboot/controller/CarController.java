package crud_springboot.crud_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import crud_springboot.crud_springboot.model.Car;
import crud_springboot.crud_springboot.service.CarService;

@RestController
@CrossOrigin("*")
public class CarController {
    
    private CarService carService;

    public CarController(@Autowired CarService carService){
        this.carService = carService;
    }

    @PostMapping("/Car/save")
    public void guardarAuto(@RequestBody Car car){
        carService.saveCar(car);
    }

    @PutMapping("/Car/update")
    public void actualizarAuto(@RequestBody Car car){
        carService.updateCar(car);
    }

    @GetMapping("/Car/findAll")
    public List<Car> todosLosAutos(){
        return carService.findAllCar();
    }

    @GetMapping("/Car/buscarMarca/{marca}") //OJO ACA, EL PATHVARIABLE REQUIERE QUE SE MODIFIQUE LA URL
    public List<Car> buscarMarca(@PathVariable String marca){
        return carService.buscarPorMarca(marca);
    }

    @GetMapping("/Car/buscarColor")
    public List<Car> colorAuto(@RequestBody String color){
        return carService.buscarPorColor(color);
    }

    @GetMapping("/Car/buscarColorMarca")
    public List<Car> colorMarcaAuto(@RequestBody String color, String marca){
        return carService.buscarPorColorMarca(color, marca);
    }

    @DeleteMapping("/Car/eliminarAuto/{id}")
    public void eliminarAuto(@PathVariable Integer id){
        carService.eliminarAuto(id);
    }
}
