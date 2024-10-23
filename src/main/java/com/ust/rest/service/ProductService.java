package com.ust.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product newProduct)
	{
		return repository.save(newProduct);
	}
	
	public Optional<Product> getProductById(Long id)
	{
		return repository.findById(id);
	}

	public Product deleteById(Long id)
	{
		 repository.deleteById(id);
		 return null;
	}
	public Product updateProduct(Product newProduct)
	{
		if (repository.existsById(newProduct.getId())) 
		{
			return repository.save(newProduct);
		}
		return null;
	}
	public List<Product> getProductBrands(String brand)
	{
		return repository.findByBrand(brand);
	}
	public List<Product> getProductsInfo()
	{
		return repository.findAll();
	}
}
