package com.vedruna.ejemplo.controllers;

import com.vedruna.ejemplo.exceptions.ResourceNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vedruna.ejemplo.persistance.models.Product;
import com.vedruna.ejemplo.services.ProductServiceI;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/products")

public class ProductController {

    @Autowired
    private ProductServiceI productMngmnt;

    @GetMapping
    public List<Product> getAllProducts() {
        return productMngmnt.showAllProducts();
    }

    @GetMapping("/name/{productName}")
    public Product showProductByProductName(@PathVariable String productName) {
        return productMngmnt.showProductByProductName(productName);
    }

    @GetMapping("/price/{productPrice}")
    public List<Product> showProductByProductPrice(@PathVariable Float productPrice) {
        return productMngmnt.showProductByProductPrice(productPrice);
    }

    @PostMapping("/insert")
    public String postProduct(@RequestBody Product product) {
        productMngmnt.saveProduct(product);
        return "Product Inserted";
    }

    @PutMapping("/edit/{productId}")
    public String editProduct(@PathVariable Long productId, @RequestBody Product product) {
        try {
        productMngmnt.updateProduct(productId, product);
        return "Product modified";
        } catch (ResourceNotFoundException e) {
        return e.getMessage();
        }
        
    }



    @DeleteMapping("/delete/{productId}")    
    public String deleteProduct(@PathVariable Long productId) {
        productMngmnt.deleteProduct(productId);
        return "Product deleted";
    }
}

