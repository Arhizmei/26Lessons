package com.zmei.a26lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zmei.a26lessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind : ActivityMainBinding
    private val adapter = PlantAdapter()
    private var editLauncher : ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        init()
        editLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK)
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
        }
    }

    private fun init(){
        bind.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 4)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}