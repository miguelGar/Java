/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.inventarios.servicio;

import com.example.inventarios.modelo.Producto;
import com.example.inventarios.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author miguel
 */
@Service
public class ProductoServicio implements IProductoServicio{
    
    @Autowired
    private ProductoRepositorio ProductoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.ProductoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.ProductoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.ProductoRepositorio.save(producto);
            }

    @Override
    public void eliminarProductoPorId(Integer idproducto) {
        this.ProductoRepositorio.deleteById(idproducto);
            }


}
