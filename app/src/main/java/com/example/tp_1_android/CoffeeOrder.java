package com.example.tp_1_android;

public class CoffeeOrder {
    // Attributs
    private int numberOfCoffees; // Nombre de cafés
    private double pricePerCoffee; // Prix d'un café

    // Constucteur
    public CoffeeOrder(int numberOfCoffees, double pricePerCoffee) {
        this.numberOfCoffees = numberOfCoffees;
        this.pricePerCoffee = pricePerCoffee;
    }

    //Méthodes
    public void addCoffee() {
        numberOfCoffees++;
    }

    public void removeCoffee() {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
        }
    }

    public int getQuantity() {
        return numberOfCoffees;
    }

    public double getPrice() {
        return pricePerCoffee;
    }

    public double CalculateOrderPrice() {
        return numberOfCoffees * pricePerCoffee;
    }



}
