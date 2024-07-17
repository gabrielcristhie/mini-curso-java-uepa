package com.curso.java.services;

import com.curso.java.DTO.AlunoDTO;
import com.curso.java.entities.Alunos;
import com.curso.java.repository.AlunosRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunosService {

	private final AlunosRepository alunosRepository;

	private final ModelMapper modelMapper;

	public AlunosService(AlunosRepository alunosRepository, ModelMapper modelMapper) {
		this.alunosRepository = alunosRepository;
		this.modelMapper = modelMapper;
	}

	public List<AlunoDTO> findAll() {
		List<Alunos> aluno = alunosRepository.findAll();
		return aluno.stream().map((alunos)
				-> modelMapper.map(alunos, AlunoDTO.class))
				.collect(Collectors.toList());
	}

	public Page<AlunoDTO> findAll(@PageableDefault(value = 2, page = 0) Pageable pageable) {
		Page<Alunos> alunoPage = alunosRepository.findAll(pageable);
		return alunoPage.map(alunos -> modelMapper.map(alunos, AlunoDTO.class));
	}

	public AlunoDTO create(AlunoDTO aluno) {
		Alunos createdAluno = alunosRepository.save(
			modelMapper.map(aluno, Alunos.class));
		return modelMapper.map(createdAluno, AlunoDTO.class);
	}

	public AlunoDTO update(Long id, AlunoDTO aluno) {
		Alunos alunos = alunosRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id:" + id));
		alunos.setNome(aluno.getNome());
		alunos.setMatricula(aluno.getMatricula());
		alunos.setEndereco(aluno.getEndereco());
		alunos.setMateria(aluno.getMateria());

		Alunos updatedAluno = alunosRepository.save(alunos);

		return modelMapper.map(updatedAluno, AlunoDTO.class);
	}

	public void delete(Long id) {
		alunosRepository.delete(alunosRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado com o id:" + id)));
	}
}
