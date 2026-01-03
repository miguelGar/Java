package com.inventario.inventario.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.inventario.model.Proveedor;
import com.inventario.inventario.repository.ProveedorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class ProveedorController {

    private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);


    @Autowired
    private ProveedorRepository proveedorRepository;

    @PostMapping("/proveedores")
    public ResponseEntity<?>  crearProveedor(@RequestBody Proveedor proveedor) {
        //TODO: process POST request
       
        if(proveedor.getNombre() == null || proveedor.getNombre().isBlank()){
            return ResponseEntity.badRequest().body(Map.of("error", "El nombre del proveedor es obligatorio"));
        }
        Proveedor guardado = proveedorRepository.save(proveedor);
        return ResponseEntity.ok(Map.of("succes", true, "id", guardado.getId()));
    }

    @GetMapping("/proveedores")
    public List<Proveedor> listaProveedores(){
        List<Proveedor> proveedor = this.listaProveedores();
        proveedor.forEach(producto -> logger.info(producto.toString()));
        return proveedor;
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable Long id){
        if(!proveedorRepository.existsById(id)){
            return ResponseEntity.status(404).body(Map.of("error", "Proveedor no encontrado"));
        }
        proveedorRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("succes", true, "deleted", 1));
    }
    
    
    
    

}
