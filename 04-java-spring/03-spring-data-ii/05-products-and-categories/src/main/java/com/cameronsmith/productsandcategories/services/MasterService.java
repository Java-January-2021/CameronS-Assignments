package com.cameronsmith.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.productsandcategories.models.Category;
import com.cameronsmith.productsandcategories.models.Product;
import com.cameronsmith.productsandcategories.repositories.CategoryRepo;
import com.cameronsmith.productsandcategories.repositories.ProductRepo;

@Service
public class MasterService {
	@Autowired
	private CategoryRepo cRepo;
	@Autowired
	private ProductRepo pRepo;
	public List<Category> getAllCategory(){
		return this.cRepo.findAll();
	}
	public Category createCategory(Category newEntry) {
		return this.cRepo.save(newEntry);
	}
	public Category createCategory(String name) {
		Category newEntry = new Category(name);
		return this.cRepo.save(newEntry);
	}
	public Category getCategoryById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public Category updateCategory(Category toUpdate) {
		return this.cRepo.save(toUpdate);
	}
	public void deleteCategoryById(Long id) {
		this.cRepo.deleteById(id);
	}
	public List<Product> getAllProduct(){
		return this.pRepo.findAll();
	}
	public Product createProduct(Product newEntry) {
		return this.pRepo.save(newEntry);
	}
	public Product createProduct(String name, String description, float price) {
		Product newEntry = new Product(name,description,price);
		return this.pRepo.save(newEntry);
	}
	public Product getProductById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Product updateProduct(Product toUpdate) {
		return this.pRepo.save(toUpdate);
	}
	public void deleteProductById(Long id) {
		this.pRepo.deleteById(id);
	}
}
