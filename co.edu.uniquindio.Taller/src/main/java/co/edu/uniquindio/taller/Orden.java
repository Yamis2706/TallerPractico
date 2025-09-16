package co.edu.uniquindio.taller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Clase que representa una orden realizada por un cliente.
 * Permite agregar productos y calcular el total de la orden.
 */
public class Orden {
    
    // Atributos de la clase
    private int id;                    // Identificador único de la orden
    private List<Producto> productos; // Colección de productos en la orden
    
    /**
     * Constructor que inicializa la orden con un id
     * @param id Identificador único de la orden
     */
    public Orden(int id) {
        this.id = id;
        // Decisiones de Diseño: 
        // Se utiliza ArrayList porque:
        // 1. Una orden puede contener el mismo producto varias veces (permite duplicados)
        // 2. El orden de agregación es irrelevante según los requerimientos
        // 3. ArrayList ofrece O(1) para agregar elementos al final
        // 4. Permite acceso eficiente por índice si se necesita en el futuro
        this.productos = new ArrayList<>();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public List<Producto> getProductos() {
        return productos;
    }
    
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    /**
     * Añade un producto a la lista de la orden
     * @param producto Producto a agregar a la orden
     */
    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }
    
    /**
     * Calcula y devuelve el precio total de la orden sumando los precios de todos sus productos
     * @return Total de la orden
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    
    /**
     * Devuelve una colección con los productos únicos de la orden (sin duplicados)
     * @return Colección de productos únicos
     */
    public Collection<Producto> obtenerProductosUnicos() {
        // Decisiones de Diseño:
        // Se utiliza HashSet para eliminar duplicados eficientemente.
        // HashSet por definición no permite elementos duplicados,
        // por lo que es la forma más eficiente de obtener productos únicos.
        // La complejidad es O(n) donde n es el número de productos en la orden.
        return new HashSet<>(productos);
    }
    
    /**
     * Representación en cadena de la orden
     * @return String con la información de la orden
     */
    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", productos=" + productos.size() + " items" +
                ", total=" + calcularTotal() +
                '}';
    }
}
