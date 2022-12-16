package crud_springboot.crud_springboot.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="BuySell")
public class BuySell {
    @Id
    @GeneratedValue
    private Integer id;
    @Range(min=0) //nos aseguramos que monto sea siempre mayor a 0
    private int monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCompra;
   
    //recepcionar 1:Muchos
    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)//reciben
    @JoinColumn(name="user_id")
    private User user;
   
    //Many to many de auto
    @ManyToMany(fetch = FetchType.EAGER) //son los que mandan
    @JoinTable(
        name = "CarSell", //nombre tabla relacional
        joinColumns = @JoinColumn(name="buySell_id"),
        inverseJoinColumns = @JoinColumn(name="car_id")
        )
    private List <Car> car;
    
    public BuySell() {
    }

    public BuySell(Integer id, @Range(min = 0) int monto, Date fechaCompra, User user, List<Car> car) {
        this.id = id;
        this.monto = monto;
        this.fechaCompra = fechaCompra;
        this.user = user;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

}
