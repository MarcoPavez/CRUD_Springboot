package crud_springboot.crud_springboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import crud_springboot.crud_springboot.model.BuySell;

public interface BuySellRepository extends JpaRepository <BuySell, Integer>{
    
    @Query(value="SELECT * FROM buysell bs WHERE fechaCompra = ?1",nativeQuery=true)
    List<BuySell> findCompradosUltimoAnio(Date fechaCompra);
}
