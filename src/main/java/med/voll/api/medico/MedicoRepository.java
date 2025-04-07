package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // JpaRepository já possui métodos prontos para operações CRUD
    // Não é necessário implementar nada aqui, a menos que você queira adicionar métodos personalizados.
    
}