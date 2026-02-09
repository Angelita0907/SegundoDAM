package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Product;
// con esto tenemos las operaciones del crud
@Repository
public interface IProductRepositorio extends JpaRepository<Product, Long>{
	
	

}
