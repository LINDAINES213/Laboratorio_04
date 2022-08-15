package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Permite al usuario lanzar un dado y ver el resultado en la pantalla
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }
        rollDice()
    }

    /**
     * Lanza el dado y actualiza la pantalla con el nuevo resultado
     */
    private fun rollDice() {
        // Crea un nuevo dado con 6 caras y lo lanza
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Actualiza la pantalla con el lanzamiento del dado
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determina que ID de la imagen usa basado en el resultado del lanzamiento del dado
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Actualiza la imagen con el ID correcto de la imagen
        diceImage.setImageResource(drawableResource)

        //Actualiza el contenido de la descripcion
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}