package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView



    private var operand: Double = 0.0
    private var operation: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.clearButton).setOnClickListener {
            operand = 0.0
            operation = ""
            resultTextView.text = "0"
        }

        findViewById<TextView>(R.id.deleteButton).setOnClickListener() {
            val text = resultTextView.text.toString().removeSuffix(".0")
            if (text.isNotEmpty()) {
                resultTextView.text = text.dropLast(1).removeSuffix(".0")
            } else if (text.isEmpty()){
                resultTextView.text = operand.toString().removeSuffix(".0")
            }
        }





    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0"){
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
               operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }

    }

    fun equalsClick(view: View) {

        val sec0perandText: String = resultTextView.text.toString()
        var sec0perand: Double = 0.0

        if (!TextUtils.isEmpty(sec0perandText)) {
            sec0perand = sec0perandText.toDouble()
        }


            when (operation) {
                "+" -> resultTextView.text = (operand + sec0perand).toString().removeSuffix(".0")
                "-" -> resultTextView.text = (operand - sec0perand).toString().removeSuffix(".0")
                "*" -> resultTextView.text = (operand * sec0perand).toString().removeSuffix(".0")
                "/" -> resultTextView.text = (operand / sec0perand).toString().removeSuffix(".0")
                "%" -> resultTextView.text = ((operand * sec0perand)/100).toString().removeSuffix(".0")
            }

    }



}