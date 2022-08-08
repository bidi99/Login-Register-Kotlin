package com.example.tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.tema.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var binding : ActivityRegisterBinding
    private var name = ""
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()


        binding.logintext.setOnClickListener {
            onBackPressed()
        }
        binding.btnReg.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        name = binding.nametext.text.toString().trim()
        email = binding.emailtext.text.toString().trim()
        password = binding.passwordtext.text.toString().trim()
        val cpassword = binding.cpasswordtext.text.toString().trim()

        if(name.isEmpty()){
            Toast.makeText(this,"Enter your name", Toast.LENGTH_SHORT).show()
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "invalid email pattern", Toast.LENGTH_SHORT).show()
        }
        else if(password.isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
        }
        else if(cpassword.isEmpty()){
            Toast.makeText(this, "Confirm password", Toast.LENGTH_SHORT).show()
        }
        else if (password != cpassword){
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
        }
        else{
            createUserAccout()
        }
    }
    private fun createUserAccout() {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                updateUserInfo()
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener { e->

                Toast.makeText(this, "Failed creating account due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun updateUserInfo() {
        val uid = firebaseAuth.uid
        //crearea unui hashmap cu datele introduse de catre utilizator
        val hashMap : HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"] = email
        hashMap["name"] = name

        //incarcarea datelor in baza de date
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RegisterActivity,ImageActivity::class.java))
                finish()
            }
            .addOnFailureListener { e->
                Toast.makeText(this, "Failed saving user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}