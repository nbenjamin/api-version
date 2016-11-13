package com.nbenja.springboot.api;

import com.nbenja.springboot.domain.Product;
import com.nbenja.springboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/home")
public class ProductInventoryController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/products", produces = {"application/vnd.nbenja-v1.0+json"})
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/products", produces = {"application/vnd.nbenja-v1.1+json"})
    public List<Product> getDiscountedProducts() {
        return  productRepository.findAll().stream().map(p -> {p.setPrice(p.getPrice() -100);
            return  p;}).collect(Collectors.toList());
    }
}
