package com.products.apirest.resources;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.products.apirest.repository.ProductRepository;
import com.products.apirest.models.Product;


@RestController
@RequestMapping(value="/api")
@Api(value="Products REST API")
@CrossOrigin(origins="*")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value="Return a product list")
    public List<Product> productsList(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value="Return a single product")
    public Product singleProduct(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    @ApiOperation(value="Save a product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    @ApiOperation(value="Delete a product")
    public void deleteProduct(@RequestBody Product product){
        productRepository.delete(product);
    }

    @PutMapping("/product")
    @ApiOperation(value="Update a product")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }


}
