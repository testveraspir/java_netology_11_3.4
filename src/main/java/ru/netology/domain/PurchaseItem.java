package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PurchaseItem {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int count;
}
