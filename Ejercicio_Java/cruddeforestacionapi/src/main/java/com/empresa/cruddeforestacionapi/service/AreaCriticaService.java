package com.empresa.cruddeforestacionapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cruddeforestacionapi.dto.AreaCriticaDTO;
import com.empresa.cruddeforestacionapi.entity.AreaCriticaEntity;
import com.empresa.cruddeforestacionapi.exceptions.RecursoNoEncontradoExcepcion;
import com.empresa.cruddeforestacionapi.repository.AreaCriticaRepository;

@Service
public class AreaCriticaService {
    
    @Autowired
    private AreaCriticaRepository areaCriticaRepository;

    public Object obtenerAreaCriticaPorId(Long id) {

        AreaCriticaEntity areaCriticaEntity = areaCriticaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Area crítica no encontrada"));

        return convertirDTO(areaCriticaEntity);

    }

    public List<AreaCriticaDTO> obtenerTodasAreasCriticas() {

        List<AreaCriticaEntity> areaCriticaEntities= areaCriticaRepository.findAll();

        List<AreaCriticaDTO> areaCriticaDTOs= areaCriticaEntities.stream().map(this::convertirDTO).collect(Collectors.toList());
        
        return areaCriticaDTOs;
    }

    private AreaCriticaDTO convertirDTO(AreaCriticaEntity areaCriticaEntity) {
        AreaCriticaDTO areaCriticaDTO = new AreaCriticaDTO();
        areaCriticaDTO.setId(areaCriticaEntity.getId());
        areaCriticaDTO.setNombre(areaCriticaEntity.getNombre());
        areaCriticaDTO.setDescripcion(areaCriticaEntity.getDescripcion());
        areaCriticaDTO.setLatitud(areaCriticaEntity.getLatitud());
        areaCriticaDTO.setLongitud(areaCriticaEntity.getLongitud());
        areaCriticaDTO.setIndiceDeforestacion(areaCriticaEntity.getIndiceDeforestacion());

        return areaCriticaDTO;
    }

    private AreaCriticaEntity convertirEntity(AreaCriticaDTO areaCriticaDTO) {
        AreaCriticaEntity areaCriticaEntity = new AreaCriticaEntity();
        areaCriticaEntity.setNombre(areaCriticaDTO.getNombre());
        areaCriticaEntity.setDescripcion(areaCriticaDTO.getDescripcion());
        areaCriticaEntity.setLatitud(areaCriticaDTO.getLatitud());
        areaCriticaEntity.setLongitud(areaCriticaDTO.getLongitud());
        areaCriticaEntity.setIndiceDeforestacion(areaCriticaDTO.getIndiceDeforestacion());

        return areaCriticaEntity;
    }


    public AreaCriticaDTO crearAreaCritica(AreaCriticaDTO areaCriticaDTO) {
        AreaCriticaEntity areaCriticaEntity= convertirEntity(areaCriticaDTO);
        AreaCriticaEntity areaCriticaEntityCreada= areaCriticaRepository.save(areaCriticaEntity);
        return convertirDTO(areaCriticaEntityCreada);
    }

    public AreaCriticaDTO actualizarAreaCriticaPorId(Long id, AreaCriticaDTO areaCriticaDTO) {
        AreaCriticaEntity areaCriticaEntity = areaCriticaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Area Crítica no encontrada"));
        areaCriticaEntity.setNombre(areaCriticaDTO.getNombre());
        areaCriticaEntity.setDescripcion(areaCriticaDTO.getDescripcion());
        areaCriticaEntity.setLatitud(areaCriticaDTO.getLatitud());
        areaCriticaEntity.setLongitud(areaCriticaDTO.getLongitud());
        areaCriticaEntity.setIndiceDeforestacion(areaCriticaDTO.getIndiceDeforestacion());

        AreaCriticaEntity areaCriticaEntityActualizada = areaCriticaRepository.save(areaCriticaEntity);
        return convertirDTO(areaCriticaEntityActualizada);
    }

    public void eliminarAreaCriticaPorId(Long id){
        AreaCriticaEntity areaCriticaEntity= areaCriticaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Area Crítica no encontrada"));
        areaCriticaRepository.delete(areaCriticaEntity);
    }


}
