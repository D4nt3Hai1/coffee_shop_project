/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeeshop.model;

/**
 * INHERITANCE: Coffee "extends" MenuItem.
 * This means it gets all the name/price logic for free.
 */
public class Coffee extends MenuItem {

    private final Size size;

    public Coffee(String name, double basePrice, Size size) {
        super(name, basePrice);
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        return basePrice + size.getExtraCost();
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }
}
