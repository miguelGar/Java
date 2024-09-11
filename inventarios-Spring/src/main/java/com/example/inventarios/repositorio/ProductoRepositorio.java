/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.inventarios.repositorio;

import com.example.inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author miguel
 */
public interface ProductoRepositorio  extends JpaRepository<Producto, Integer>{
    
}
