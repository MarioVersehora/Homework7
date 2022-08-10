package com.example.Homework7.controller;

import com.example.Homework7.dto.ProductDTO;
import com.example.Homework7.model.Product;
import com.example.Homework7.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("all")
    public List<ProductDTO> getAllProductsAndDeletedOnes() {
        return productService.getAllProductsAndDeletedOnes();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("{id}/{stock}")
    public Product updateStock(@PathVariable Integer id, @PathVariable Integer stock) {
        return productService.updateStock(id, stock);
    }

    @PostMapping("increment/{id}")
    public Product incrementStock(@PathVariable Integer id) {
        return productService.incrementStock(id);
    }

    @PostMapping("decrement/{id}")
    public Product decrementStock(@PathVariable Integer id) {
        return productService.decrementStock(id);
    }

}
