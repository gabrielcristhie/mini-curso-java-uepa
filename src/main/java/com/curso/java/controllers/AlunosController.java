package com.curso.java.controllers;

import com.curso.java.DTO.AlunoDTO;
import com.curso.java.services.AlunosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    private final AlunosService alunosService;

    @PostMapping("/create")
    public AlunoDTO createAluno(@RequestBody AlunoDTO aluno) {
        return alunosService.create(aluno);
    }

    @GetMapping("/read")
    public Page<AlunoDTO> getAllAlunos(@PageableDefault(value = 2, page = 0) Pageable pageable) {
        return alunosService.findAll(pageable);
    }

    @PutMapping("/update/{id}")
    public AlunoDTO updateAluno(@PathVariable Long id, @RequestBody AlunoDTO aluno) {
        return alunosService.update(id, aluno);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAluno(@PathVariable Long id) {
    	alunosService.delete(id);
    }
}