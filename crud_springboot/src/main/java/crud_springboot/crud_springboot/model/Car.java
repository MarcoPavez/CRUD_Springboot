package crud_springboot.crud_springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Range;

@Entity(name="Car") //permite crear la tabla y darle nombre en la BBDD
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    private String marca;
    private String modelo;
    private String color;
    private int anio;
    @Range(min=0) //nos aseguramos que monto sea siempre mayor a 0
    private int valor;
    
    //Many to many (ya no se ocupa jsonback ni jsonmanaged)
    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="CarSell",//nombre de tabla relacional
        joinColumns = @JoinColumn(name="car_id"), //nombre de columna la tabla car
        inverseJoinColumns = @JoinColumn(name="buySell_id") //nombre de columna de tabla buysell
    )

    private List <CarSell> carsell;


    public Car() {
    }


    public Car(Integer id, String marca, String modelo, String color, int anio, @Range(min = 0) int valor,
            List<CarSell> carsell) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.valor = valor;
        this.carsell = carsell;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public int getAnio() {
        return anio;
    }


    public void setAnio(int anio) {
        this.anio = anio;
    }


    public int getValor() {
        return valor;
    }


    public void setValor(int valor) {
        this.valor = valor;
    }


    public List<CarSell> getCarsell() {
        return carsell;
    }


    public void setCarsell(List<CarSell> carsell) {
        this.carsell = carsell;
    }


    
    
}
