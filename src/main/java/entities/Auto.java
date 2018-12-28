package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({

        @NamedQuery(
                name = "obtenerAutosSegunMarca",
                query = "FROM Auto WHERE marca LIKE :marca"
        ),
        @NamedQuery(
                name = "obtenerAutosSegunModelo",
                query = "FROM Auto WHERE modelo LIKE :modelo"
        ),
        @NamedQuery(
                name = "obtenerAutosCaros",
                query = "FROM Auto WHERE precio > :precio2"
        )

})

@Entity
@Table(name="autos")
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="au_id")
    private Long id;

    @Column(name="au_marca")
    private String marca;

    @Column(name="au_modelo")
    private String modelo;

    @Column(name="au_fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;

    @Column(name="au_precio")
    private Double precio;

    public Auto(){

    }

    public Auto(Long id, String marca, String modelo, Date fecha_venta, Double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha_venta = fecha_venta;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fecha_venta=" + fecha_venta +
                ", precio=" + precio +
                '}';
    }

}
