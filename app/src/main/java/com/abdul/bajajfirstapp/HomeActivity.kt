package com.abdul.bajajfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity(), View.OnFocusChangeListener {
    lateinit var tvHome:TextView  //declaring
    lateinit var etContact: EditText
    lateinit var etEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //var name = intent.extras?.getString("sk")
        tvHome = findViewById(R.id.tvHome) //initializing
      //  tvHome.text = name

        etContact = findViewById(R.id.etContact)
        etEmail = findViewById(R.id.etEmail)


        etContact.setOnFocusChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        storeState();
    }

    //view-tool windows-file exploreer-data/data/yourpackage/sharedprefs/filename
    private fun storeState() {
        //get the data from the edittext
        var contact: String = etContact.text.toString()
        var email = etEmail.text.toString()
        //create file home_state_prefs
        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)
        //open the file in edit mode
        var editor = sharedPreferences.edit()
        //write the data to the file
        editor.putString("cont",contact)
        editor.putString("eml",email)
        //save the file
        editor.apply() //appply is asynchronous
    }


    override fun onResume() {
        super.onResume()
        restoreState();
    }

    private fun restoreState() {
        //open the file home_state
        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)
        //read the data from the file
        var contact = sharedPreferences.getString("cont","")
        var email = sharedPreferences.getString("eml","")
        //set the data into the edittexts
        etContact.setText(contact)
        etEmail.setText(email)
    }


    fun handleClick(view: android.view.View) {
        when(view.id){
            R.id.btnSend -> {  startDialer() }
            R.id.btnMain -> {startMain() }
        }
    }

    private fun startDialer() {
        var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:21345678"))  //implicit intent
        startActivity(dialIntent)
    }

    private fun startMain() {
        var intent: Intent    //kotlin says you can't have a variable as null
        intent = Intent(this, MainActivity::class.java)  //no need to give the word new
        //explicit intent -- explicitly giving the name of the class to be invoked
        intent.putExtra("ds", "divyang sharma")
        startActivityForResult(intent,123)
    }


    //result will arrive here -- photo, contact
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == 123){ //RESULT_OK means its good to consume, 123 -- data being returned is of type contact
            tvHome.text = data?.extras?.getString("con")
        }
    }

    override fun onFocusChange(p0: View?, isFocussed: Boolean) {
        if(isFocussed){
            Toast.makeText(this,"focussed",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show()

        }
    }
}