package service;

import org.springframework.beans.factory.annotation.Autowired;

import repositorio.ProductRepository;

public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	
	
}
