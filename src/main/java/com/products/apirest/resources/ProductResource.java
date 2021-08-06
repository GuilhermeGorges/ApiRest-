package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.products.apirest.repository.ProductRepository;
import com.products.apirest.models.Product;


@RestController
@RequestMapping(value="/api")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> productsList(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product singleProduct(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
