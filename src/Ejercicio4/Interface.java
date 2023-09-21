package Ejercicio4;

import Ejercicio4.DTO;

import java.io.IOException;
import java.util.List;

public interface Interface {

    DTO findById(Integer id);

    List<DTO> findAll() throws IOException, ClassNotFoundException; //Listar


    void save (DTO turno) throws IOException;

    void update (DTO turno) throws IOException;

    void delete (DTO turno) throws IOException;

    public int total();
}
