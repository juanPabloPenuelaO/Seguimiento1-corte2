package Ejercicio3;

import java.io.Serializable;

public class DTO implements Serializable {
    public Integer id;
    private String tipAtencion;

    public DTO(Integer id, String tipAtencion) {
        this.id = id;
        this.tipAtencion = tipAtencion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipAtencion() {
        return tipAtencion;
    }

    public void setTipAtencion(String tipAtencion) {
        this.tipAtencion = tipAtencion;
    }


    @Override
    public String toString() {
        return "EstadisticasDTO{" +
                "id=" + id +
                ", tipAtencion='" + tipAtencion + '\'' +
                '}';
    }
}