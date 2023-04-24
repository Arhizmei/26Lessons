package com.zmei.a26lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zmei.a26lessons.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditBinding
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,)
    private var index = 0
    private var indexImage = 0
    private var imageId = R.drawable.plant1
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButton()
    }
    private fun initButton() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if (indexImage>imageIdList.size-1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
                    }
        bDone.setOnClickListener {
            val plant = Plant(imageId, edTitle.text.toString(), edDisk.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
                            }
            setResult(RESULT_OK, editIntent)
            finish()
        }

    }

}