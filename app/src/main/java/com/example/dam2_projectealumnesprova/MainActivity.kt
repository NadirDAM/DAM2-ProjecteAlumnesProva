package com.example.dam2_projectealumnesprova

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.dam2_projectealumnesprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.spinnerCurs.setAdapter(ArrayAdapter<CursEnum>(this, android.R.layout.simple_spinner_item, CursEnum.values()));

        binding.button4.setOnClickListener {
            println("gello1")
            System.out.println("gello1")

            startActivity(Intent(applicationContext, LlistatAlumnes::class.java))
        }

        binding.button3.setOnClickListener {
            println("gell2")
            System.out.println("gello2")

                DataSource.setItemToArray(binding.editTextNom.text.toString(), binding.editTextEdat.text.toString(),
                    CursEnum.getCursByText(binding.spinnerCurs.selectedView.toString()))

        }
    }
}