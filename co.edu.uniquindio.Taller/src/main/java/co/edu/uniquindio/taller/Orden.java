package co.edu.uniquindio.taller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class Orden {
    
    private int id;
    private List<Producto> productos;
    

    public Orden(int id) {
        this.id = id;

        this.productos = new ArrayList<>(); //En la Decisión de Diseño de
        // Estructura de Datos para los Productos de una Orden, elegí un
        // ArrayList porque permite duplicados, es decir, una orden puede
        // contener el mismo producto varias veces, no importa el orden en
        // que es agregado el producto, permite un acceso eficiente por
        // índice y ofrece un rendimiento 0(1) para agregar elementos al final
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    


    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    

    public Collection<Producto> obtenerProductosUnicos() {

        return new HashSet<>(productos); //En esta decisión de Diseño utilizo
        // HashSet para eliminar duplicados de manera eficiente y de esta
        // manera obtener productos únicos. Su complejidad o rendimiento es 0
        // (n)
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", productos=" + productos.size() + " items" +
                ", total=" + calcularTotal() +
                '}';
    }
}
