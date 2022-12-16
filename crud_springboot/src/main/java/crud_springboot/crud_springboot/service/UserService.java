//Servicios que hara nuestro proyecto para modificar el esquema al que se conecta

package crud_springboot.crud_springboot.service;

import crud_springboot.crud_springboot.model.User;


//Interfaz que servirá de molde para las modificaciones 
public interface UserService {
    
    User getUser(Integer id);

    User save (User user);

    void delete (Integer id);
}
