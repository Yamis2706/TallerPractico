# Sistema de Procesamiento de Pedidos para E-Commerce

## Descripción
Este proyecto implementa un sistema robusto de procesamiento de pedidos para una tienda online utilizando el Java Collections Framework y Genéricos. El sistema gestiona un catálogo de productos y una cola de pedidos con eficiencia optimizada.

## Estructura del Proyecto

### Clases Implementadas

1. **Producto.java**
   - Representa un artículo en el catálogo
   - Atributos: `sku`, `nombre`, `precio`
   - Implementa contrato `equals()/hashCode()` basado en SKU

2. **Orden.java**
   - Representa un pedido realizado por un cliente
   - Atributos: `id`, `productos` (ArrayList)
   - Métodos: `agregarProducto()`, `calcularTotal()`, `obtenerProductosUnicos()`

3. **SistemaDePedidos.java**
   - Clase central que gestiona toda la lógica del sistema
   - Atributos: `catalogoProductos` (HashMap), `colaDePedidos` (Queue)
   - Métodos de gestión y método genérico `imprimirColeccion()`

4. **Main.java**
   - Simulación completa del funcionamiento del sistema
   - Casos de prueba y verificación de funcionalidades

## Decisiones de Diseño

### Estructuras de Datos Seleccionadas

1. **HashMap para catálogo de productos**
   - **Justificación**: O(1) para búsqueda por SKU único
   - **Ventaja**: Acceso rápido sin iteración

2. **ArrayList para productos en orden**
   - **Justificación**: Permite productos duplicados
   - **Ventaja**: Orden de agregación irrelevante según requerimientos

3. **LinkedList/Queue para cola de pedidos**
   - **Justificación**: Garantiza procesamiento FIFO
   - **Ventaja**: Mantiene orden de llegada de órdenes

4. **HashSet para productos únicos**
   - **Justificación**: Eliminación eficiente de duplicados
   - **Ventaja**: Por definición no permite elementos duplicados

## Cómo Ejecutar

### Opción 1: Desde IntelliJ IDEA
1. Abrir el proyecto en IntelliJ IDEA
2. Ejecutar la clase `Main.java`
3. Observar la salida en consola

### Opción 2: Desde Terminal
```bash
# Compilar
javac -cp src/main/java src/main/java/co/edu/uniquindio/taller/*.java

# Ejecutar
java -cp src/main/java co.edu.uniquindio.taller.Main
```

### Opción 3: Con Maven
```bash
# Compilar
mvn compile

# Ejecutar
mvn exec:java -Dexec.mainClass="co.edu.uniquindio.taller.Main"
```

## Funcionalidades Implementadas

- ✅ Gestión de catálogo de productos
- ✅ Registro y procesamiento de órdenes
- ✅ Búsqueda eficiente por SKU
- ✅ Procesamiento FIFO de pedidos
- ✅ Cálculo de totales de órdenes
- ✅ Eliminación de productos duplicados
- ✅ Método genérico para reportes
- ✅ Contrato de igualdad implementado
- ✅ Simulación completa del sistema

## Salida Esperada

El programa mostrará:
1. Inicialización del sistema
2. Catálogo de productos
3. Cola de pedidos pendientes
4. Procesamiento de órdenes con totales
5. Verificación de cola vacía
6. Demostración de productos únicos
7. Validación del contrato de igualdad

## Tecnologías Utilizadas

- **Java 17** (configurado en pom.xml)
- **Java Collections Framework**
- **Genéricos (Generics)**
- **Maven** para gestión de dependencias
- **IntelliJ IDEA** como IDE

## Notas Técnicas

- Los warnings de Java 24 son normales y no afectan la funcionalidad
- El proyecto está configurado para usar Java 17 para mayor estabilidad
- Todas las decisiones de diseño están justificadas en comentarios
- El código sigue las mejores prácticas de Java
