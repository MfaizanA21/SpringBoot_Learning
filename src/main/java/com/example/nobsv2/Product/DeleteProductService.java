package com.example.nobsv2.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteProductService implements Command<Void, String>{
    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product deleted");
    }
}
