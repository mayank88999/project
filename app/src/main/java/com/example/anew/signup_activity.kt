package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.example.anew.databinding.ActivitySignupBinding as ActivitySignupBinding1

class signup_activity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding1
private lateinit var firebaseauth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= com.example.anew.databinding.ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth= FirebaseAuth.getInstance()
        binding.signupbtn.setOnClickListener(){
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            val confirm=binding.confPassword.text.toString()
            if(email!=null&&password!=null&&confirm!=null){
                if(password==confirm){
                    firebaseauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                        if(it.isSuccessful){
                            intent= Intent(this,MainActivity::class.java)
                            intent.putExtra("Details",email)
                            startActivity(intent)
                        }
                        else Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                    }
                }
                else Toast.makeText(this,"password do not match",Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this,"feilds cannot be empty",Toast.LENGTH_SHORT).show()
        }
        binding.etlogin.setOnClickListener(){
            intent=Intent(this,login_activity::class.java)
            startActivity(intent)
        }
    }
}