package com.example.imcalert

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.calbutton)


        button.setOnClickListener {
            // Retrieve the EditText fields
            val poidsField = findViewById<EditText>(R.id.poids)
            val tailleField = findViewById<EditText>(R.id.taille)

            // Check if the fields are not empty
            if (poidsField.text.isNotBlank() && tailleField.text.isNotBlank()) {
                val poids = poidsField.text.toString().toDoubleOrNull()
                val taille = tailleField.text.toString().toDoubleOrNull()

                // Ensure the values are valid and within range
                if (poids != null && taille != null) {
                    if (poids in 20.0..300.0 && taille in 1.0..2.5) {
                        //val customLayout = layoutInflater.inflate(R.layout.alert, null)
                        val builder = AlertDialog.Builder(this)
                        //builder.setView(customLayout)
                        builder.setTitle("Résultat IMC")
                        val IMC = poids / (taille * taille)
                        builder.setMessage("Votre IMC est : " + String.format("%.2f", IMC))
                        builder.setPositiveButton("OUI") { dialog, _ ->
                            val intent = Intent(this, IMCresult::class.java)
                            intent.putExtra("IMC", IMC)
                            startActivity(intent)}
                        builder.setNegativeButton("Annuler") { dialog, _ ->
                            Toast.makeText(this, "NON", Toast.LENGTH_SHORT).show()
                        }
                        builder.setNeutralButton("QUITTER"){_,_ -> finish() }
                        builder.show()}
                    else {
                        Toast.makeText(this,"Veuillez entrer des valeurs valide pour la taille et le poids ",Toast.LENGTH_LONG).show()
                    }
                }
                else {
                    Toast.makeText(this, "Entrer une valeur valide", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this,"entrer voitre poids et taille",Toast.LENGTH_SHORT).show()
            }
        }
    }
}