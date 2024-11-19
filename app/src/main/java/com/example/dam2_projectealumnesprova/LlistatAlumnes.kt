package com.example.dam2_projectealumnesprova

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
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
        val binding: ActivityLlistatAlumnesBinding = DataBindingUtil.setContentView(this, R.layout.activity_llistat_alumnes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.spinnerCurs.setAdapter(ArrayAdapter<CursEnum>(this, android.R.layout.simple_spinner_item, CursEnum.values()))

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val listItems = DataSource.listItemsViewModel

        val adapter = CustomAdapter(listItems) { item ->
            Toast.makeText(this, "Nom: ${item.nom}, Edat: ${item.edat}, Curs: ${item.curs}", Toast.LENGTH_SHORT).show()
        }

        recyclerview.adapter = adapter

        binding.button.setOnClickListener {
            val newData = listItems.filter { it.curs.toString() == binding.spinnerCurs.selectedItem.toString() }
            val newAdapter = CustomAdapter(newData) { item ->
                Toast.makeText(this, "Nom: ${item.nom}, Edat: ${item.edat}, Curs: ${item.curs}", Toast.LENGTH_SHORT).show()
            }
            recyclerview.adapter = newAdapter
        }
    }
}