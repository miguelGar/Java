package mg.com.servicio;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import mg.com.modelo.Empleado;
import mg.com.repositorio.EmpleadoRepositorio;

import java.util.List;

@ApplicationScoped
public class EmpleadoServicio {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio) { this.empleadoRepositorio = empleadoRepositorio;}

    // Listar todos los empleados
    public List<Empleado> listarEmpleados() { return empleadoRepositorio.listAll(); }

    // buscar productos por Id
    public Empleado buscarEmpleadoporId(Long idProducto) { return  empleadoRepositorio.findById(idProducto); }

    @Transactional
    public Empleado guardarEmpleado(Empleado empleado) {
        if(empleado.getIdEmpleado() == null){
            // New entity, persist it
            empleadoRepositorio.persist(empleado);
        } else {
            // Existing entity, merge it
            Empleado existingEmpleado = empleadoRepositorio.findById(empleado.getIdEmpleado());
            if (existingEmpleado != null) {
                existingEmpleado.setNombre(empleado.getNombre());
                existingEmpleado.setDepartamento(empleado.getDepartamento());
                existingEmpleado.setSueldo(empleado.getSueldo());
                // No need to call persist or merge, as Panache handles it
            } else {
                // If the entity does not exist, persist it as a new entity
                empleadoRepositorio.persist(empleado);
            }
        }

        return empleado;
    }

    @Transactional
    public void eliminarEmpleadoPorId(Long idProducto) {
        Empleado empleado = empleadoRepositorio.findById(idProducto);
        if (empleado != null) {
            empleadoRepositorio.delete(empleado);
        }
    }


}
