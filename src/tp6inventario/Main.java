package tp6inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dario
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventario inv = new Inventario();

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        Producto p1 = new Producto("P01", "Arroz 1kg", 700.0, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P02", "Auriculares BT", 2500.0, 20, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P03", "Remera Algodón", 1200.0, 35, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P04", "Lámpara de Mesa", 3200.0, 10, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P05", "Leche 1L", 300.0, 80, CategoriaProducto.ALIMENTOS);

        inv.agregarProducto(p1);
        inv.agregarProducto(p2);
        inv.agregarProducto(p3);
        inv.agregarProducto(p4);
        inv.agregarProducto(p5);

        System.out.println("----- 2. Listar todos los productos -----");
        inv.listarProductos();

        // 3. Buscar un producto por ID y mostrar su información.
        System.out.println("\n----- 3. Buscar producto por ID 'P03' -----");
        Producto buscado = inv.buscarProductoPorId("P03");
        if (buscado != null) buscado.mostrarInfo();
        else System.out.println("Producto no encontrado.");

        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica.
        System.out.println("\n----- 4. Filtrar por categoria ALIMENTOS -----");
        List<Producto> alimentos = inv.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        alimentos.forEach(Producto::mostrarInfo);

        // 5. Eliminar un producto por su ID y listar los productos restantes.
        System.out.println("\n----- 5. Eliminar producto 'P02' (Auriculares) -----");
        boolean eliminado = inv.eliminarProducto("P02");
        System.out.println("Eliminado? " + eliminado);
        System.out.println("Lista actualizada:");
        inv.listarProductos();

        // 6. Actualizar el stock de un producto existente.
        System.out.println("\n----- 6. Actualizar stock de 'P01' a 40 -----");
        boolean actualizado = inv.actualizarStock("P01", 40);
        System.out.println("Actualizado? " + actualizado);
        Producto p01 = inv.buscarProductoPorId("P01");
        if (p01 != null) p01.mostrarInfo();

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n----- 7. Total de stock disponible -----");
        int totalStock = inv.obtenerTotalStock();
        System.out.println("Total (unidades) en inventario: " + totalStock);

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n----- 8. Producto con mayor stock -----");
        Producto mayorStock = inv.obtenerProductoConMayorStock();
        if (mayorStock != null) mayorStock.mostrarInfo();
        else System.out.println("No hay productos.");

        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n----- 9. Filtrar por precio entre $1000 y $3000 -----");
        List<Producto> rangoPrecio = inv.filtrarProductosPorPrecio(1000.0, 3000.0);
        rangoPrecio.forEach(Producto::mostrarInfo);

        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n----- 10. Categorías disponibles -----");
        inv.mostrarCategoriasDisponibles();
    }
}
