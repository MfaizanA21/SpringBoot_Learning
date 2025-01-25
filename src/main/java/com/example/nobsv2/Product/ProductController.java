package com.example.nobsv2.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    private final CreateProductService createProductService;

    public ProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(){
        return createProductService.execute(null);
    }

    @GetMapping
    public ResponseEntity<String> getProduct(){

        return ResponseEntity.status(HttpStatus.OK).body( "Product retrieved");
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(){

        return ResponseEntity.status(HttpStatus.OK).body("Product updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProduct(){

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product deleted");
    }
}
