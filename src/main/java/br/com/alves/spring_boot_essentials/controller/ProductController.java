package br.com.alves.spring_boot_essentials.controller;

import br.com.alves.spring_boot_essentials.database.model.ProductEntity;
import br.com.alves.spring_boot_essentials.dto.ProductDto;
import br.com.alves.spring_boot_essentials.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity updateProduct(@RequestBody ProductDto productDto, @PathVariable Integer id) {
        return productService.updateProduct(productDto, id);
    }
}