package br.com.alves.spring_boot_essentials.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Integer amount;

}
