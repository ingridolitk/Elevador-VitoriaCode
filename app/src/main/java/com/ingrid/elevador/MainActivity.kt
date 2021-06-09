package com.ingrid.elevador

import Elevador
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import Pessoa
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var opc = findViewById<EditText>(R.id.opcao)
        var circle = findViewById<TextView>(R.id.circle)
        var btnEntrar = findViewById<Button>(R.id.btnEntrar)
        var btnSair = findViewById<Button>(R.id.btnSair)
        var btnAndar = findViewById<Button>(R.id.btnAndar)
        var novaPessoa = Pessoa()
        var novoElevador = Elevador()
        var exibirAndar = findViewById<TextView>(R.id.exibirAndar)

        btnAndar.setOnClickListener() {
            opc = findViewById<EditText>(R.id.opcao)
            /*  if (novoElevador.entrarNoElevador(opc,this) == false) {
                  Toast.makeText(this,"Entre no elevador antes de ir para o andar", Toast.LENGTH_SHORT).show()
              }*/
            if (novoElevador.validarAndar(opc, this)) {

                val novaPessoa = Pessoa()
                circle.text = opc.text.toString() + "° andar"
                Toast.makeText(this, "Entre no elevador", Toast.LENGTH_SHORT).show()
                novaPessoa.selecionarAndar(opcao = opc.text.toString().toInt())
                circle.text = opc.text.toString() + "° andar"
            }
        }
        btnEntrar.setOnClickListener() {
            if (novoElevador.entrarNoElevador(opc, this)) {
                novoElevador.entrarElevador(pessoa = novaPessoa)
                Toast.makeText(
                    this,
                    "Quantidade de Pessoas: " + novoElevador.totalPessoas().toString(),
                    Toast.LENGTH_SHORT
                ).show()
                // circle.text = opc.text.toString() + "° andar"
                exibirAndar.text =
                    novoElevador.totalPessoas().toString() + "/10"
            }
        }
        btnSair.setOnClickListener() {
            if (novoElevador.sairElevador(opc, this)) {
                novoElevador.sairElevador(pessoa = novaPessoa)
                Toast.makeText(
                    this,
                    "Quantidade de Pessoas: " + novoElevador.totalPessoas().toString(),
                    Toast.LENGTH_SHORT
                ).show()
                exibirAndar.text =
                    novoElevador.totalPessoas().toString() + "/10"
            }
        }
    }
}