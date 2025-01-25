package com.example.nobsv2.Product.Services;

import com.example.nobsv2.Product.Model.Product;
import com.example.nobsv2.Product.Model.ProductDTO;
import com.example.nobsv2.Product.Model.UpdateProductCommand;
import com.example.nobsv2.Product.ProductRepository;
import com.example.nobsv2.Product.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Query<UpdateProductCommand, ProductDTO> {

    private ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());

        if(productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }

        return null;
    }
    
}
