package com.example.barta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.barta.Adapters.MainAdapter;
import com.example.barta.Models.MainModel;
import com.example.barta.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.steak, "Beef Steak" ,"5" , "Testy Steak with Salad "));
        list.add(new MainModel(R.drawable.pizza, "Beef Steak" ,"5" , "Testy Steak with Salad "));
        list.add(new MainModel(R.drawable.pizza, "Beef Steak" ,"5" , "Testy Steak with Salad "));
        list.add(new MainModel(R.drawable.potato, "Beef Steak" ,"5" , "Testy Steak with Salad "));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recylerview.setAdapter(adapter);
        LinearLayoutManager layoutManager =  new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.orders:startActivity(new Intent(MainActivity.this,OrderActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
