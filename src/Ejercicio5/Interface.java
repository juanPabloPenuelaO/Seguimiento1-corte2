package Ejercicio5;

import Ejercicio5.DTO;

import java.io.IOException;
import java.util.List;

public interface Interface {

    DTO findById (int id);

    List<DTO> findall() throws IOException, ClassNotFoundException;

    void save (DTO producto) throws IOException;

    void update (DTO producto) throws IOException;

    void delete (DTO producto) throws IOException;

}