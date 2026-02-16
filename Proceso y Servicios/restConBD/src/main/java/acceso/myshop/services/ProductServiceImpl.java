package acceso.myshop.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Product;
import acceso.myshop.repositories.ProductRepository;
import exceptions.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Set<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateNameProduct(Long id, Product product) {
		Product pOriginal = this.findProductById(id);
		if (pOriginal != null) {
			pOriginal.setName(product.getName());
		} else {
			new ProductNotFoundException(id);
		}
		return productRepository.save(pOriginal);
	}

	public void deleteProduct(Long id) {
		Product pOriginal = this.findProductById(id);

		productRepository.delete(pOriginal);
	}

	// Método para encontrar un producto por ID
	public Product findProductById(long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.orElseThrow(() -> new ProductNotFoundException(id));
	}

}
