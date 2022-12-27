package com.shopping.cart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.app.exception.ProductNotFoundException;
import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {	

	@Autowired
	private ProductService productService;

	//Create Product
	@PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }
	
	//Get All Product
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.findAll();
	}
	
	//Get All Product By Product Name And BuyPrice
	@GetMapping("/{productName}/{buyPrice}")
	public List<Product> getAllProductByProductNameAndBuyPrice(@PathVariable String productName,@PathVariable double buyPrice){
		return productService.findAllByProductNameAndBuyPrice(productName, buyPrice);
	}
	
	//find products by ByPrice decending order
	@GetMapping("/buyprice")
	public List<Product> findProductOrderByBuyPrice(){	
		return productService.findAllOrderByBuyPrice();
	}
	
	@GetMapping("/priceless/{price}")
	public List<Product> findByPriceLessThan(@PathVariable double price){	
		return productService.findByPriceLessThan(price);
	}
	
	@GetMapping("/pricegreater/{price}")
	public List<Product> findByPriceGreaterThan(@PathVariable double price){	
		return productService.findByPriceGreaterThan(price);
	}
	
	@GetMapping("/namestartwith/{prefix}")
	public List<Product> findByNameStartingWith(@PathVariable String prefix){	
		return productService.findByNameStartingWith(prefix);
	}
	
	@GetMapping("/namelike/{name}")
	public List<Product> findByNameLike(@PathVariable String name){	
		return productService.findByNameLike(name);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable  long id) throws ProductNotFoundException {
		Product product = productService.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not exist with id: " + id));
        return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product) throws ProductNotFoundException {
		Product updateProduct = productService.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not exist with id: " + id));
		
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductScale(product.getProductScale());
		updateProduct.setProductVendor(product.getProductVendor());
		updateProduct.setProductDescription(product.getProductDescription());
		updateProduct.setQuantityInStock(product.getQuantityInStock());
		updateProduct.setBuyPrice(product.getBuyPrice());
		updateProduct.setMSRP(product.getMSRP());        

        productService.create(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
		
		productService.findById(id)
		.orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + id));
		
		productService.deleteProduct(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
