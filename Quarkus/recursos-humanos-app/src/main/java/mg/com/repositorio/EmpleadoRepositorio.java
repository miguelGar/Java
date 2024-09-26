package mg.com.repositorio;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mg.com.modelo.Empleado;

@ApplicationScoped
public class EmpleadoRepositorio implements PanacheRepository<Empleado> {
}
