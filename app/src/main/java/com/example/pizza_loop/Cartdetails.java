package com.example.pizza_loop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Cartdetails extends AppCompatActivity {
    TextView Name;
    TextView qty;
    Button confirm;
    Button Cancel;
    Button total;
    TextView op;
    TextView pric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdetails);

       /* Name=(TextView)findViewById(R.id.pizzaname);*/
        qty=(TextView)findViewById(R.id.PizzaQTY);
        confirm=(Button)findViewById(R.id.confirm);
        Cancel=(Button)findViewById(R.id.cancel);
        total=(Button)findViewById(R.id.totalprice);
        op=(TextView)findViewById(R.id.output);
        pric=(TextView)findViewById(R.id.prices);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ine=new Intent(Cartdetails.this,MainActivity.class);
                startActivity(ine);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(Cartdetails.this,PaymentDetails.class);
                startActivity(inn);

            }
        });
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneStr = qty.getText().toString();
                int qtyInt = Integer.parseInt(oneStr);

                String twostr = pric.getText().toString();
                int pricInt = Integer.parseInt(twostr);

                int tota=pricInt*qtyInt;
                op.setText(tota);

            }
        });
    }
}
