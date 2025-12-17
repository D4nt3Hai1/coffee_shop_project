/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeeshop.model;

public abstract class MenuItem implements Payable {

    protected String name;
    protected double basePrice;

    // ORIGINAL CONSTRUCTOR
    public MenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    // OVERLOADED CONSTRUCTOR 
    public MenuItem(String name) {
        this.name = name;
        this.basePrice = 0;
    }

    public String getName() {
        return name;
    }
}
