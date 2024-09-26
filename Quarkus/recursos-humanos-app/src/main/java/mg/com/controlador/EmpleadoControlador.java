package mg.com.controlador;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mg.com.excepcion.ExcepcionRequest;
import mg.com.modelo.Empleado;
import mg.com.servicio.EmpleadoServicio;


@Path("rhApp")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmpleadoControlador {

    protected Logger logger = Logger.getLogger(EmpleadoControlador.class.getName());

    @Inject
    EmpleadoServicio empleadoServicio;

    @GET
    @Path("/empleados")
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = this.empleadoServicio.listarEmpleados();
        logger.info("Empleados existentes");
        try {
            empleados.forEach(empleado -> logger.info(empleado.toString()));
            return empleados;
        } catch (Exception e){
            throw new ExcepcionRequest("No se encontro lista de empleados" + e.getMessage(), 200);
        }
    }

    @POST
    @Path("/empleados")
    public Empleado agregarEmpleado(Empleado empleado){
        logger.info("Empleado agregado"+ empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GET
    @Path("/empleados/{id}")
    public Response obtenerEmpleadoPorId(@PathParam("id") Long idProducto){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(idProducto);
        if(empleado != null){
            return  Response.ok(empleado).build();
        } else {
            throw new ExcepcionRequest("No se encontro el empleado con id:" + idProducto, 200);
        }

    }

    @PUT
    @Path("/empleados/{id}")
    public Response actualizarEmpleado(@PathParam("id") Long idEmpleado,
                                       Empleado empleadoRequest){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(idEmpleado);
        if( empleado == null){
            throw new ExcepcionRequest("No se encontro el id: " + idEmpleado, 200);
        }

        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setDepartamento(empleadoRequest.getDepartamento());
        empleado.setSueldo(empleadoRequest.getSueldo());

        this.empleadoServicio.guardarEmpleado(empleado);

        return Response.ok(empleado).build();

    }

    @DELETE
    @Path("/empleados/{id}")
    public Response eliminarEmpleado(@PathParam("id") Long idEmpleado){

        Empleado empleado = empleadoServicio.buscarEmpleadoporId(idEmpleado);
        if (empleado == null) {
            throw new ExcepcionRequest("No se encontro el id del empleado: "+ idEmpleado, 200);
        }

        this.empleadoServicio.eliminarEmpleadoPorId(empleado.getIdEmpleado());

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Empleado eliminado ", Boolean.TRUE);

        return Response.ok(respuesta).build();
    }



}
