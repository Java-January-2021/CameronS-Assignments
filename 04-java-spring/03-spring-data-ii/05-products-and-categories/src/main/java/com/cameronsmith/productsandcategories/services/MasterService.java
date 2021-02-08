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
	public List<Product> getCategoryProducts(){
		return this.getCategoryProducts();
	}
//	Add Product to Category
	public void addProductToCategory(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		this.cRepo.save(category);
	}
	public void removeProductFromCategory(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.remove(product);
		this.cRepo.save(category);
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
	
	public List<Category> getProductCategories(){
		return this.getProductCategories();
	}
	public List<Product> getAllProduct(){
		return this.pRepo.findAll();
	}
//	Add Category to Product
	public void addCategoryToProduct(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.pRepo.save(product);
	}
	public void removeCategoryFromProduct(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.remove(category);
		this.pRepo.save(product);
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
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	public List<Product> findProductsNotInCategory(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
}
