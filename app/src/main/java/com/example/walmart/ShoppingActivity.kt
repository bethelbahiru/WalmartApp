package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val firstName = intent.getExtras()?.getString("firstName")
        val lastName = intent.getExtras()?.getString("lastName")
        val display = findViewById<TextView>(R.id.name)
        display.setText("Welcome " + firstName + " " +lastName)

    }

    fun food(view: View) {
        Toast.makeText(this, "You have selected Food Category", Toast.LENGTH_LONG).show()
    }

    fun electronics(view: View) {
        Toast.makeText(view.context, "You have selected Electronics Category", Toast.LENGTH_LONG).show()
    }

    fun clothing(view: View) {
        Toast.makeText(view.context, "You have selected Clothing Category", Toast.LENGTH_LONG).show()
    }

    fun beauty(view: View) {
        Toast.makeText(view.context, "You have selected Beauty Category", Toast.LENGTH_LONG).show()
    }
}