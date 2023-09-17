package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmParcial {

    private JComboBox comboBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JButton btnAddEliminar;
    private JComboBox comboBoxPizzas;
    private JLabel lblTotal;
    private JLabel tamaño;
    private JRadioButton grandeRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton pequeñaRadioButton;
    private JButton prepararPizzaButton;
    private JPanel jPanelPrincipal;
    private JList lista1;

    private List<Topping> ingredientes = new ArrayList<>();
    private List<Pizza> pizzas = new ArrayList<>();

    private List<Topping>  pizzablanca = new ArrayList<>();
    private List<Topping>  pizzacabra = new ArrayList<>();
    private List<Topping>  pizzacalabaza = new ArrayList<>();
    private List<Topping>  pizzaespagueti = new ArrayList<>();
    private List<Topping>  pizzavegetariana = new ArrayList<>();

    private DefaultListModel modeloLista = new DefaultListModel();
    private double total = 0.0;

    private ButtonGroup sizeButtonGroup; // Grupo para los radio buttons

    public frmParcial() {
        cargarToppings();
        cargarPizzas();
        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
                modeloLista.addElement(ingrediente);
                lista1.setModel(modeloLista);
                total += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));

            }
        });
        btnAddEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lista1.getSelectedIndex() ==-1){
                    JOptionPane.showMessageDialog(null, "Seleccione un ingrediente");
                    return;
                }
                Topping ingrediente = (Topping) lista1.getSelectedValue();
                modeloLista.removeElement(ingrediente);
                lista1.setModel(modeloLista);
                total -= ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));

            }
        });

        // Crea el grupo de radio buttons
        sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(pequeñaRadioButton);
        sizeButtonGroup.add(medianaRadioButton);
        sizeButtonGroup.add(grandeRadioButton);

        // Agrega el evento para detectar el cambio de tamaño
        pequeñaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama a una función para actualizar el precio según el tamaño seleccionado
                updatePizzaPrice();
            }
        });

        medianaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePizzaPrice();
            }
        });

        grandeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePizzaPrice();
            }
        });

        prepararPizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtPizza.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre de la pizza");
                    return;
                }
                if (lista1.getModel().getSize() == 0){
                    JOptionPane.showMessageDialog(null, "Seleccione al menos un ingrediente");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Pizza preparada");

                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i < lista1.getModel().getSize(); i++) {
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();

            }
        });
        comboBoxPizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = (Pizza) comboBoxPizzas.getSelectedItem();
                txtPizza.setText(pizza.getName());
                modeloLista.removeAllElements();
                lista1.setModel(modeloLista);
                total = 0.0;
                lblTotal.setText(String.valueOf(total));
                if (pizza.getName().equals("Pizza Blanca")){
                    tppb();
                    for (int i = 0; i < pizzablanca.size(); i++) {
                        modeloLista.addElement(pizzablanca.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzablanca.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
                if (pizza.getName().equals("Pizza Cabra")){
                    tppqdc();
                    for (int i = 0; i < pizzacabra.size(); i++) {
                        modeloLista.addElement(pizzacabra.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzacabra.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
                if (pizza.getName().equals("Pizza Calabaza")){
                    tppc();
                    for (int i = 0; i < pizzacalabaza.size(); i++) {
                        modeloLista.addElement(pizzacalabaza.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzacalabaza.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
                if (pizza.getName().equals("Pizza Espagueti")){
                    tppe();
                    for (int i = 0; i < pizzaespagueti.size(); i++) {
                        modeloLista.addElement(pizzaespagueti.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzaespagueti.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
                if (pizza.getName().equals("Pizza Vegetariana")){
                    tppv();
                    for (int i = 0; i < pizzavegetariana.size(); i++) {
                        modeloLista.addElement(pizzavegetariana.get(i));
                        lista1.setModel(modeloLista);
                        total += pizzavegetariana.get(i).getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
            }
        });
    }

    public JPanel getjPanelPrincipal() {
        return jPanelPrincipal;
    }

    private void cargarToppings(){
        ingredientes.add(new Topping("Zanahoria", 1.0));
        ingredientes.add(new Topping("Pepino", 12));
        ingredientes.add(new Topping("Carne", 10));
        ingredientes.add(new Topping("Brocoli", 1.0));
        ingredientes.add(new Topping("Chile", 1.0));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);
    }

    private void cargarPizzas(){
        pizzas.add(new Pizza("Pizza Blanca"));
        pizzas.add(new Pizza("Pizza Cabra"));
        pizzas.add(new Pizza("Pizza Calabaza"));
        pizzas.add(new Pizza("Pizza Espagueti"));
        pizzas.add(new Pizza("Pizza Vegetariana"));
        pizzas.add(new Pizza("Yo la Armo"));

        DefaultComboBoxModel model = new DefaultComboBoxModel(pizzas.toArray());
        comboBoxPizzas.setModel(model);
    }

    private void tppb(){
        pizzablanca.add(new Topping("Cebolla", 10));
        pizzablanca.add(new Topping("Jamon", 10));
        pizzablanca.add(new Topping("Parmesano", 10));
    }

    private void tppc(){
        pizzacalabaza.add(new Topping("Calabaza", 10));
        pizzacalabaza.add(new Topping("Jamon", 10));
    }

    private void tppe(){
        pizzaespagueti.add(new Topping("Espaguetis", 10));
        pizzaespagueti.add(new Topping("Calabacin", 10));
        pizzaespagueti.add(new Topping("Jamon Serrano", 10));
    }

    private void tppqdc(){
        pizzacabra.add(new Topping("Queso de Cabra", 10));
        pizzacabra.add(new Topping("Foie Gras", 10));
        pizzacabra.add(new Topping("Miel", 10));
    }

    private void tppv(){
        pizzavegetariana.add(new Topping("Aguacates", 10));
        pizzavegetariana.add(new Topping("Nueces", 10));
    }

    private void updatePizzaPrice() {
        // Obtén el tamaño seleccionado
        String selectedSize = "";
        if (pequeñaRadioButton.isSelected()) {
            selectedSize = "Pequeña";
        } else if (medianaRadioButton.isSelected()) {
            selectedSize = "Mediana";
        } else if (grandeRadioButton.isSelected()) {
            selectedSize = "Grande";
        }

        // Implementa la lógica para calcular el precio según el tamaño seleccionado
        double precio = calcularPrecioSegunTamaño(selectedSize);

        // Actualiza la etiqueta del precio en tu interfaz gráfica
        lblTotal.setText(String.valueOf(total + precio));
    }

    private double calcularPrecioSegunTamaño(String size) {
        // Aquí implementa la lógica para calcular el precio según el tamaño seleccionado
        // Por ejemplo, podrías tener un mapa o una lista de precios por tamaño y buscar el precio correspondiente.
        // Ejemplo:
        double precio = 0.0;
        if ("Pequeña".equals(size)) {
            precio = 50.0;
        } else if ("Mediana".equals(size)) {
            precio = 80.0;
        } else if ("Grande".equals(size)) {
            precio = 100.0;
        }
        return precio;
    }
}
