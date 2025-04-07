package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired // Injeção de dependência do repositório de médicos. O Spring irá instanciar o repositório e injetar aqui
    private MedicoRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        //System.out.println("Cadastrando médico... "+dados);
        repository.save(new Medico(dados)); // Salva o médico no banco de dados

    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream().map(DadosListagemMedico::new).toList(); // Retorna todos os médicos cadastrados no banco de dados
    }

}