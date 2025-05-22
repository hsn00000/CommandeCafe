package com.example.tp_1_android;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Attributs
    private Button addCoffeeButton, removeCoffeeButton, orderButton;
    private TextView quantityTextView, priceTextView;
    private Spinner spinnerOrders;

    private CoffeeOrder coffeeOrder;
    private ArrayList<CoffeeOrder> ListCoffeeOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Instanciation de l'objet CoffeeOrder
        addCoffeeButton = findViewById(R.id.button_plus);
        removeCoffeeButton = findViewById(R.id.button_moins);
        quantityTextView = findViewById(R.id.textView_quantity);
        priceTextView = findViewById(R.id.textView_prix);
        orderButton = findViewById(R.id.button_order);
        spinnerOrders = findViewById(R.id.spinner_orders);

        // Initialisation de la liste des commandes
        ListCoffeeOrders = new ArrayList<>();
        // Initialisation de la liste des commandes
        ArrayAdapter<CoffeeOrder> adapter = new  ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ListCoffeeOrders);
        // Créez un adaptateur pour le Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Associez l'adaptateur au Spinner
        spinnerOrders.setAdapter(adapter);

        coffeeOrder = new CoffeeOrder(0, 2.5); // 2.5 est le prix d'un café


        // Initialisation de la quantité de café
        addCoffeeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                coffeeOrder.addCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));

                }
        });

        // Suppression d'un café
        removeCoffeeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                coffeeOrder.removeCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));

            }
        });

        // Calcul du prix total
        orderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                double totalPrice = coffeeOrder.CalculateOrderPrice();
                priceTextView.setText(String.valueOf(totalPrice));

                // Ajout de la commande à la liste
                ListCoffeeOrders.add(coffeeOrder);

            }
        });







    }
}