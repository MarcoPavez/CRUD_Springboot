package crud_springboot.crud_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import crud_springboot.crud_springboot.model.User;
import crud_springboot.crud_springboot.repository.UserRepository;

// DEl programa (Java) permite meterse a BBDD y BBDD decide aceptar a java, permitiendo que modifique la misma BBDD

//1 User, 2 Repositorio, 3 UserService, 4 Impl, 5 Controller, 6 relaciones entre clases desde el programa
//Esta es la clase que implementa la interfaz
@Service
public class UserServiceImpl implements UserService{
    
    private UserRepository userRepository; //se importa a repository para que "le pida persmisos"

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository; //esto verifica que la conexion a la BBDD esta correcta
    } //se instancia el servicio con el repositorio, se le pide permiso al repositorio, verifica conexion segura

    @Override
    public User getUser(Integer id){
        //select * from user where id = id
        Optional <User> users = userRepository.findById(id);
        return users.orElse(null); //Si llega vacio, arroja nulo, sino, da la id
    }
    
    @Override
    public User save(User user){
        return userRepository.save(user); //save hace un inser into user (columnas)(values)
    }

    @Override
    public void delete(Integer id){
        //delete from user where id = id
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
