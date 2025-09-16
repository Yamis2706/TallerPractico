package co.edu.uniquindio.taller;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SIMULACIÓN DE SISTEMA DE PEDIDOS ===\n");
        
        SistemaDePedidos sistema = new SistemaDePedidos();
        System.out.println("✓ Sistema de pedidos inicializado");
        
        Producto producto1 = new Producto("LAB-001", "Labial Rojo Intenso", 25.99);
        Producto producto2 = new Producto("SOM-002", "Sombra de Ojos Profesional", 45.99);
        Producto producto3 = new Producto("RIM-003", "Rímel a Prueba de Agua", 18.99);
        Producto producto4 = new Producto("CRE-004", "Crema Hidratante Facial", 35.99);
        
        sistema.agregarProductoAlCatalogo(producto1);
        sistema.agregarProductoAlCatalogo(producto2);
        sistema.agregarProductoAlCatalogo(producto3);
        sistema.agregarProductoAlCatalogo(producto4);
        
        System.out.println("✓ " + sistema.getCatalogoProductos().size() + " productos agregados al catálogo");
        
        SistemaDePedidos.imprimirColeccion("CATÁLOGO DE PRODUCTOS",
                                         sistema.getCatalogoProductos().values());
        
        System.out.println("\n=== DEMOSTRACIÓN DE BÚSQUEDA DE PRODUCTOS ===");
        Producto productoEncontrado = sistema.buscarProducto("LAB-001");
        if (productoEncontrado != null) {
            System.out.println("✓ Producto encontrado: " + productoEncontrado);
        } else {
            System.out.println("✗ Producto no encontrado");
        }
        
        Producto productoNoExiste = sistema.buscarProducto("NO-EXISTE");
        if (productoNoExiste != null) {
            System.out.println("✓ Producto encontrado: " + productoNoExiste);
        } else {
            System.out.println("✗ Producto 'NO-EXISTE' ");
        }
        
        Producto sombra = sistema.buscarProducto("SOM-002");
        if (sombra != null) {
            System.out.println("✓ Producto encontrado: " + sombra);
        }
        
        System.out.println("\n=== CREACIÓN DE ÓRDENES ===");
        
        Orden orden1 = new Orden(101);
        Producto labialParaOrden1 = sistema.buscarProducto("LAB-001");
        Producto sombraParaOrden1 = sistema.buscarProducto("SOM-002");
        Producto rimelParaOrden1 = sistema.buscarProducto("RIM-003");
        
        if (labialParaOrden1 != null) orden1.agregarProducto(labialParaOrden1);
        if (sombraParaOrden1 != null) orden1.agregarProducto(sombraParaOrden1);
        if (rimelParaOrden1 != null) orden1.agregarProducto(rimelParaOrden1);
        
        Orden orden2 = new Orden(102);
        Producto labialParaOrden2a = sistema.buscarProducto("LAB-001");
        Producto labialParaOrden2b = sistema.buscarProducto("LAB-001");
        Producto cremaParaOrden2 = sistema.buscarProducto("CRE-004");
        
        if (labialParaOrden2a != null) orden2.agregarProducto(labialParaOrden2a);
        if (labialParaOrden2b != null) orden2.agregarProducto(labialParaOrden2b);
        if (cremaParaOrden2 != null) orden2.agregarProducto(cremaParaOrden2);
        
        Orden orden3 = new Orden(103);
        Producto sombraParaOrden3 = sistema.buscarProducto("SOM-002");
        Producto rimelParaOrden3 = sistema.buscarProducto("RIM-003");
        Producto cremaParaOrden3 = sistema.buscarProducto("CRE-004");
        
        if (sombraParaOrden3 != null) orden3.agregarProducto(sombraParaOrden3);
        if (rimelParaOrden3 != null) orden3.agregarProducto(rimelParaOrden3);
        if (cremaParaOrden3 != null) orden3.agregarProducto(cremaParaOrden3);
        
        System.out.println("✓ 3 órdenes creadas (Orden 102 tiene productos " +
                "repetidos)");
        
        sistema.registrarOrden(orden1);
        sistema.registrarOrden(orden2);
        sistema.registrarOrden(orden3);
        
        System.out.println("✓ Órdenes registradas en el sistema");
        
        SistemaDePedidos.imprimirColeccion("COLA DE PEDIDOS PENDIENTES",
                                         sistema.getColaDePedidos());
        
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
        
        System.out.println("\n=== VERIFICACIÓN DE COLA VACÍA ===");
        sistema.procesarSiguienteOrden();
        
        System.out.println("\n=== VERIFICACIÓN DE PRODUCTOS ÚNICOS ===");
        System.out.println("Productos en la Orden #102 (con duplicados):");
        SistemaDePedidos.imprimirColeccion("PRODUCTOS ORIGINALES (con duplicados)", orden2.getProductos());
        
        System.out.println("\nProductos únicos en la Orden #102:");
        SistemaDePedidos.imprimirColeccion("PRODUCTOS ÚNICOS (sin duplicados)", orden2.obtenerProductosUnicos());
        
        System.out.println("\n=== VERIFICACIÓN DEL CONTRATO DE IGUALDAD ===");
        Producto labialOriginal = new Producto("LAB-001", "Labial Rojo Intenso", 25.99);
        Producto labialCopia = new Producto("LAB-001", "Labial Rojo Intenso", 25.99);
        
        System.out.println("Producto original: " + labialOriginal);
        System.out.println("Producto copia: " + labialCopia);
        System.out.println("¿Son iguales? " + labialOriginal.equals(labialCopia));
        System.out.println("Hash del original: " + labialOriginal.hashCode());
        System.out.println("Hash de la copia: " + labialCopia.hashCode());
        
        System.out.println("\n=== DEMOSTRACIÓN FINAL DE EFICIENCIA DE BÚSQUEDA ===");
        System.out.println("Probando búsquedas múltiples para demostrar eficiencia O(1):");
        
        String[] skusParaBuscar = {"LAB-001", "SOM-002", "RIM-003", "CRE-004", "NO-EXISTE"};
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
