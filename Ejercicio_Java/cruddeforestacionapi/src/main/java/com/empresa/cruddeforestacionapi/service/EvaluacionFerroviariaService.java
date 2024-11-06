package com.empresa.cruddeforestacionapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cruddeforestacionapi.dto.EvaluacionFerroviariaDTO;
import com.empresa.cruddeforestacionapi.entity.EvaluacionFerroviariaEntity;
import com.empresa.cruddeforestacionapi.exceptions.RecursoNoEncontradoExcepcion;
import com.empresa.cruddeforestacionapi.repository.AreaCriticaRepository;
import com.empresa.cruddeforestacionapi.repository.EvaluacionFerroviariaRepository;
import com.empresa.cruddeforestacionapi.utils.EvaluacionFerroviaraMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class EvaluacionFerroviariaService {

    @Autowired
    private EvaluacionFerroviariaRepository evaluacionFerroviariaRepository;

    @Autowired
    private AreaCriticaRepository areaCriticaRepository;

    @Autowired
    private EntityManager entityManager;

    private final EvaluacionFerroviaraMapper mapper = EvaluacionFerroviaraMapper.INSTANCE;

    @Autowired
    public List<EvaluacionFerroviariaDTO> obtenerTodasEvaluacionFerroviarias() {
        List<EvaluacionFerroviariaEntity> evaluacionFerroviariaEntities = evaluacionFerroviariaRepository.findAll();
        return evaluacionFerroviariaEntities.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public EvaluacionFerroviariaDTO obtenerEvaluacionFerroviariaPorId(Long id) {
        EvaluacionFerroviariaEntity evaluacionFerroviariaEntity = evaluacionFerroviariaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Evaluación ferroviaria no encontrada"));
        return mapper.toDto(evaluacionFerroviariaEntity);
    }

    public EvaluacionFerroviariaDTO crearEvaluacionFerroviaria(EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
        if (!areaCriticaRepository.existsById(evaluacionFerroviariaDTO.getAreaCriticaEntityId())) {
            throw new RecursoNoEncontradoExcepcion("Area critica no encontrada");
        }

        EvaluacionFerroviariaEntity evaluacionFerroviariaEntity = mapper.toEntity(evaluacionFerroviariaDTO);
        EvaluacionFerroviariaEntity evaluacionFerroviariaEntityCreada = evaluacionFerroviariaRepository.save(evaluacionFerroviariaEntity);

        return mapper.toDto(evaluacionFerroviariaEntityCreada);
    }

    public EvaluacionFerroviariaDTO actualizarEvaluacionFerroviariaPorId(Long id, EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
        EvaluacionFerroviariaEntity evaluacionFerroviariaEntity = evaluacionFerroviariaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Evaluación ferroviaria no encontrada"));
        evaluacionFerroviariaEntity.setNombreRuta(evaluacionFerroviariaDTO.getNombreRuta());
        evaluacionFerroviariaEntity.setInformeViabilidad(evaluacionFerroviariaDTO.getInformeViabilidad());
        evaluacionFerroviariaEntity.setFechaEvaluacion(evaluacionFerroviariaDTO.getFechaEvaluacion());

        EvaluacionFerroviariaEntity evaluacionFerroviariaEntityActualizada = evaluacionFerroviariaRepository.save(evaluacionFerroviariaEntity);

        return mapper.toDto(evaluacionFerroviariaEntityActualizada);
    }

    public void eliminarEvaluacionFerroviariaPorId(Long id) {
        EvaluacionFerroviariaEntity evaluacionFerroviariaEntity = evaluacionFerroviariaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoExcepcion("Evaluación ferroviaria no encontrada"));
        evaluacionFerroviariaRepository.delete(evaluacionFerroviariaEntity);
    }

        public Long insertarEvaluacionFerroviaria(EvaluacionFerroviariaDTO evaluacionFerroviariaDTO) {
        if (!areaCriticaRepository.existsById(evaluacionFerroviariaDTO.getAreaCriticaEntityId())) {
            throw new RecursoNoEncontradoExcepcion("Area critica no encontrada");
        }

        StoredProcedureQuery query= entityManager.createStoredProcedureQuery("insertar_evaluacion");

        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, Long.class, ParameterMode.OUT);

        query.setParameter(1, evaluacionFerroviariaDTO.getNombreRuta());
        query.setParameter(2, evaluacionFerroviariaDTO.getInformeViabilidad());
        query.setParameter(3, evaluacionFerroviariaDTO.getAreaCriticaEntityId());
        
        query.execute();

        Long nuevoId= (Long) query.getOutputParameterValue(4);

        return nuevoId;
    }

}
