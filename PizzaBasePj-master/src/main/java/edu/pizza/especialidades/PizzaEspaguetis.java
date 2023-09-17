package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaEspaguetis extends Pizza {
    public PizzaEspaguetis(String name, double price, Topping... toppings) {
        super(name, toppings);
        aggTop();

    }
    public void aggTop(){
        addTopping(new Topping("Calabacin", 6));
        addTopping(new Topping("Jamon Serrano", 10));
        addTopping(new Topping("Espaguetis", 12));

    }
}
