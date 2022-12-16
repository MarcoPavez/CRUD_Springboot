package crud_springboot.crud_springboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import crud_springboot.crud_springboot.model.License;

public interface LicenseRepository extends JpaRepository<License,Integer>{
    
    @Query(value="SELECT * FROM license WHERE clase = ?1" ,nativeQuery=true)
    List<License> findAllClase(String clase);

    @Query(value="SELECT * FROM license WHERE estado = ?1", nativeQuery = true)
    List<License> findAllEstado(String estado);

    @Query(value="SELECT * FROM license WHERE clase = ?1 AND WHERE estado = ?2", nativeQuery = true)
    List<License> findAllClaseEstado(String clase, String estado);

    @Query(value="SELECT * FROM license WHERE fechaVencimiento < 2022-11-21", nativeQuery = true)
    List<License> findAllVencidos(Date fechaVencimiento);
}

