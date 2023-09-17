package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaCalabaza extends Pizza {
    public PizzaCalabaza(String name, double price, Topping... toppings) {
        super(name, toppings);
        aggTop();

    }
    public void aggTop(){
        addTopping(new Topping("Calabaza", 6));
        addTopping(new Topping("Jamon", 9));

    }
}
