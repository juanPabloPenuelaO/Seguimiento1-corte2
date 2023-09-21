package Ejercicio4;

import java.io.Serializable;

public class DTO implements Serializable {
    private Integer turno;

    private String nombre;

    private Integer cedula;

    private static int ultimoTurno;

    public DTO() {this.turno = ++ultimoTurno;
    }

    public DTO(String nombre, Integer cedula) { //Aca es donde se da lo de los turnos
        this();
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "TurnosDTO{" +
                "turno=" + turno +
                ", nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
