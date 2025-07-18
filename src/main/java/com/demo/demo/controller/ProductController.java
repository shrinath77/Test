package com.demo.demo.controller;

import com.demo.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List <Product> products = new ArrayList<>();

    public ProductController()
    {
        products.add(new Product(1,"Laptop",3000));
        products.add(new Product(2,"Pc",5000));

    }

    @GetMapping
    public List<Product>getAllProducts()
    {
        return products;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return products.stream()
                .filter(product -> product.getId()==id)
                .findFirst()
                .orElse(null);
    }

}