package com.curso.java.controllers;

import com.curso.java.DTO.MateriaDTO;
import com.curso.java.services.MateriasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    public MateriasController(MateriasService materiasService){
        this.materiasService = materiasService;
    }

    private final MateriasService materiasService;

    @PostMapping("create")
    public MateriaDTO createMateria(@RequestBody MateriaDTO materia) {
        return materiasService.create(materia);
    }

    @GetMapping("/read")
    public List<MateriaDTO> getAllMaterias() {
        return materiasService.findAll();
    }

    @PutMapping("/update/{id}")
    public MateriaDTO updateMateria(@PathVariable Long id, @RequestBody MateriaDTO materiaDetails) {
        return materiasService.update(id, materiaDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMateria(@PathVariable Long id) {
        materiasService.delete(id);
    }
}