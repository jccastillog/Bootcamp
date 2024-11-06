package com.empresa.cruddeforestacionapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.cruddeforestacionapi.dto.AreaCriticaDTO;
import com.empresa.cruddeforestacionapi.service.AreaCriticaService;




@RestController
@RequestMapping("/api/areas-criticas")
public class AreaCriticaControlador {

    @Autowired
    private AreaCriticaService areaCriticaService;

    @GetMapping
    public List<AreaCriticaDTO> obtenerTodasAreasCriticas(){

        List<AreaCriticaDTO> areaCriticaDTOs=areaCriticaService.obtenerTodasAreasCriticas();
        return areaCriticaDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaCriticaDTO> obtenerAreaCriticaPorId(@PathVariable Long id){
        AreaCriticaDTO areaCriticaDTO = new AreaCriticaDTO();
        return ResponseEntity.ok(areaCriticaDTO);
    }

    @PostMapping
    public AreaCriticaDTO crearAreaCritica(@RequestBody AreaCriticaDTO areaCriticaDTO) {
        return areaCriticaService.crearAreaCritica(areaCriticaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaCriticaDTO> actualizarAreaCriticaPorId(@PathVariable Long id, @RequestBody AreaCriticaDTO areaCriticaDTO) {
        AreaCriticaDTO areaCriticaDTOActualizada = areaCriticaService.actualizarAreaCriticaPorId(id, areaCriticaDTO);
        return ResponseEntity.ok(areaCriticaDTOActualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAreaCriticaPorId(@PathVariable Long id){
        areaCriticaService.eliminarAreaCriticaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
