/**
 * @author Walter Saldaña #19897
 *
 * Programa que lleva el conteo de vueltas recorridas por el usuario
 * Permite: Contar el numero vueltas y reiniciarlas,
 * mostrar reconocimentos al alcanzar media meta o al completar la meta (20 vueltas)
 * mostrar vueltas faltantes para el siguiente reconocimiento*/

package com.miempresa.personal.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**Atributo de clase: contador Int
     * Se en carga de llevar la cuenta del número de vueltas
     * */
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Declaración e instancia de objetos de la Vista
         */
        val txtNumero: TextView = findViewById(R.id.idTextView)
        val btnVuelta: Button = findViewById(R.id.button)
        val btnReinicio: Button = findViewById(R.id.button2)
        val imgView: ImageView = findViewById(R.id.imageView)

        /**
         * Listener tipo Lambda:
         * Ejecuta el código al presionar el boton "Vuelta"
         */
        btnVuelta.setOnClickListener{
            if(i<20){ i++ } //Si el contador es menor a la meta sumar una vuelta
            txtNumero.setText(i.toString())

            //El siguiente bloque IF evalúa el número de vueltas que el usuario lleva
            //Dependiento el número de vueltas se cambiará la imagen y se mostrará un mensaje Toast
            if(i ==10){
                imgView.setImageResource(R.drawable.silver)
                Toast.makeText(this,"FELICIDADES LLEVAS 10 VUELTAS",Toast.LENGTH_SHORT).show()
            }else if(i>10 && i<20){
                imgView.setImageResource(R.drawable.silver)
            }else if(i == 20){
                imgView.setImageResource(R.drawable.gold)
                Toast.makeText(this,"FELICIDADES LO LOGRASTE",Toast.LENGTH_SHORT).show()
            }else{
                imgView.setImageResource(R.drawable.blank)
            }
        }
        /**
         * Listener de click largo para el boton "Vuelta"
         * Evalúa el número de vueltas restantes al usuario para ganar el siguiente reconocimiemto
         * Se ejecuta al mantener presionado el boton vuelta
         */
        btnVuelta.setOnLongClickListener {
            var res = 10
            //Evaluar cuál es el siguiente reconocimiento (por llegar a 10 o por terminar las 20 vueltas)
            if(i<10){
                res = 10-i //Valor del siguiente reconocimiento menos lo que el usuario lleva
            }else{
                res = 20-i //Valor del siguiente reconocimiento menos lo que el usuario lleva
            }
            Toast.makeText(this,"Faltan $res vueltas",Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
        /**
         * Listener del boton "Reinicio"
         * Vuelve al estado inicial de la aplicación
         */
        btnReinicio.setOnClickListener(){
            i = 0
            txtNumero.setText("0")
            imgView.setImageResource(R.drawable.blank)
        }
    }
}
