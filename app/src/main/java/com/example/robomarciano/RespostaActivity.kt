package com.example.robomarciano

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RespostaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resposta_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val resposta = intent.getStringExtra("resposta") ?: "Sem resposta"
        Toast.makeText(this, resposta, Toast.LENGTH_LONG).show()

        val textView = findViewById<TextView>(R.id.textViewResposta)
        textView.text = resposta

        val botaoVoltar = findViewById<Button>(R.id.buttonVoltar)
        botaoVoltar.setOnClickListener {
            finish()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}