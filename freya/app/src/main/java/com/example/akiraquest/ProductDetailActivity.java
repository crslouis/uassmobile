package com.example.akiraquest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Initialize views
        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageView productImage = findViewById(R.id.productImage);
        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);
        TextView productSpecs = findViewById(R.id.productSpecs);
        TextView productDescription = findViewById(R.id.productDescription);

        // Get data from intent
        String name = getIntent().getStringExtra("product_name");
        String price = getIntent().getStringExtra("product_price");
        int imageResId = getIntent().getIntExtra("product_image", 0);

        // Set product details
        productName.setText(name);
        productPrice.setText(price);
        productImage.setImageResource(imageResId);

        // Set specifications and description based on product
        setProductDetails(name, productSpecs, productDescription);

        // Set back button click listener
        btnBack.setOnClickListener(v -> finish());
    }

    private void setProductDetails(String productName, TextView specs, TextView description) {
        String specifications = "";
        String desc = "";

        switch (productName) {
            case "VOOPOO DRAG X":
                specifications = "• Battery: Single 18650\n" +
                        "• Power Range: 5-80W\n" +
                        "• Display: 0.96\" TFT Screen\n" +
                        "• Charging: Type-C 5V/2A\n" +
                        "• Pod Capacity: 4.5ml";

                desc = "The VOOPOO DRAG X is a powerful pod mod featuring the GENE.TT chipset, " +
                        "offering exceptional performance and versatility. Perfect for both MTL and " +
                        "DTL vaping styles, with adjustable airflow and compatible with PnP coils.";
                break;

            case "SMOK NORD 4":
                specifications = "• Battery: 2000mAh Built-in\n" +
                        "• Power Range: 5-80W\n" +
                        "• Display: 0.69\" OLED\n" +
                        "• Charging: Type-C\n" +
                        "• Pod Capacity: 4.5ml";

                desc = "The SMOK Nord 4 is the latest iteration of the popular Nord series, " +
                        "featuring improved battery life and power output. With adjustable wattage " +
                        "and various coil options, it's perfect for any vaping style.";
                break;

            // Add other cases for remaining products
        }

        specs.setText(specifications);
        description.setText(desc);
    }
}