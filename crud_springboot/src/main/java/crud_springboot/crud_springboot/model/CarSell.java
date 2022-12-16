package crud_springboot.crud_springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CarSell")
public class CarSell {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer cantidad;

    //Se hace relacion entre auto y compra/venta
    //La relacion Muchos a muchos implica dos relaciones 1 a Muchos

    //Many to one a auto
    //Al ser una relacion de tabla relacional ya no se llama a Json
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    private Car car;

    //Many to one a buysell

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="buySell_id")
    private BuySell buySell;

    public CarSell() {
    }

    public CarSell(Integer id, Integer cantidad, Car car, BuySell buySell) {
        this.id = id;
        this.cantidad = cantidad;
        this.car = car;
        this.buySell = buySell;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BuySell getBuySell() {
        return buySell;
    }

    public void setBuySell(BuySell buySell) {
        this.buySell = buySell;
    }




    
    
}
