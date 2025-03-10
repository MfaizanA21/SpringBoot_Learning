package com.example.nobsv2.Product.Services;

import com.example.nobsv2.Product.Model.Product;
import com.example.nobsv2.Product.Model.ProductDTO;
import com.example.nobsv2.Product.ProductRepository;
import com.example.nobsv2.Product.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Query<Void, List<ProductDTO>> {

    private final ProductRepository productRepository;

    public GetProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
