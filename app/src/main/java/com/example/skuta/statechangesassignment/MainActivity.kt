package com.example.skuta.statechangesassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.coroutines.ThreadContextElement

class MainActivity : AppCompatActivity() {

   lateinit var button: Button
   lateinit var numberView: TextView
   lateinit var textView: TextView
   lateinit var editText: EditText
   lateinit var checkBox: CheckBox

   var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        numberView = findViewById(R.id.number_view)
        textView = findViewById(R.id.text_view)
        editText = findViewById(R.id.edit_text)
        checkBox = findViewById(R.id.check_box)

        button.setOnClickListener{
            textView.text = editText.text
            button.text = editText.text
            number++
            numberView.text = number.toString()

            if(checkBox.isChecked)
                Toast.makeText(this, "Box Checked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("button_text",button.text.toString())
        outState.putString("textView_text",textView.text.toString())
        outState.putInt("number",number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        number = savedInstanceState.getInt("number")
        numberView.text = number.toString()
        button.text = savedInstanceState.getString("button_text")
        textView.text = savedInstanceState.getString("textView_text")
    }
}