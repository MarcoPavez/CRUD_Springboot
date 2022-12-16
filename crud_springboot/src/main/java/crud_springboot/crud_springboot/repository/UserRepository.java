//Controller configura y vincula front end (web) con codigo (programa) y viceversa. Se importan los servicios y se les da permisos para que el controller funcione efectivamente, el controlle decide si mostrar en web lo del codigo
//Repository configura programa con la BBDD y viceversa. El repository le tiene que pedir permiso al servicio, la dif es que aca el servicio es quien deja entrar o no al repositorio

//Modelo(esqueleto de objetos -modelos-) vista(postman) controlador(todo lo de java, pero es mas amplio: modelos, servicio, repositorio y controlador)
//El objeto debe guardarse de alguna forma en la BBDD, y aqui entran los repositorios, es el nivel que se preocupa de las solicitudes de la bbdd, Manda y recibe informacion hacia la BBDD
//Controlador: Se conecta directamente con la web y recibe estimulos de lo que debe hacer. Se relaciona con el postman
//Repositorio:
//Servicio: Empieza a llamar las funcionalidades de la BBDD, pide permisos y verifica conexion, da la facilidad de editar, agregar, traer y hacer querys. Genera las funciones necesarios para que se hagan consultas

package crud_springboot.crud_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud_springboot.crud_springboot.model.User;

//Luego del extends viene la funcionalidad pre hecha, 
//CrudRepository nos permite buscar cosas en la BBDD sin necesidad de programarla, se usan funciones predefinidas
//Para que funcione crud requiere que se le entreguen los objetos a trabajar

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
    
}
