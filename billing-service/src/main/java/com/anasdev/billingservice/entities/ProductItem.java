package com.anasdev.billingservice.entities;

import com.anasdev.billingservice.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//maghayserializich bill l format djson ay ignoriha
    private Bill bill;
    private int quantity;
    private double unitPrice;
    @Transient private Product product;
}
