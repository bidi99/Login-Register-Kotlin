package com.example.tema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tema.databinding.ActivityImageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ImageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = FirebaseDatabase.getInstance().getReference("Users").child(uid)

        //incarcare prin apasarea pozei , incarcarea denumirii
        binding.imageView1.setOnClickListener {
           ref.child("Image1")
               .setValue("image1")
        }
        binding.imageView3.setOnClickListener {
            ref.child("Image2")
                .setValue("image2")
        }
        binding.imageView4.setOnClickListener {
            ref.child("Image3")
                .setValue("image3")
        }
        binding.imageView5.setOnClickListener {
            ref.child("Image4")
                .setValue("image4")
        }
        binding.imageView6.setOnClickListener {
            ref.child("Image5")
                .setValue("image5")
        }
        binding.imageView7.setOnClickListener {
            ref.child("Image6")
                .setValue("image6")
        }
        binding.imageView8.setOnClickListener {
            ref.child("Image7")
                .setValue("image7")
        }
        binding.imageView9.setOnClickListener {
            ref.child("Image8")
                .setValue("image8")
        }
        binding.imageView10.setOnClickListener {
            ref.child("Image9")
                .setValue("image9")
        }

        binding.update.setOnClickListener {
            startActivity(Intent(this@ImageActivity,UserActivity::class.java))
        }
    }


}


