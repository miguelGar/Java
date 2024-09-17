package com.ari.group.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ari.group.excepcion.ExcepcionRequest;
import com.ari.group.modelo.Producto;
import com.ari.group.servicio.ProductoServicio;


import java.util.logging.Logger;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoControlador {

    protected Logger logger = Logger.getLogger(ProductoControlador.class.getName());  // Initialize the logger

    @jakarta.inject.Inject
    ProductoServicio productoServicio;
    
    @GET
    @Path("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos");
        try {
            productos.forEach(producto -> logger.info(producto.toString()));
            return productos;
        } catch (Exception e) {
            // TODO: handle exception
            throw new ExcepcionRequest("No se encontraron lista de productos" + e.getMessage() , 200);
        }
    }

    @POST
    @Path("")
    public Producto agregarProducto(Producto producto) {
        logger.info("Producto a agregar: " + producto);
        return productoServicio.guardarProducto(producto);
    }

    @GET
    @Path("/{id}")
    public Response obtenerProductoPorId(@PathParam("id") int idProducto) {
        Producto producto = productoServicio.buscarProductoPorId(idProducto);
        if (producto != null) {
            return Response.ok(producto).build();
        } else {
            throw new ExcepcionRequest("No se encontro el producto id:"+ idProducto, 200);
        }
    }

    @PUT
    @Path("/{id}")
    public Response actualizarProducto(@PathParam("id") int idProducto, Producto productoRequest){
        
        Producto producto = productoServicio.buscarProductoPorId(idProducto);
        if (producto == null) {
            throw new ExcepcionRequest("No se encontro el id: "+ idProducto, 200);
        }

        producto.setDescripcion(productoRequest.getDescripcion());
        producto.setPrecio(productoRequest.getPrecio());
        producto.setExistencia(productoRequest.getExistencia());

        this.productoServicio.guardarProducto(producto);

        return Response.ok(producto).build();
    }


    @DELETE
    @Path("/{id}")
    public Response eliminarProducto(@PathParam("id") int idProducto) {

        Producto producto = productoServicio.buscarProductoPorId(idProducto);
        if(producto == null)
            throw new ExcepcionRequest("No se encontro el id: "+ idProducto, 200);


        this.productoServicio.eliminarProductoPorId(producto.getIdeProducto());

         Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);

        return Response.ok(respuesta).build();
    }

}
