package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional // Transacional é uma anotação do Spring que indica que o método deve ser
                   // executado dentro de uma transação. Isso significa que, se ocorrer um erro
                   // durante a execução do método, todas as alterações feitas no banco de dados
                   // serão revertidas.
    // Isso é importante para garantir a integridade dos dados no banco de dados.
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

}
