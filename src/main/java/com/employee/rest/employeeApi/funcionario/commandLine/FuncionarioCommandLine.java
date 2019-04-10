package com.employee.rest.employeeApi.funcionario.commandLine;

import com.employee.rest.employeeApi.funcionario.Funcionario;
import com.employee.rest.employeeApi.funcionario.Projeto;
import com.employee.rest.employeeApi.funcionario.repository.FuncionarioRepository;
import com.employee.rest.employeeApi.funcionario.repository.ProjetoRepository;
import com.employee.rest.employeeApi.restaurant.entity.Customer;
import com.employee.rest.employeeApi.restaurant.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class FuncionarioCommandLine implements CommandLineRunner {
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    ProjetoRepository projetoRepository;
    @Override
    public void run(String... args) throws Exception {
        Projeto projeto = new Projeto("Pegasus");
        Funcionario funcionario = new Funcionario("Conrad");
        funcionario.setProjetos(Arrays.asList(projeto));
        projeto.setDesenvolvedores(Arrays.asList(funcionario));
        funcionarioRepository.save(funcionario);
        projetoRepository.save(projeto);

    }
}
