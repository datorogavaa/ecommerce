package com.ecommerce.services;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entities.Product;
import com.ecommerce.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    Logger logger = Logger.getLogger(ProductService.class.getName());



    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        logger.info("New Product object created");
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setImageUrl(productDto.getImageUrl());
        product.setQuantity(productDto.getQuantity());
        logger.info("Product object populated with data from ProductDto");
        productRepository.save(product);
    }
    public Product getProductById(Long id) {
        logger.info("Fetching product with id: " + id);
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll();
    }

    public void updateProduct(Long id, ProductDto productDto) {
            logger.info("Updating product with id: " + id);
            Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setCategory(productDto.getCategory());
            product.setImageUrl(productDto.getImageUrl());
            product.setQuantity(productDto.getQuantity());
            logger.info("Product object updated with new data from ProductDto");
            productRepository.save(product);
    }

    public void updateProductField(Long id, Map<String, Object> updates) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        logger.info("Updating product fields with id: " + id);
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            switch (entry.getKey()) {
                case "name":
                    product.setName((String) entry.getValue());
                    break;
                case "description":
                    product.setDescription((String) entry.getValue());
                    break;
                case "price":
                    product.setPrice((Double) entry.getValue());
                    break;
                case "category":
                    product.setCategory((String) entry.getValue());
                    break;
                case "imageUrl":
                    product.setImageUrl((List<String>) entry.getValue());
                    break;
                case "quantity":
                    product.setQuantity((Long) entry.getValue());
                    break;
            }
        }
        logger.info("Product object updated with new field values from updates map");
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        logger.info("Deleting product with id: " + id);
        productRepository.deleteById(id);
    }

}
