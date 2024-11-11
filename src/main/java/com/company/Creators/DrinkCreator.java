package com.company.Creators;

import com.company.Interfaces.Product;
import com.company.Products.Drink;

public class DrinkCreator extends ProductCreator{

    @Override
    public Product createProduct() {
        return new Drink();
    }
}
