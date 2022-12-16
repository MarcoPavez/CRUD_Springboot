package crud_springboot.crud_springboot.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="License")
public class License {
    @Id // define la ID, la PK
    @GeneratedValue // define la ID, la PK
    private Integer id;
    private int numero;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaVencimiento;
    private String clase;
    private String estado;
    
    //relacion 1:1 para recepcionar desde user
    //@JsonManagedReference //para recepcionar. licencia recibe datos de usuario, por eso es managed
    @OneToOne(fetch = FetchType.EAGER) //para recepcionar 1:1 eager recepciona a lazy
    @JoinColumn(name = "user_id") //nombre de vinculo entre tablas, es la columna de FK
    private User user; //esto se conecta todo con User

    public License() {
    }

    public License(Integer id, int numero, Date fechaVencimiento, String clase, String estado, User user) {
        this.id = id;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.clase = clase;
        this.estado = estado;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    
}
