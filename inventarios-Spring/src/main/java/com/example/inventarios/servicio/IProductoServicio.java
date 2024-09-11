/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.inventarios.servicio;

import com.example.inventarios.modelo.Producto;
import java.util.List;

/**
 *
 * @author miguel
 */
public interface IProductoServicio {
    
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(Integer idProducto);
    public Producto guardarProducto(Producto producto);
    public void eliminarProductoPorId(Integer idproducto);
    
}
