package tp6inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dario
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // 1. agregarProducto(Producto p)
    public void agregarProducto(Producto p) {
        if (buscarProductoPorId(p.getId()) != null) {
            System.out.println("Ya existe un producto con ID " + p.getId() + ". No se agregó.");
            return;
        }
        productos.add(p);
    }

    // 2. listarProductos()
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        productos.forEach(Producto::mostrarInfo);
    }

    // 3. buscarProductoPorId(String id)
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // 4. eliminarProducto(String id)
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }

    // 5. actualizarStock(String id, int nuevaCantidad)
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    // 6. filtrarPorCategoria(CategoriaProducto categoria)
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    // 7. obtenerTotalStock()
    public int obtenerTotalStock() {
        return productos.stream().mapToInt(Producto::getCantidad).sum();
    }

    // 8. obtenerProductoConMayorStock()
    public Producto obtenerProductoConMayorStock() {
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad))
                .orElse(null);
    }

    // 9. filtrarProductosPorPrecio(double min, double max)
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        return productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    // 10. mostrarCategoriasDisponibles()
    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:");
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println("- " + c.toString());
        }
    }

    // método auxiliar para obtener lista (si necesitás)
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}

