package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anew.databinding.ActivityMainBinding
import com.example.anew.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseauth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth=FirebaseAuth.getInstance()
        binding.btnlogout.setOnClickListener(){
         firebaseauth.signOut()
            startActivity(Intent(this,login_activity::class.java))
            finish()
        }
    }
}