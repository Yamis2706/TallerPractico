package co.edu.uniquindio.taller;

import java.util.*;

/**
 * Clase central que gestiona toda la lógica de productos y procesamiento de órdenes.
 * Centraliza la gestión del catálogo de productos y la cola de pedidos.
 */
public class SistemaDePedidos {
    
    // Atributos de la clase
    private Map<String, Producto> catalogoProductos;  // Catálogo de productos disponibles
    private Queue<Orden> colaDePedidos;               // Cola de órdenes pendientes
    
    /**
     * Constructor que inicializa el sistema
     */
    public SistemaDePedidos() {
        // Decisiones de Diseño - Optimización del Catálogo:
        // Se utiliza HashMap para catalogoProductos porque:
        // - Proporciona búsqueda O(1) por SKU (clave)
        // - SKU es único, por lo que es perfecto como clave
        // - Permite acceso rápido a productos sin iterar
        // - Es la estructura más eficiente para búsquedas por identificador único
        this.catalogoProductos = new HashMap<>();
        
        // Decisiones de Diseño - Procesamiento de Órdenes:
        // Se utiliza LinkedList implementando Queue para colaDePedidos porque:
        // - Garantiza procesamiento FIFO (First-In, First-Out)
        // - LinkedList implementa Queue y permite inserción/eliminación eficiente
        // - Mantiene el orden de llegada de las órdenes
        // - Proporciona O(1) para agregar al final y eliminar del inicio
        this.colaDePedidos = new LinkedList<>();
    }
    
    /**
     * Agrega un producto al catálogo
     * @param producto Producto a agregar al catálogo
     */
    public void agregarProductoAlCatalogo(Producto producto) {
        if (producto != null && producto.getSku() != null) {
            catalogoProductos.put(producto.getSku(), producto);
        }
    }
    
    /**
     * Busca un producto en el catálogo por su SKU
     * @param sku SKU del producto a buscar
     * @return Producto encontrado o null si no existe
     */
    public Producto buscarProducto(String sku) {
        if (sku != null) {
            return catalogoProductos.get(sku);
        }
        return null;
    }
    
    /**
     * Registra una orden en el sistema para su procesamiento
     * @param orden Orden a registrar
     */
    public void registrarOrden(Orden orden) {
        if (orden != null) {
            colaDePedidos.offer(orden);
        }
    }
    
    /**
     * Procesa la siguiente orden en la cola
     * @return Orden procesada o null si la cola está vacía
     */
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
    
    /**
     * Método estático y genérico para imprimir los contenidos de cualquier colección.
     * Sigue el principio DRY (Don't Repeat Yourself).
     * @param titulo Título a mostrar antes de la colección
     * @param coleccion Colección a imprimir
     * @param <T> Tipo genérico de los elementos en la colección
     */
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
    
    // Getters para acceso a las colecciones (útil para reportes)
    public Map<String, Producto> getCatalogoProductos() {
        return catalogoProductos;
    }
    
    public Queue<Orden> getColaDePedidos() {
        return colaDePedidos;
    }
}
