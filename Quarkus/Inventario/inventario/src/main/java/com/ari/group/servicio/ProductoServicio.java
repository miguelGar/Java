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

    public Producto buscarProductoPorId(Long idProducto) {
        return productoRepositorio.findById(idProducto);
    }

    @Transactional
    public Producto guardarProducto(Producto producto) {
        if (productoRepositorio.isPersistent(producto)) {
            productoRepositorio.persist(producto);
        }
        return producto;
    }

    @Transactional
    public void eliminarProductoPorId(Long idProducto) {
        Producto producto = productoRepositorio.findById(idProducto);
        if (producto != null) {
            productoRepositorio.delete(producto);
        }
    }
}
