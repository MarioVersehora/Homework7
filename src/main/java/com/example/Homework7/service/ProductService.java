package com.example.Homework7.service;

import com.example.Homework7.dto.ProductDTO;
import com.example.Homework7.mapper.ProductMapper;
import com.example.Homework7.model.Product;
import com.example.Homework7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private List<Product> totalProducts = new ArrayList<>();

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAllProductsAndDeletedOnes() {
        return totalProducts.stream().
                map(productMapper::toProductDTO).
                collect(Collectors.toList());
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product saveProduct(Product product) {
        totalProducts.add(product);
        return productRepository.save(product);
    }

    public Product updateStock(Integer id, Integer newStock) {
        Product product = productRepository.findById(id).get();
        product.setStock(newStock);
        return productRepository.save(product);
    }

    public Product incrementStock(Integer id) {
        Product product = productRepository.findById(id).get();
        product.setStock(product.getStock() + 1);
        return productRepository.save(product);
    }

    public Product decrementStock(Integer id) {
        Product product = productRepository.findById(id).get();
        product.setStock(product.getStock() - 1);
        return productRepository.save(product);
    }
}
