package com.mg.rh.controlador;

import com.mg.rh.excepcion.Excepcion;
import com.mg.rh.modelo.Empleado;
import com.mg.rh.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//para recibir y envias peticiones Rest
@RestController
//http://localhost:8080/rhApp
@RequestMapping("rhApp")
// evitar crossOrigin en diferentes puetos,
// agregar puerto de app que se conecte a servicios Spring
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);


    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){

        logger.info("Empleado a agregar:" + empleado);
        return empleadoServicio.guardarEmpleado(empleado);

    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(id);
        if(empleado == null){
            throw new Excepcion("No se encontro el id: "+ id);
        }
        return ResponseEntity.ok((empleado));

    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(
            @PathVariable Integer id,
            @RequestBody Empleado empleadoRecibido){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(id);
        if(empleado == null)
            throw new Excepcion("El id recibido no existe: "+ id);

        // set de los datos
        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleadoRecibido.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);

        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(
            @PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoporId(id);
        if(empleado == null)
            throw new Excepcion("El id recibido no existe: " + id);
        empleadoServicio.eliminarEmpleado(empleado);
        // Json eliminado true
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
