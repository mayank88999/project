package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.example.anew.databinding.ActivityForgetPasswordBinding
import com.example.anew.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class Forget_password : AppCompatActivity() {
    private lateinit var binding: ActivityForgetPasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        binding.resetbtn.setOnClickListener() {
            val fpemail = binding.forgetpswddemail.text.toString()

            if (fpemail != null) {
                if (Patterns.EMAIL_ADDRESS.matcher(fpemail).matches()) {
                    firebaseAuth.sendPasswordResetEmail(fpemail).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
                            intent = Intent(this, login_activity::class.java)
                            startActivity(intent)
                        }
                    }
                } else {
                    Toast.makeText(this, "Email is not correct", Toast.LENGTH_SHORT).show()
                }
            } else Toast.makeText(this, "email feild cannot be empty", Toast.LENGTH_SHORT).show()
        }
        binding.cancelbtn.setOnClickListener(){
            intent = Intent(this, login_activity::class.java)
            startActivity(intent)
        }
    }
}