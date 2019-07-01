package com.example.pizza_loop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PaymentDetails extends AppCompatActivity {
  ImageView Cashondeliver;
    ImageView Cashoncard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
        Cashondeliver=(ImageView)findViewById(R.id.cashondeliver);
        Cashoncard=(ImageView)findViewById(R.id.cashoncard);

        Cashoncard.setImageResource(R.drawable.capture);
        Cashoncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(PaymentDetails.this,CardpaymentDetails.class);
                startActivity(inten);
            }
        });
        Cashondeliver.setImageResource(R.drawable.capture2);
        Cashondeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"Thank You for ordering . Receive your order within thirty mins.",Toast.LENGTH_SHORT).show();

            }
        });



    }
}
