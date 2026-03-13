package org.example.funcionarios.controllers;

import org.example.funcionarios.models.Funcionario;
import org.example.funcionarios.repository.FuncionarioRepository;
import org.example.funcionarios.dto.FuncionarioRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    @PostMapping("/salvar")
    public Funcionario criar(@RequestBody FuncionarioRequestDTO dto) {
        Funcionario funcionario = Funcionario.builder()
                .nome(dto.getNome())
                .cargo(dto.getCargo())
                .salario(dto.getSalario())
                .email(dto.getEmail())
                .build();

        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/atualizar/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody FuncionarioRequestDTO dto) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Funcionario não encontrado com o id: " + id));
        funcionarioExistente.setNome(dto.getNome());
        funcionarioExistente.setCargo(dto.getCargo());
        funcionarioExistente.setSalario(dto.getSalario());
        funcionarioExistente.setEmail(dto.getEmail());

        return funcionarioRepository.save(funcionarioExistente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Não é possível deletar: ID não encontrado.");
        }

        funcionarioRepository.deleteById(id);
    }
}
