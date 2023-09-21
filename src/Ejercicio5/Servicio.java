package Ejercicio5;

import Ejercicio5.DTO;
import Ejercicio5.Interface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Interface {

    private List<DTO> carrito;

    public Servicio () throws IOException, ClassNotFoundException {
        carrito = new ArrayList<>();
    }


    @Override
    public DTO findById(int id) {
        return carrito.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<DTO> findall() throws IOException, ClassNotFoundException {
        carrito = (List<DTO>) Serializable.readObjetFromFile("Carrito.ax");
        return carrito;
    }

    @Override
    public void save(DTO producto) throws IOException {
        carrito.add(producto);
        Serializable.writeObjectToFile(carrito, "Carrito.ax");
    }

    @Override
    public void update(DTO producto) throws IOException {
        DTO oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            carrito.remove(oldProducto);
            carrito.add(producto);
            Serializable.writeObjectToFile(carrito, "Carrito.ax");
        }
    }

    @Override
    public void delete(DTO producto) throws IOException {
        carrito.remove(producto);
        Serializable.writeObjectToFile(carrito, "Carrito.ax");
    }
}
