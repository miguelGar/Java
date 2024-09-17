package com.ari.group.servicio;

import java.util.List;

import com.ari.group.modelo.Producto;
import com.ari.group.repositorio.ProductoRepositorio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    public List<Producto> listarProductos() {
        return productoRepositorio.listAll();
    }

    public Producto buscarProductoPorId(int idProducto) {
        return productoRepositorio.findById((long) idProducto);
    }

    @Transactional
    public Producto guardarProducto(Producto producto) {
        if (producto.getIdeProducto() == null) {
            // New entity, persist it
            productoRepositorio.persist(producto);
        } else {
            // Existing entity, merge it
            Producto existingProducto = productoRepositorio.findById(producto.getIdeProducto());
            if (existingProducto != null) {
                existingProducto.setDescripcion(producto.getDescripcion());
                existingProducto.setPrecio(producto.getPrecio());
                existingProducto.setExistencia(producto.getExistencia());
                // No need to call persist or merge, as Panache handles it
            } else {
                // If the entity does not exist, persist it as a new entity
                productoRepositorio.persist(producto);
            }
        }
        return producto;
    }

    @Transactional
    public void eliminarProductoPorId(Long idProducto) {
        Producto producto = productoRepositorio.findById((long) idProducto);
        if (producto != null) {
            productoRepositorio.delete(producto);
        }
    }
}
