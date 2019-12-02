package vistula.kr.sklepsportowy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

const val KREXTRA_MESSAGE = "vistula.kr.sklepsportowy.MESSAGE"
const val KREXTRA_MESSAGE2 = "vistula.kr.sklepsportowy.MESSAGE2"
const val KREXTRA_MESSAGE3 = "vistula.kr.sklepsportowy.MESSAGE3"
const val KREXTRA_MESSAGE4 = "vistula.kr.sklepsportowy.MESSAGE4"

class MainActivity : AppCompatActivity() {

    var krSumaZamowienie : Int = 0
    var krproduktyiceny = HashMap<String, Int>() //definicja hashmapy
    var krcenaCalosci = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        krproduktyiceny["buty"] = 100
        krproduktyiceny["rower"] = 2000
        krproduktyiceny["silnik"] = 1500
        krproduktyiceny["żaglówka"] = 500

        //Tworzenie pustej tablicy array wypełnionej nullami
        var krspinnerVal = arrayOfNulls<String>(krproduktyiceny.size)

        var krn  = 0
        //foreach po tablicy i konkatenacja stringu i inta
        krproduktyiceny.forEach {

                (krk, krv) -> krspinnerVal[krn] = ("$krk: cena $krv")
            krn++

        }

        var krtowarySpinner = findViewById(R.id.krWyborSpin) as Spinner


        val kradapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,krspinnerVal)
        kradapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        // Finally, data bind the spinner object with adapter
        krtowarySpinner.adapter = kradapter

    }

    fun krSumujZamowienie (view: View) {
        var krtowarySpinner2 = findViewById(R.id.krWyborSpin) as Spinner
        var kraktualnyWybor : String = krtowarySpinner2.selectedItem.toString()
        var kraktualnaIlosc : String = findViewById<EditText>(R.id.krIloscTB).text.toString()
        var krwyszukajWTablicy : String = kraktualnyWybor.substringBefore(delimiter = ":", missingDelimiterValue = "Not Found")
        var krCenaDoLiczenia = krproduktyiceny.getValue(krwyszukajWTablicy)
        var krCenaDoWstawienia = krCenaDoLiczenia * kraktualnaIlosc.toInt()
        var krAktualna_Lista_Towarów : String = findViewById<EditText>(R.id.krListaTowarowET).text.toString()
        krAktualna_Lista_Towarów = krAktualna_Lista_Towarów + kraktualnyWybor + " x " + kraktualnaIlosc + " = " + krCenaDoWstawienia  + "\n"

        val krlistatowarow = findViewById<EditText>(R.id.krListaTowarowET)
        krlistatowarow.setText(krAktualna_Lista_Towarów)

        krcenaCalosci = krcenaCalosci + krCenaDoWstawienia

        val krcalaCena = findViewById<EditText>(R.id.krCenaSumaET)
        krcalaCena.setText(krcenaCalosci.toString())


    }

    fun krnextactivyty(view: View){

        val krnameText = findViewById<EditText>(R.id.krImieTB)
        val krnazwiskoText = findViewById<EditText>(R.id.krNazwiskoTB)
        val krcenaSumaryczna = findViewById<EditText>(R.id.krCenaSumaET)
        val krzamowienie = findViewById<EditText>(R.id.krListaTowarowET)


        val intent = Intent(this, KrZamowienie::class.java).apply {
            putExtra(KREXTRA_MESSAGE,krnameText.text.toString())
            putExtra(KREXTRA_MESSAGE2,krnazwiskoText.text.toString())
            putExtra(KREXTRA_MESSAGE3,krcenaSumaryczna.text.toString())
            putExtra(KREXTRA_MESSAGE4,krzamowienie.text.toString())


        }
        startActivity(intent)

    }
}
