package com.example.walmart

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class NewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

    }

    fun create(view: View) {
        var fName = findViewById<TextInputEditText>(R.id.firstName)?.text.toString()
        var lName = findViewById<TextInputEditText>(R.id.lastName)?.text.toString()
        var newEmail = findViewById<TextInputEditText>(R.id.textEmail).toString()
        var newPass = findViewById<TextInputEditText>(R.id.textPwd)?.text.toString()

        if (fName != "" && lName != "" && newEmail != "" && newPass != "")
            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_LONG).show()
        val rintent = intent

        val user1 = fName + "&" + lName + "&" + newEmail + "&" + newPass
        rintent.data = Uri.parse(user1)
        setResult(Activity.RESULT_OK, rintent)
        finish()
    }
}