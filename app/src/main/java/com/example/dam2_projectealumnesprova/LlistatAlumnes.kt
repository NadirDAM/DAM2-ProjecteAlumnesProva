package com.example.dam2_projectealumnesprova

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dam2_projectealumnesprova.databinding.ActivityLlistatAlumnesBinding
import com.example.dam2_projectealumnesprova.databinding.ActivityMainBinding

class LlistatAlumnes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_llistat_alumnes)
        val binding : ActivityLlistatAlumnesBinding = DataBindingUtil.setContentView(this, R.layout.activity_llistat_alumnes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.spinnerCurs.setAdapter(ArrayAdapter<CursEnum>(this, android.R.layout.simple_spinner_item, CursEnum.values()));
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel

        // This will pass the ArrayList to our Adapter
        var adapter = CustomAdapter(DataSource.listItemsViewModel)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        binding.button.setOnClickListener{
            val newData = DataSource.listItemsViewModel.filter { it.curs.toString()  == binding.spinnerCurs.selectedItem.toString() }
            adapter = CustomAdapter(newData);
            recyclerview.adapter = adapter
        }

    }
}