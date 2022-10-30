package com.example.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.walmart.model.User
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var arrayOfUsers = ArrayList<User>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1 = User("bethel", "bahiru", "koki@gmail.com", "1234")
        val user2 = User("gelila", "bahiru", "gelu@gmail.com", "9089")
        val user3 = User("mami", "kassa", "mami@gmail.com", "7867")
        val user4 = User("ababi", "mulat", "ababi@gmail.com", "5678")
        val user5 = User("papi", "samuel", "papi@gmail.com", "6789")

        arrayOfUsers = arrayListOf(user1, user2, user3, user4, user5)

        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == Activity.RESULT_OK) {
                    var res = result.data?.data.toString()
                    var delimiter = "&"

                    val parts = res.split(delimiter)


                    val newUsr = User(parts[0], parts[1], parts[2], parts[3])
                    arrayOfUsers.plus(newUsr)

                    println(arrayOfUsers)
                }
                else
                    Toast.makeText(this, "Failed to get results", Toast.LENGTH_LONG).show()
            }
    }

    fun signIn(view: View) {
        val intent = Intent(this, ShoppingActivity::class.java)
        val userName = findViewById<TextInputLayout>(R.id.emailDisplay).editText?.text.toString()
        val pwd = findViewById<TextInputLayout>(R.id.pwdDisplay).editText?.text.toString()
        val bundle = Bundle();
        var authenticated = false;

        for(item in arrayOfUsers) {
            if(item.userName?.equals(userName) == true && item.password?.equals(pwd) == true) {
                bundle.putString("firstName", item.firstname)
                bundle.putString("lastName",item.lastName)
                intent.putExtras(bundle)
                authenticated = !authenticated
            }
        }

        if(authenticated) {
            startActivity(intent)
        }
    }

    fun forgotPassword(view: View) {
        val email = findViewById<TextInputLayout>(R.id.emailDisplay).editText?.text.toString()
        for(item in arrayOfUsers) {
            if(item.userName?.equals(email) == true) {
                Toast.makeText(this, "Account Found. Password is " + item.password , Toast.LENGTH_LONG).show()
                break
            }
        }
    }


    fun create(view: View) {
        val intent = Intent(this, NewUser::class.java)
        startActivity(intent)
    }


}


