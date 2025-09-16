package co.edu.uniquindio.taller;

/**
 * Clase que representa un producto en el catálogo de la tienda.
 * Implementa el contrato de igualdad basado en el SKU único.
 */
public class Producto {
    
    // Atributos de la clase
    private String sku;      // Identificador único del producto
    private String nombre;   // Nombre del producto
    private double precio;   // Precio del producto
    
    /**
     * Constructor de la clase Producto
     * @param sku Identificador único del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     */
    public Producto(String sku, String nombre, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Getters y Setters
    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Implementación del contrato de igualdad.
     * Dos productos son iguales si tienen el mismo SKU.
     * @param obj Objeto a comparar
     * @return true si los productos tienen el mismo SKU, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Producto producto = (Producto) obj;
        return sku != null ? sku.equals(producto.sku) : producto.sku == null;
    }
    
    /**
     * Implementación del contrato de igualdad.
     * Genera un código hash basado en el SKU.
     * @return código hash del objeto
     */
    @Override
    public int hashCode() {
        return sku != null ? sku.hashCode() : 0;
    }
    
    /**
     * Representación en cadena del producto
     * @return String con la información del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
