package com.employee.rest.employeeApi.funcionario.repository;

import com.employee.rest.employeeApi.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
