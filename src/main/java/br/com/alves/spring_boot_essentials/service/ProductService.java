package br.com.alves.spring_boot_essentials.service;

import br.com.alves.spring_boot_essentials.database.model.ProductEntity;
import br.com.alves.spring_boot_essentials.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final List<ProductEntity> PRODUCT = new ArrayList<>();
    static {
        PRODUCT.add(ProductEntity.builder()
                .id(1)
                .name("Notebook")
                .price(new BigDecimal(5000))
                .amount(14)
                .build());
        PRODUCT.add(ProductEntity.builder()
                .id(2)
                .name("Mouse")
                .price(new BigDecimal(80))
                .amount(50)
                .build());
        PRODUCT.add(ProductEntity.builder()
                .id(3)
                .name("iPhone")
                .price(new BigDecimal(8500))
                .amount(34)
                .build());
    }

    public List<ProductEntity> findAll() {
        return new ArrayList<>(PRODUCT);
    }

    Integer integer = PRODUCT.stream()
            .mapToInt(ProductEntity::getId)
            .max()
            .orElse(0) + 1;

    public ProductEntity createProduct (ProductDto productDto){
        ProductEntity newProduct = ProductEntity.builder()
                .id(integer)
                .name(productDto.getName())
                .price(productDto.getPrice())
                .amount(productDto.getAmount())
                .build();
        PRODUCT.add(newProduct);
        return newProduct;
    }
    public ProductEntity updateProduct (ProductDto productDto, Integer id){
        ProductEntity product = PRODUCT.stream()
                .filter(p -> p.getId().equals(id) )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setAmount(productDto.getAmount());
        return product;
    };

}


