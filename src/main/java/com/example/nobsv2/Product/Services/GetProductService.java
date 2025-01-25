package com.example.nobsv2.Product.Services;

import com.example.nobsv2.Product.Model.Product;
import com.example.nobsv2.Product.Model.ProductDTO;
import com.example.nobsv2.Product.ProductRepository;
import com.example.nobsv2.Product.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);

        return productOptional.map(product -> ResponseEntity.ok(new ProductDTO(product))).orElse(null);
    }
}
