package com.example.directmessagewhatsapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var number:EditText
    lateinit var message:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       button = findViewById(R.id.buttonsend)
    number= findViewById(R.id.edtnumber)
         message= findViewById(R.id.edtmess)
        button.setOnClickListener {
            if(number.text.isNotEmpty() && message.text.isNotEmpty()){
                val packageManager : PackageManager = packageManager
                val i = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + number.text.toString() + "&text="+ URLEncoder.encode(message.text.toString(),"UTF-8")
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if(i.resolveActivity(packageManager) != null){
                  startActivity(i)
               }
                else{
                    Toast.makeText(this, "Whats App Not Installed !!", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Please Enter Msg Or Number !!", Toast.LENGTH_LONG).show()
            } }
    }

    }
