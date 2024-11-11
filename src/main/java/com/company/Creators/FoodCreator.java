package com.company.Creators;

import com.company.Interfaces.Product;
import com.company.Products.Food;

public class FoodCreator extends ProductCreator {

    @Override
    public Product createProduct() {
        return new Food();
    }
}
