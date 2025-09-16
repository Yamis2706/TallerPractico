package co.edu.uniquindio.taller;

import java.util.*;


public class SistemaDePedidos {
    
    private Map<String, Producto> catalogoProductos;
    private Queue<Orden> colaDePedidos;

    public SistemaDePedidos() {

        this.catalogoProductos = new HashMap<>();  //En la Decisión de Diseño
        // Crítica para optimización del catálogo, utilizo HashMap porque me
        // permite realizar la búsqueda por SKU (Clave), me permite un acceso
        // rápido a los productos y es la estructura más eficiente para
        // realizar búsquedas por identificador único, proporcionando el
        // rendimiento más alto (0(1))

        this.colaDePedidos = new LinkedList<>(); //En esta Decisión de Diseño
        // Crítica para Procesamiento de Órdenes, elegí LinkedList
        // implementando Queue para ColaDePedidos porque me garantiza un
        // procesamiento FIFO (First-In, First-Out), me permite una
        // insersión/eliminación eficiente, mantiene el orden de llegada de
        // las órdenes y un rendimiento (0(1)) para agregar un producto al
        // final y eliminar un producto del inicio
    }


    public void agregarProductoAlCatalogo(Producto producto) {
        if (producto != null && producto.getSku() != null) {
            catalogoProductos.put(producto.getSku(), producto);
        }
    }
    

    public Producto buscarProducto(String sku) {
        if (sku != null) {
            return catalogoProductos.get(sku);
        }
        return null;
    }

    public void registrarOrden(Orden orden) {
        if (orden != null) {
            colaDePedidos.offer(orden);
        }
    }
    

    public Orden procesarSiguienteOrden() {
        if (colaDePedidos.isEmpty()) {
            System.out.println("La cola de pedidos está vacía. No hay órdenes para procesar.");
            return null;
        }
        
        Orden ordenProcesada = colaDePedidos.poll();
        System.out.println("Procesando Orden #" + ordenProcesada.getId() + 
                          " con un total de $" + String.format("%.2f", ordenProcesada.calcularTotal()));
        
        return ordenProcesada;
    }
    

    public static <T> void imprimirColeccion(String titulo, Collection<T> coleccion) {
        System.out.println("\n=== " + titulo + " ===");
        
        if (coleccion == null || coleccion.isEmpty()) {
            System.out.println("La colección está vacía.");
            return;
        }
        
        int contador = 1;
        for (T elemento : coleccion) {
            System.out.println(contador + ". " + elemento.toString());
            contador++;
        }
        System.out.println("Total de elementos: " + coleccion.size());
    }
    
    public Map<String, Producto> getCatalogoProductos() {
        return catalogoProductos;
    }
    
    public Queue<Orden> getColaDePedidos() {
        return colaDePedidos;
    }
}
