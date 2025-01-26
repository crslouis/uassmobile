package com.example.akiraquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView cardVoopoo, cardSmok, cardCaliburn, cardGeekvape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize CardViews
        initializeViews();

        // Setup click listeners
        setupClickListeners();
    }

    private void initializeViews() {
        // Find CardViews by their IDs
        cardVoopoo = findViewById(R.id.cardVoopoo);
        cardSmok = findViewById(R.id.cardSmok);
        cardCaliburn = findViewById(R.id.cardCaliburn);
        cardGeekvape = findViewById(R.id.cardGeekvape);
    }

    private void setupClickListeners() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.cardVoopoo) {
                    showProductDetails("VOOPOO DRAG X", "Rp. 350.000");
                } else if (v.getId() == R.id.cardSmok) {
                    showProductDetails("SMOK NORD 4", "Rp. 280.000");
                } else if (v.getId() == R.id.cardCaliburn) {
                    showProductDetails("CALIBURN A2", "Rp. 200.000");
                } else if (v.getId() == R.id.cardGeekvape) {
                    showProductDetails("GEEKVAPE AEGIS", "Rp. 400.000");
                }
            }
        };

        cardVoopoo.setOnClickListener(clickListener);
        cardSmok.setOnClickListener(clickListener);
        cardCaliburn.setOnClickListener(clickListener);
        cardGeekvape.setOnClickListener(clickListener);
    }

    private void showProductDetails(String productName, String price) {
        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
        intent.putExtra("product_name", productName);
        intent.putExtra("product_price", price);

        // Set the correct image resource based on the product
        int imageResId = R.drawable.liquid1; // default
        switch (productName) {
            case "VOOPOO DRAG X":
                imageResId = R.drawable.liquid1;
                break;
            case "SMOK NORD 4":
                imageResId = R.drawable.liquid2;
                break;
            case "CALIBURN A2":
                imageResId = R.drawable.liquid3;
                break;
            case "GEEKVAPE AEGIS":
                imageResId = R.drawable.liquid4;
                break;
        }

        intent.putExtra("product_image", imageResId);
        startActivity(intent);
    }
}