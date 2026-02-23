package LitMindSpring.LitMindSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LitMindSpring.LitMindSpring.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
 {
	Usuario findByNombre(String username);
     boolean existsByNombre(String username);
}
