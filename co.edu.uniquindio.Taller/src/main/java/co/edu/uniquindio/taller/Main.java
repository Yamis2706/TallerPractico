package co.edu.uniquindio.taller;

/**
 * Clase principal para simular el funcionamiento de la tienda.
 * Valida el sistema a través de un caso de uso práctico.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SIMULACIÓN DEL SISTEMA DE PEDIDOS ===\n");
        
        // 1. Crear una instancia de SistemaDePedidos
        SistemaDePedidos sistema = new SistemaDePedidos();
        System.out.println("✓ Sistema de pedidos inicializado");
        
        // 2. Agregar al menos 3 productos diferentes al catálogo
        Producto producto1 = new Producto("TEC-001", "Teclado Mecánico RGB", 89.99);
        Producto producto2 = new Producto("MON-002", "Monitor 24 pulgadas", 199.99);
        Producto producto3 = new Producto("RAT-003", "Ratón Inalámbrico", 29.99);
        Producto producto4 = new Producto("AUD-004", "Audífonos Gaming", 79.99);
        
        sistema.agregarProductoAlCatalogo(producto1);
        sistema.agregarProductoAlCatalogo(producto2);
        sistema.agregarProductoAlCatalogo(producto3);
        sistema.agregarProductoAlCatalogo(producto4);
        
        System.out.println("✓ " + sistema.getCatalogoProductos().size() + " productos agregados al catálogo");
        
        // Mostrar el catálogo usando el método genérico
        SistemaDePedidos.imprimirColeccion("CATÁLOGO DE PRODUCTOS", 
                                         sistema.getCatalogoProductos().values());
        
        // Demostrar la función buscarProducto()
        System.out.println("\n=== DEMOSTRACIÓN DE BÚSQUEDA DE PRODUCTOS ===");
        Producto productoEncontrado = sistema.buscarProducto("TEC-001");
        if (productoEncontrado != null) {
            System.out.println("✓ Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("✗ Producto no encontrado");
        }
        
        Producto productoNoExiste = sistema.buscarProducto("NO-EXISTE");
        if (productoNoExiste != null) {
            System.out.println("✓ Producto encontrado: " + productoNoExiste);
        } else {
            System.out.println("✗ Producto 'NO-EXISTE' no encontrado (comportamiento esperado)");
        }
        
        // Buscar otro producto existente
        Producto monitor = sistema.buscarProducto("MON-002");
        if (monitor != null) {
            System.out.println("✓ Monitor encontrado: " + monitor);
        }
        
        // 3. Crear 2-3 órdenes usando buscarProducto() para simular búsquedas reales
        System.out.println("\n=== CREACIÓN DE ÓRDENES ===");
        
        Orden orden1 = new Orden(101);
        // Simular búsqueda de productos para agregar a la orden
        Producto tecladoParaOrden1 = sistema.buscarProducto("TEC-001");
        Producto monitorParaOrden1 = sistema.buscarProducto("MON-002");
        Producto ratonParaOrden1 = sistema.buscarProducto("RAT-003");
        
        if (tecladoParaOrden1 != null) orden1.agregarProducto(tecladoParaOrden1);
        if (monitorParaOrden1 != null) orden1.agregarProducto(monitorParaOrden1);
        if (ratonParaOrden1 != null) orden1.agregarProducto(ratonParaOrden1);
        
        Orden orden2 = new Orden(102);
        // Orden con productos repetidos
        Producto tecladoParaOrden2a = sistema.buscarProducto("TEC-001");
        Producto tecladoParaOrden2b = sistema.buscarProducto("TEC-001"); // Repetido
        Producto audifonosParaOrden2 = sistema.buscarProducto("AUD-004");
        
        if (tecladoParaOrden2a != null) orden2.agregarProducto(tecladoParaOrden2a);
        if (tecladoParaOrden2b != null) orden2.agregarProducto(tecladoParaOrden2b);
        if (audifonosParaOrden2 != null) orden2.agregarProducto(audifonosParaOrden2);
        
        Orden orden3 = new Orden(103);
        Producto monitorParaOrden3 = sistema.buscarProducto("MON-002");
        Producto ratonParaOrden3 = sistema.buscarProducto("RAT-003");
        Producto audifonosParaOrden3 = sistema.buscarProducto("AUD-004");
        
        if (monitorParaOrden3 != null) orden3.agregarProducto(monitorParaOrden3);
        if (ratonParaOrden3 != null) orden3.agregarProducto(ratonParaOrden3);
        if (audifonosParaOrden3 != null) orden3.agregarProducto(audifonosParaOrden3);
        
        System.out.println("✓ 3 órdenes creadas (orden 102 tiene productos repetidos)");
        
        // 4. Registrar las órdenes en el sistema
        sistema.registrarOrden(orden1);
        sistema.registrarOrden(orden2);
        sistema.registrarOrden(orden3);
        
        System.out.println("✓ Órdenes registradas en el sistema");
        
        // 5. Usar el método genérico imprimirColeccion para mostrar el estado de la cola de pedidos
        SistemaDePedidos.imprimirColeccion("COLA DE PEDIDOS PENDIENTES", 
                                         sistema.getColaDePedidos());
        
        // 6. Procesar todas las órdenes una por una, mostrando la información de cada una
        System.out.println("\n=== PROCESAMIENTO DE ÓRDENES ===");
        
        Orden ordenProcesada;
        int contadorOrdenes = 0;
        
        while ((ordenProcesada = sistema.procesarSiguienteOrden()) != null) {
            contadorOrdenes++;
            System.out.println("Orden #" + ordenProcesada.getId() + " procesada exitosamente");
            System.out.println("Total de productos: " + ordenProcesada.getProductos().size());
            System.out.println("Total a pagar: $" + String.format("%.2f", ordenProcesada.calcularTotal()));
            System.out.println("---");
        }
        
        System.out.println("✓ Total de órdenes procesadas: " + contadorOrdenes);
        
        // 7. Verificar que el método procesarSiguienteOrden informa correctamente cuando la cola queda vacía
        System.out.println("\n=== VERIFICACIÓN DE COLA VACÍA ===");
        sistema.procesarSiguienteOrden(); // Debe mostrar mensaje de cola vacía
        
        // 8. Para una de las órdenes con ítems repetidos, invocar obtenerProductosUnicos() y mostrar el resultado
        System.out.println("\n=== VERIFICACIÓN DE PRODUCTOS ÚNICOS ===");
        System.out.println("Productos en la Orden #102 (con duplicados):");
        SistemaDePedidos.imprimirColeccion("PRODUCTOS ORIGINALES (con duplicados)", orden2.getProductos());
        
        System.out.println("\nProductos únicos en la Orden #102:");
        SistemaDePedidos.imprimirColeccion("PRODUCTOS ÚNICOS (sin duplicados)", orden2.obtenerProductosUnicos());
        
        // Verificación adicional: mostrar que el contrato equals/hashCode funciona
        System.out.println("\n=== VERIFICACIÓN DEL CONTRATO DE IGUALDAD ===");
        Producto tecladoOriginal = new Producto("TEC-001", "Teclado Mecánico RGB", 89.99);
        Producto tecladoCopia = new Producto("TEC-001", "Teclado Mecánico RGB", 89.99);
        
        System.out.println("Producto original: " + tecladoOriginal);
        System.out.println("Producto copia: " + tecladoCopia);
        System.out.println("¿Son iguales? " + tecladoOriginal.equals(tecladoCopia));
        System.out.println("Hash del original: " + tecladoOriginal.hashCode());
        System.out.println("Hash de la copia: " + tecladoCopia.hashCode());
        
        // Demostración final de la eficiencia de buscarProducto()
        System.out.println("\n=== DEMOSTRACIÓN FINAL DE EFICIENCIA DE BÚSQUEDA ===");
        System.out.println("Probando búsquedas múltiples para demostrar eficiencia O(1):");
        
        String[] skusParaBuscar = {"TEC-001", "MON-002", "RAT-003", "AUD-004", "NO-EXISTE"};
        for (String sku : skusParaBuscar) {
            Producto encontrado = sistema.buscarProducto(sku);
            if (encontrado != null) {
                System.out.println("✓ SKU '" + sku + "' encontrado: " + encontrado.getNombre() + " - $" + encontrado.getPrecio());
            } else {
                System.out.println("✗ SKU '" + sku + "' no encontrado");
            }
        }
        
        System.out.println("\n=== SIMULACIÓN COMPLETADA EXITOSAMENTE ===");
    }
}
