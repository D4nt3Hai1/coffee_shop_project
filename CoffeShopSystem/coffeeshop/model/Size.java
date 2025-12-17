/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeeshop.model;

/**
 * ENUM: Defines the available coffee sizes.
 * Each size has an additional cost.
 */
public enum Size {

    SMALL(0),
    MEDIUM(20),
    LARGE(40);

    // ENCAPSULATION
    private final int extraCost;

    // ENUM CONSTRUCTOR
    Size(int extraCost) {
        this.extraCost = extraCost;
    }

    // GETTER METHOD
    public int getExtraCost() {
        return extraCost;
    }
}