package Ejercicio3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1.ObjectoSerializable;
import Ejercicio3.DTO;
import Ejercicio3.Interface;

public class Servicio implements Interface {
    private List<DTO> estadisticas;
    public Servicio() throws IOException,ClassNotFoundException{
        estadisticas = new ArrayList<>();
    }

    @Override
    public DTO findById(int id) {
        return estadisticas.stream()
                .filter(estadistica -> estadistica.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        estadisticas = (List<DTO>) ObjectoSerializable.readObjectFromFile("estadisticas.ax");
        return estadisticas;
    }

    @Override
    public void save(DTO estadistica) throws IOException {
        estadisticas.add(estadistica);
        Ejercicio3.ObjectoSerializable.writeObjectToFile(estadisticas,"estadisticas.ax");
    }

    @Override
    public void update(DTO estadistica) throws IOException {
        DTO oldEstadistica = findById(estadistica.getId());
        if(oldEstadistica!=null){
            estadisticas.remove(oldEstadistica);
            estadisticas.add(estadistica);
            Ejercicio3.ObjectoSerializable.writeObjectToFile(estadisticas,"estadisticas.ax");
        }
    }

    @Override
    public void delete(DTO estadistica) throws IOException {
        estadisticas.remove(estadistica);
        Ejercicio3.ObjectoSerializable.writeObjectToFile(estadisticas,"estadisticas.ax");
    }
}
