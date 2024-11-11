package com.company.Products;

import com.company.Interfaces.Product;

public class Drink implements Product {
    @Override
    public void getProduct() {
        System.out.println("----------------Напиток----------------");
    }
}