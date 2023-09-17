package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaBlanca extends Pizza {
    public PizzaBlanca(String name, double price, Topping... toppings) {
        super(name, toppings);
        aggTop();

    }
    public void aggTop(){
        addTopping(new Topping("Cebolla", 6));
        addTopping(new Topping("Jamón", 9));
        addTopping(new Topping("Parmesano", 15));

    }
}
