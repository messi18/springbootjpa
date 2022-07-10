package com.lance.springbootjpa.api;

import com.lance.springbootjpa.data.entity.Product;
import com.lance.springbootjpa.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> list() {
        return productRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String  delete(@PathVariable Long id) {
        return productRepository.removeById(id);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return productRepository.getById(id);
    }
}
