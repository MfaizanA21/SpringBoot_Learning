package com.example.nobsv2.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetProductService implements Query<Void, String>{

    @Override
    public ResponseEntity<String> execute(Void input) {

        return ResponseEntity.ok("Product with id " + input);
    }
}
