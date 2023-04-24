package com.zmei.a26lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zmei.a26lessons.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}