package crud_springboot.crud_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; //este repositorio se acomoda mas a lo que se quiere que se devuelva
import org.springframework.data.jpa.repository.Query;

import crud_springboot.crud_springboot.model.Car;

public interface CarRepository extends JpaRepository <Car, Integer>{
    
    //es capaz de reconocer ?1, va a mandar algo que no se pero que tiene que buscar en la posicion 1, y luego reemplazar todo por ese dato
    @Query(value= "SELECT * FROM car WHERE marca = ?1", nativeQuery = true)
    List<Car> findAllAutoMarca(String marca); // la query pasa a ser findAllAutoMarca   WAW

    @Query(value= "SELECT * FROM car WHERE color = ?1", nativeQuery = true)
    List<Car> findAllAutoColor(String color);

    @Query(value= "SELECT * FROM car WHERE color = ?1 AND WHERE marca = ?2", nativeQuery = true) //Aca se cambia el 1 por el 2 porque indica la posicion de las variables
    List<Car> findAllAutoColorMarca(String color, String marca);

    @Query(value= "SELECT * FROM car c JOIN c.carsell cs", nativeQuery = true)
    List<Car> buscarAutosVendidos();
}
