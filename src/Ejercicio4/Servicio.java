package Ejercicio4;

import Ejercicio4.DTO;
import Ejercicio4.Interface;
import Ejercicio4.Serializacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Interface {

    private List<DTO> turnos;

    public Servicio() throws IOException, ClassNotFoundException {
        turnos = new ArrayList<>();
    }

    @Override
    public DTO findById(Integer id) {
        DTO resultado = null;
        for (DTO mas: turnos) {
            if (mas.getTurno() != null && mas.getTurno().equals(id)) {
                resultado = mas;
                break;
            }
        }
        return resultado;
    }

    @Override
    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        turnos = (List<DTO>) Serializacion.readObjetFromFile("Turnos.ax");
        return turnos;
    }

    @Override
    public void save(DTO turno) throws IOException {
        turnos.add(turno);
        Serializacion.writeObjectToFile(turnos, "Turnos.ax");
    }

    @Override
    public void update(DTO turno) throws IOException {
        DTO oldTurno = findById(turno.getTurno());
        if (oldTurno != null) {
            turnos.remove(oldTurno);
            turnos.add(turno);
            Serializacion.writeObjectToFile(turnos, "Turnos.ax");
        }
    }

    @Override
    public void delete(DTO turno) throws IOException {
        turnos.remove(turno);
        Serializacion.writeObjectToFile(turnos, "Turnos.ax");
    }

    @Override
    public int total() {
        return this.turnos.size();
    }
}
