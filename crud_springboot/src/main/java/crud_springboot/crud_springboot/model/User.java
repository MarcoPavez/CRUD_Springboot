// ESTO ES LO PRIMERO QUE HAY QUE HACER, CAMBIAR POM, PROPERTIES (MAIN/RESOURCES), 
//CREAR CONTROLLER, MODEL, REPOSITORY y SERVICE DENTRO DE SRC/MAIN/JAVA/BLABLA
//CREAR USER.JAVA DENTRO DE MODEL

package crud_springboot.crud_springboot.model;

import java.util.List;

import javax.persistence.*;

//para poner nombre a BD
@Entity(name="User")
public class User {
    //para crear atributos antes era:
    //private int id;
    //private String nombre;
    //para crear en una tabla, se debe decirle a la tabla cual sera nuestra id (PK)
    //se necesita especificarle que lo que mas adelante viene una llave id (se usa entity)
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name="last_name",unique = true)
    private String lastName;
    @Column(name="email",unique = true)
    private String correo;
    
    //Relacion 1:1

    //@JsonBackReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private License license;

    // 1:Muchos

    //@JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //1:Muchos parte con EAGER
    private List<BuySell> buySell; //un User puede tener muchas compra y ventas de autos



    public User() {
    }



    public User(int id, String name, String lastName, String correo, License license, List<BuySell> buySell) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.correo = correo;
        this.license = license;
        this.buySell = buySell;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getCorreo() {
        return correo;
    }



    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public License getLicense() {
        return license;
    }



    public void setLicense(License license) {
        this.license = license;
    }



    public List<BuySell> getBuySell() {
        return buySell;
    }



    public void setBuySell(List<BuySell> buySell) {
        this.buySell = buySell;
    }

   

}
