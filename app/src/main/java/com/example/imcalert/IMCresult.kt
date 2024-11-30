package com.example.imcalert

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IMCresult : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "DefaultLocale", "SetTextI18n", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_imcresult)


        val afficheIMC = findViewById<TextView>(R.id.resultIMC)
        val affichenot = findViewById<TextView>(R.id.resultNOTE)
        val coment = findViewById<TextView>(R.id.coment)

        val IMC = intent.getDoubleExtra("IMC",0.0)
        afficheIMC.text = String.format("%.2f", IMC)


        when (IMC){
            in 0.0..18.5 -> {affichenot.setText("Poids insuffisant")
                affichenot.setTextColor(Color.RED)
                coment.setText(
                    "Vous êtes en insuffisance ponderale." +
                            "\nvoici quelques recommandations :" +
                            "\n1.consulter un professionnel de la santé" +
                            "\n2.augmenter l'apport calorique." +
                            "\n3.consommer des repas fréquentes " +
                            "\n4.faire des exercices de rangement musculaire.")}

            in 18.5..24.9 -> {affichenot.setText("Poids normal")
                affichenot.setTextColor(Color.GREEN)
                coment.setText("Vous avez un poids normal." +
                        "\nvoici quelques recommandations: " +
                        "\n1.maintenir un mode de vie équilibré." +
                        "\n2.pratiquer une activité physique régulière." +
                        "\n3.surveiller votre poids.")}
            in 25.0..29.9 -> {affichenot.setText("Surpoids")
                affichenot.setTextColor(Color.YELLOW)
                coment.setText("Vous êtes en surpoids." +
                        "\nvoici quelques recommandations:" +
                        "\n1.réduire l'apport calorique." +
                        "\n2.augmenter l'activité physique." +
                        "\n3.consulter un professionnel de la santé.")}
            in 30.0..34.9 -> {affichenot.setText("Obésité modéré")
                affichenot.setTextColor(Color.parseColor("#800080"))
                coment.setText("Vous avez une obésité modérée." +
                        "\nvoici quelques recommandations." +
                        "\n1.consulter un professionnel de la santé " +
                        "\n2.adopter un régime alimentaire structuré" +
                        "\n3.augmenter l'activité physique " +
                        "\n4.surveiller des conditions de santé associés.")}
            in 35.0..39.9 -> {affichenot.setText("Obésité sévére")
                affichenot.setTextColor(Color.RED)
                coment.setText("Vous avez une obésité sévère. " +
                        "\nvoici quelques recommandations:" +
                        "\nconsulter un professionnel de la santé." +
                        "\nadopter un régime alimentaire sous surveillance " +
                        "\nparticiper à un programme de perte de poids. " +
                        "\nsuperviser surveiller et traiter les comorbidités")}
            in 40.0..99.9 -> {affichenot.setText("Obésité morbide")
                affichenot.setTextColor(Color.RED)
                coment.setText("Vous avez une obésité morbide, " +
                        "\nvoici quelques recommandations: " +
                        "\n1.consulter un professionnel de la santé immédiatement, " +
                        "\n2.envisager et des options médicales ou chirurgicales  " +
                        "\n3.suivre un plan de perte de poids strictes " +
                        "\n4.gérer les conditions de santé associés.")}


        }


    }
}