package crud_springboot.crud_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import crud_springboot.crud_springboot.model.CarSell;

public interface CarSellRepository extends JpaRepository <CarSell, Integer>{
    
    @Query(value = "SELECT * FROM prueba_api.car_sell WHERE cantidad < ?1", nativeQuery = true)
    List<CarSell> findMasVendidos(Integer cantidad);

    @Query(value="SELECT * FROM carsell cs WHERE cantidad < ?1 JOIN cs.buysell bs SUM (?2)", nativeQuery = true)
    List<CarSell> findMontoMasVendidos(Integer cantidad, int monto);
}
