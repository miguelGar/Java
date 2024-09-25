package com.mg.rh.repositorio;

import com.mg.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository <Empleado, Integer> {
}
