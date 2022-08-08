package com.example.tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema.databinding.ActivityUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class UserActivity : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var binding : ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //"Deconectare"
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        //Buton playback
        binding.playback.setOnClickListener {
            startActivity(Intent(this,PlayerActivity::class.java))
        }
    }

    private fun checkUser() {
        val uid = firebaseAuth.uid
        //cale baza de date
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!).get().addOnSuccessListener {
            //alocare date specifice utilizatorului pentru afisarea lor
            val name = it.child("name").value
            binding.nameTv.text = name.toString()
            val email = it.child("email").value
            binding.emailTv.text = email.toString()
            val cale1 = it.child("Image1").value
            if(cale1 == "image1"){
                binding.imageView1.setImageResource(resources.getIdentifier("image1", "drawable",
                    packageName
                ))
            }
            val cale3 = it.child("Image3").value
            if(cale3 == "image3"){
                binding.imageView3.setImageResource(
                    resources.getIdentifier("image3", "drawable",
                    packageName
                ))
            }
            val cale4 = it.child("Image4").value
            if(cale4 == "image4"){
                binding.imageView4.setImageResource(resources.getIdentifier("image4", "drawable",
                    packageName
                ))
            }
            val cale5 = it.child("Image5").value
            if(cale5 == "image5"){
                binding.imageView5.setImageResource(
                    resources.getIdentifier("image5", "drawable",
                    packageName
                ))
            }
            val cale6 = it.child("Image6").value
            if(cale6 == "image6"){
                binding.imageView6.setImageResource(resources.getIdentifier("image6", "drawable",
                    packageName
                ))
            }
            val cale7 = it.child("Image7").value
            if(cale7 == "image7"){
                binding.imageView7.setImageResource(resources.getIdentifier("image7", "drawable",
                    packageName
                ))
            }
            val cale8 = it.child("Image8").value
            if(cale8 == "image8"){
                binding.imageView8.setImageResource(resources.getIdentifier("image8", "drawable",
                    packageName
                ))
            }
            val cale9 = it.child("Image9").value
            if(cale9 == "image9"){
                binding.imageView9.setImageResource(resources.getIdentifier("image9", "drawable",
                    packageName
                ))
            }
            val cale10 = it.child("Image10").value
            if(cale10 == "image10"){
                binding.imageView10.setImageResource(resources.getIdentifier("image10", "drawable",
                    packageName
                ))
            }
        }







//
    }
}