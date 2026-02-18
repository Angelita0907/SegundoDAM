package acceso.guzmanesSalud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.guzmanesSalud.models.ConstantesVitales;

@Repository
public interface ConstantesVitalesRepository extends JpaRepository <ConstantesVitales, Long>{

	// lo comento porque no me arranca si lo pongo asi y no entiendo
	//ConstantesVitales findConstantesById(long idConstantes);
	
}
