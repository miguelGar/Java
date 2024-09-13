/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.inventarios.controlador;

import com.example.inventarios.exception.AdminException;
import com.example.inventarios.modelo.Producto;
import com.example.inventarios.servicio.ProductoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author miguel
 */
@RestController
// http://localhost:8085/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {
    
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    /*
    API CON SERVICIOS DISPONIBLES QUE SE PODRAN CONSUMIR
    GET, POST, PUT, DELETE
     */

    @Autowired
    private ProductoServicio productoServicio;
    
    // http://localhost:8085/inventario-app/productos
    //Obtiene todos los productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos");
        productos.forEach(producto -> logger.info(producto.toString()));

        return productos;
        
    }
    //Agregar producto
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);

        return this.productoServicio.guardarProducto(producto);
    }
    //Obtiene producto por Id
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto != null)
            return ResponseEntity.ok(producto);
        else
            throw new AdminException("No se encontro el producto");
    }
    //Actualiza producto por Id
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id,
                                                       @RequestBody Producto productoRequest){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto == null)
            throw new AdminException("No se encontro el id: "+ id);
        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setExistencia(productoRequest.getExistencia());
        this.productoServicio.guardarProducto(producto);

        return ResponseEntity.ok(producto);
    }
    //Elimina producto por Id
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = productoServicio.buscarProductoPorId(id);
        if(producto == null)
            throw new AdminException("No se encontro el id: "+ id);
        this.productoServicio.eliminarProductoPorId(producto.getIdeProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);

        return  ResponseEntity.ok(respuesta);

    }



    
}
