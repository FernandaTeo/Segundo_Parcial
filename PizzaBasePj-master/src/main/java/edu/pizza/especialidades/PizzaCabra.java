package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaCabra extends Pizza {
    public PizzaCabra(String name, double price, Topping... toppings) {
        super(name, toppings);
        aggTop();

    }
    public void aggTop(){
        addTopping(new Topping("Queso Cabra", 20));
        addTopping(new Topping("Foi gras", 10));
        addTopping(new Topping("Miel", 15));

    }
}
