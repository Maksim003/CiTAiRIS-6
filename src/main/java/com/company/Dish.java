package com.company;


import com.company.Interfaces.Product;

public class Dish {
    private String name;
    private String price;
    private String description;
    private String calories;
    private Product product;

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Название: " + name + '\n' +
                "Цена: " + price + '\n' +
                "Описание: " + description + '\n' +
                "Калории: " + calories;
    }
}
