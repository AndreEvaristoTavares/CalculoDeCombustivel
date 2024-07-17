package com.example.consumodecombustivel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: View) {
        val valorCombustivel = findViewById<EditText>(R.id.text_preco).text.toString().toDoubleOrNull()
        val consumoMedio = findViewById<EditText>(R.id.text_consumo).text.toString().toDoubleOrNull()
        val km = findViewById<EditText>(R.id.text_km).text.toString().toDoubleOrNull()

        val resultado = findViewById<TextView>(R.id.text_resultado)

        if (valorCombustivel != null && consumoMedio != null && km != null) {
            val res = (km / consumoMedio) * valorCombustivel
            resultado.text = "Valor: R$ ${"%.2f".format(res)} R$"
        } else {
            resultado.text = "Por favor, preencha todos os campos corretamente."
        }
    }
}