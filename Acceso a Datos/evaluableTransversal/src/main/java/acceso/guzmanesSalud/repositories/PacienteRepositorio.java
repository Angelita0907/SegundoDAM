package acceso.guzmanesSalud.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.guzmanesSalud.models.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long>{
	
	List<Paciente> findAll();
	Paciente findByIdPaciente(long idPaciente);

}
