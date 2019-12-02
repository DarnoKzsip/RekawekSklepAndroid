package vistula.kr.sklepsportowy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class KrZamowienie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_zamowienie)

        val krmessage1 = intent.getStringExtra(KREXTRA_MESSAGE)
        val krmessage2 = intent.getStringExtra(KREXTRA_MESSAGE2)
        val krmessage3 = intent.getStringExtra(KREXTRA_MESSAGE3)
        val krmessage4 = intent.getStringExtra(KREXTRA_MESSAGE4)

        val krimieView = findViewById<TextView>(R.id.krImieTB).apply {
            text = krmessage1
        }

        val krnazwiskoView = findViewById<TextView>(R.id.krNazwiskoET).apply {
            text = krmessage2
        }
        val krcenaView = findViewById<TextView>(R.id.krCenaSum).apply {
            text = krmessage3
        }

        val krcalosczamowieniaView = findViewById<TextView>(R.id.krZamowineMulti).apply {
            text = krmessage4
        }




    }
}
