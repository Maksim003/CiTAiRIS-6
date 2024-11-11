package com.company.Products;

import com.company.Interfaces.Product;

public class Food implements Product {

    @Override
    public void getProduct() {
        System.out.println("----------------Блюдо----------------");
    }

}
