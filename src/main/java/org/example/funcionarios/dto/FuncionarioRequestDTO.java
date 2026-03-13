package org.example.funcionarios.dto;

import lombok.Value;

@Value
public class FuncionarioRequestDTO {
    String nome;
    String cargo;
    Double salario;
    String email;
}
