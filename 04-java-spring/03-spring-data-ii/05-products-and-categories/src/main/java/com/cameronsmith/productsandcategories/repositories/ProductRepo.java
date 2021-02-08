package com.cameronsmith.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.productsandcategories.models.Category;
import com.cameronsmith.productsandcategories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
