package com.example.walmart

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.walmart.model.Product

class ElectronicDetails : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronic_details)

        val product: Product? = intent.getSerializableExtra("product") as Product?
        product?.let { findViewById<ImageView>(R.id.rv_image).setBackgroundResource(it.image) }
        if (product != null) {
            findViewById<TextView>(R.id.rv_title).text = product.title
            findViewById<TextView>(R.id.rv_color).text = "Color: ${product.color}"
            findViewById<TextView>(R.id.rv_price).text = product.price.toString()
        }

    }
}