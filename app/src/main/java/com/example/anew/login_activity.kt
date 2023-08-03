package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anew.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login_activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth:FirebaseAuth
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            intent=Intent(this,MainActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener(){
            val email=binding.emaillgin.text.toString()
            val password=binding.passwordlgin.text.toString()
            if(email.isNotEmpty()&&password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                }
            }
            else Toast.makeText(this,"Feilds cannot be empty",Toast.LENGTH_SHORT).show()
        }
        binding.etsignup.setOnClickListener(){
            intent = Intent(this, signup_activity::class.java)
            startActivity(intent)
        }
        binding.etforgetpwd.setOnClickListener(){
            intent = Intent(this,Forget_password::class.java)
            startActivity(intent)
        }
    }
}