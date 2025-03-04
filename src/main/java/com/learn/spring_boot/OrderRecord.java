package com.learn.spring_boot;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
