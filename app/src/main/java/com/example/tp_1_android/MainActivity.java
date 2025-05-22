package com.example.tp_1_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Attributs
    private Button addCoffeeButton, removeCoffeeButton, orderButton;
    private TextView quantityTextView, priceTextView;

    private CoffeeOrder coffeeOrder;

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
        addCoffeeButton = findViewById(R.id.button_moins);
        removeCoffeeButton = findViewById(R.id.button_plus);
        quantityTextView = findViewById(R.id.textView_quantity);
        priceTextView = findViewById(R.id.textView_prix);
        orderButton = findViewById(R.id.button_order);

        coffeeOrder = new CoffeeOrder(0, 2.5); // 2.5 est le prix d'un café


        addCoffeeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                coffeeOrder.addCoffee();
                }
        });



    }
}