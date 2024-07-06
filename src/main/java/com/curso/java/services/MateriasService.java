package com.curso.java.services;


import com.curso.java.DTO.MateriaDTO;
import com.curso.java.entities.Materia;
import com.curso.java.repository.MateriasRepository;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MateriasService {

    private final MateriasRepository materiasRepository;

    private final ModelMapper modelMapper;

    public MateriasService(MateriasRepository materiasRepository, ModelMapper modelMapper) {
        this.materiasRepository = materiasRepository;
        this.modelMapper = modelMapper;
    }

    public List<MateriaDTO> findAll() {
        List<Materia> all = materiasRepository.findAll();
        return all.stream().map((materia) -> modelMapper.map(materia, MateriaDTO.class))
                .collect(Collectors.toList());
    }

    public MateriaDTO create(MateriaDTO materia) {
        Materia createdMateria = materiasRepository.save(
                modelMapper.map(materia, Materia.class));
        return modelMapper.map(createdMateria, MateriaDTO.class);
    }

    public MateriaDTO update(Long id, MateriaDTO materiaDetails) {
        Materia materia = materiasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com esse id: " + id));
        materia.setNome(materiaDetails.getNome());
        materia.setDescricao(materiaDetails.getDescricao());
        
        Materia updatedMateria = materiasRepository.save(materia);
        
        return modelMapper.map(updatedMateria, MateriaDTO.class);
    }

    public void delete(Long id) {
        materiasRepository.delete(materiasRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Matéria não encontrada com esse id: " + id)));
    }
}