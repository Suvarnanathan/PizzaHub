package com.example.pizza_loop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuList extends AppCompatActivity implements PizzaAdapter.OnItemClickListner {

    Button next;
    private static final String URL_DATA = "http://172.20.10.4:8080/demo/all";
    RecyclerView recyclerView;
    PizzaAdapter adapter;

    List<Pizza> productslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        next=(Button)findViewById(R.id.nxt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent innn=new Intent(MenuList.this,FullDetails.class);
                startActivity(innn);
            }
        });

        productslist = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadRecyclerviewData();

    }


    private void loadRecyclerviewData(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray products  = new JSONArray(response);

                    for (int i =0; i<products.length(); i++){

                        JSONObject productobject  = products.getJSONObject(i);

                        int pizzaId = productobject.getInt("pizzaId");
                        String name = productobject.getString("name");
                        String details = productobject.getString("details");
                        Double price = productobject.getDouble("price");
                        String imageURL = productobject.getString("imageUrl");

                        Pizza product = new Pizza(pizzaId, name,details,price,imageURL);
                        productslist.add(product);

                    }
                    adapter = new PizzaAdapter(MenuList.this, productslist);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemCliclListener(MenuList.this);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MenuList.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MenuList.this, error.getMessage(), Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
    @Override
    public void onItemClick(int position) {

        Intent detailintent = new Intent(this, FullDetails.class);
        Pizza clickItem = productslist.get(position);

        detailintent.putExtra("NAME", clickItem.getName());
        detailintent.putExtra("DETAILS", clickItem.getDetails());
        detailintent.putExtra("PRICE", clickItem.getPrice());
        detailintent.putExtra("IMG", clickItem.getImageURL());

        startActivity(detailintent);

    }
}


