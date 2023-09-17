package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel jPanelPrincipal;
    private JComboBox comboBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btbPreparPizza;

    private List<Topping> ingredientes = new ArrayList<>();

    private DefaultListModel modeloLista = new DefaultListModel();

    private double total = 0.0;
    public JPanel getjPanelPrincipal() {
        return jPanelPrincipal;
    }


    public frmPizza() {
        cargarToppings();
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


        btbPreparPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtPizza.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la pizza");
                    return;
                }
                if (lista1.getModel().getSize() == 0){
                    JOptionPane.showMessageDialog(null, "Debe ingresar al menos un ingrediente");
                    return;
                }

                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i< lista1.getModel().getSize(); i++){
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();
            }
        });
    }



    //cargar toppings
    private void cargarToppings() {
        ingredientes.add(new Topping("Champiñones", 10));
        ingredientes.add(new Topping("Mozzarella", 11));
        ingredientes.add(new Topping("Cebolla", 6));
        ingredientes.add(new Topping("Tomate", 9));
        ingredientes.add(new Topping("Pepperoni", 15));
        ingredientes.add(new Topping("Bacon", 18));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);

    }
}
