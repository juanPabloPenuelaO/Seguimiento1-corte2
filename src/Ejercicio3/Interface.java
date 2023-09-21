package Ejercicio3;

import Ejercicio3.DTO;

import java.io.IOException;
import java.util.List;

public interface Interface {
    DTO findById(int id);
    List<DTO> findAll() throws IOException, ClassNotFoundException;
    void save(DTO estadistica) throws IOException;
    void update(DTO estadistica) throws IOException;
    void delete(DTO estadistica) throws IOException;
}
