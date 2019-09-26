package com.example.cnp_validator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInvalidCNP.setText("")

        btnCheck.setOnClickListener {

            var textForPrint: String = ""

            val CNP = cnpInput.text.toString()
            val firstDigitCNP = cnpInput.text.toString().substring(0, 1)

            val classForCheck = ClassCheck()

            if (CNP.length == 13 && classForCheck.isValidCNP(CNP)) {

                    textForPrint += "Valid CNP" + "\n"
                    textForPrint += "Gender: " + classForCheck.getGender(firstDigitCNP) + "\n "
                    textForPrint += "Birth Place: " + classForCheck.getCityName(CNP) + "\n "
                    textForPrint += "Date Birth: " + classForCheck.getBirthDate(CNP) + "\n "
                    textForPrint += "Age: " + classForCheck.getAge(CNP).toString() + "\n "
                    textForPrint += "Major: " + classForCheck.isMajor(CNP) + "\n "
                    textForPrint += classForCheck.getIntervalYearBirth(firstDigitCNP) + "\n "
                    textInvalidCNP.setText(textForPrint)
                  

            } else {

                textInvalidCNP.setText(CNP + "is invalid.")

            }

        }
    }

}
