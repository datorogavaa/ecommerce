package com.ecommerce.restControllers;


import com.ecommerce.dto.ProductDto;
import com.ecommerce.entities.Product;
import com.ecommerce.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class ProductRestController {
    ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        return ResponseEntity.ok("Product updated successfully");
    }

    @PatchMapping("/updateProductField/{id}")
    public ResponseEntity<String> updateProductField(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        productService.updateProductField(id, updates);
        return ResponseEntity.ok("Product field updated successfully");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(204).body("Product deleted successfully");
    }
}
